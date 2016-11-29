package businesslogic.roombl;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import businesslogic.hotelbl.HotelInfoService;
import businesslogicservice.orderblservice.ResultMessage;
import dataservice.roomDAO.RoomDAO;
import po.RoomPO;
import po.RoomType;
import rmi.RemoteHelper;
import vo.HotelVO;
import vo.OrderVO;
import vo.RoomVO;

/**
 * 
 * @author 双
 * @version 
 * @see
 */
public class RoomInfoServiceImpl implements RoomInfoService{

    private RoomDAO roomDAO;
    
    private HotelInfoService hotelInfoService;
    
    private SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-DD");
    
    public RoomInfoServiceImpl() {
        roomDAO=RemoteHelper.getInstance().getRoomDAO();
    }
    
    @Override
    public int getAvailableRoomNum(String address, Enum<RoomType> roomType, Date day) throws RemoteException {
        //得到对应房间类型的空房信息
        RoomPO roomPO=roomDAO.getSpareRoomInfo(address, roomType, day);
        //得到空房信息的房间数
        return roomPO.getRoomNum();
    }

    @Override
    public boolean isTimeAvailable(String address, Enum<RoomType> roomType, Date date, int num) {
        Date today=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-DD");
        try {
            today=sdf.parse(sdf.format(today));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DAY_OF_MONTH, 6);
        Date availbleEndTime=calendar.getTime();
        if(beginDate.compareTo(today)>=0&&beginDate.compareTo(finishDate)<=0&&finishDate.compareTo(availbleEndTime)<=0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public ResultMessage checkOrder(OrderVO vo) throws RemoteException {
        //先判断预订入住时间段是否满足在未来一周内
        boolean availble=isTimeAvailable(vo.hotelAddress, vo.roomType, vo.beginDate, vo.finishDate);
        if(!availble){
            return ResultMessage.TIME_CANNOT_SATISFIED;
        }
        int spareRoomNum;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(vo.beginDate);
        Date day= calendar.getTime();
        //遍历未来7天的空房列表，看看每天的空房数是否能满足订单需求
        while(day.compareTo(vo.finishDate)!=0){
            spareRoomNum=getAvailableRoomNum(vo.hotelAddress, vo.roomType, vo.beginDate);
            if(spareRoomNum==0){
                return ResultMessage.TYPE_CANNOT_SATISFIED;
            }
            if(spareRoomNum<vo.num){
                return ResultMessage.NUM_CANNOT_SATISFIED;
            }
            calendar.add(Calendar.DAY_OF_MONTH, 1);//+1今天的时间加一天
            day= calendar.getTime();
        }
        return ResultMessage.SUCCEED;
    }

    @Override
    public boolean updateSpareRoom(String address, RoomVO roomvo) throws RemoteException {
        //取得当天空房列表
        Date today=new Date();
        try {
            today=sdf.parse(sdf.format(today));
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        ArrayList<RoomPO> todaySpareRoomList=roomDAO.getSpareRoomInfoList(address, today);
        //看空房列表是否存在该房间类型
        boolean roomTypeExist=false;
        for(RoomPO roomPO:todaySpareRoomList){
            if(roomPO.getRoomType()==roomvo.roomType){
                roomTypeExist=true;
            }
        }
        //有则调用更新空房的方法
        if(roomTypeExist){
            Date day=today;
            Calendar calendar = Calendar.getInstance();
            for(int i=0;i<7;i++){
                calendar.setTime(today);
                calendar.add(Calendar.DAY_OF_MONTH, i);//+1今天的时间加一天
                day= calendar.getTime();
                roomDAO.updateRoom(toPO(roomvo), day);
            }
        }else{
        //无则调用增加空房的方法
            roomDAO.insertRoom(toPO(roomvo));
        }
        return true;
    }

    @Override
    public boolean reduceRoom(String address, int change, Enum<RoomType> roomType, Date day) throws RemoteException {
        //调用更新空房的方法减少空房数量
        RoomPO spareRoomPO=roomDAO.getSpareRoomInfo(address, roomType, day);
        int finalRoomNum=spareRoomPO.getRoomNum()-change;
        //如果减少后空房数小于0，则返回错误
        if(finalRoomNum<0)
            return false;
        spareRoomPO.setRoomNum(finalRoomNum);
        roomDAO.updateRoom(spareRoomPO, day);
        return true;
    }

    @Override
    public boolean addRoom(String address, int change, Enum<RoomType> roomType, Date day) throws RemoteException {
        //调用更新空房的方法增加空房数量
        RoomPO spareRoomPO=roomDAO.getSpareRoomInfo(address, roomType, day);
        int finalRoomNum=spareRoomPO.getRoomNum()+change;
        //检查添加房间后的空房数是否大于可用客房数
        HotelVO hotelVO = hotelInfoService.getHotelDetails(address);
        HashMap<RoomType, Integer> roomTypeAndNums = hotelVO.roomTypeAndNums;
        int availableRoomNum=roomTypeAndNums.get(roomType);
        if(finalRoomNum>availableRoomNum){
            return false;
        }
        spareRoomPO.setRoomNum(finalRoomNum);
        roomDAO.updateRoom(spareRoomPO, day);
        return true;
    }

    @Override
    public ArrayList<RoomVO> getSpareRoomList(String address) throws RemoteException {
        Date today=new Date();
        try {
            today=sdf.parse(sdf.format(today));
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        ArrayList<RoomPO> spareRoomList=roomDAO.getSpareRoomInfoList(address, today);
        ArrayList<RoomVO> spareRoomVOs=new ArrayList<>();
        for(RoomPO roomPO:spareRoomList){
            spareRoomVOs.add(toVO(roomPO));
        }
        return spareRoomVOs;
    }

    private RoomVO toVO(RoomPO roomPO){
        return new RoomVO(roomPO.getRoomType(), roomPO.getRoomNum(), roomPO.getRoomPrice(), roomPO.getAddress());
    }
    
    private RoomPO toPO(RoomVO roomVO){
        return new RoomPO(roomVO.roomType, roomVO.roomNum, roomVO.roomPrice, roomVO.address);
    }
}
