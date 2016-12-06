package businesslogic.roombl;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import businesslogic.roombl.updateCheckOut.AvailableRoomService;
import businesslogicservice.orderblservice.ResultMessage;
import dataservice.roomDAO.RoomDAO;
import factory.FactoryService;
import factory.FactoryServiceImpl;
import po.OrderState;
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
    
    private AvailableRoomService availableRoomService;
    
    private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");   
    
    private FactoryService factoryService;
    
    public RoomInfoServiceImpl() {
        roomDAO=RemoteHelper.getInstance().getRoomDAO();
        factoryService=new FactoryServiceImpl();
        availableRoomService=factoryService.createAvailableRoomService();
    }
    
    @Override
    public int getAvailableRoomNum(String address, Enum<RoomType> roomType, Date day) throws RemoteException {
        //得到对应房间类型的空房信息
        RoomPO roomPO=roomDAO.getSpareRoomInfo(address, roomType, day);
        //得到空房信息的房间数
        return roomPO.getRoomNum();
    }

    @Override
    public boolean isTimeAvailable(String address, Enum<RoomType> roomType, Date date, int num) throws RemoteException {
        int spareRoomNum=getAvailableRoomNum(address, roomType, date);
        if(spareRoomNum<num){
            return false;
        }
        return true;
    }

    @Override
    public ResultMessage checkOrder(OrderVO vo) throws RemoteException {
        //先判断预订入住时间段是否满足在未来一周内，防御式编程
        Date today=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        try {
            today=sdf.parse(sdf.format(today));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DATE, 6);
        Date availbleEndTime=calendar.getTime();
        //如果预订时间不在未来一周内，返回null
        if(!(vo.beginDate.compareTo(today)>=0&&vo.beginDate.compareTo(vo.finishDate)<=0&&vo.finishDate.compareTo(availbleEndTime)<=0)){
            return null;
        }
        
        int spareRoomNum;
        calendar.setTime(vo.beginDate);
        Date day= calendar.getTime();
        //判断房间是否满足，即订单预订当天的空房数量是否足够
        int todaySpareRoomNum=getAvailableRoomNum(vo.hotelAddress, vo.roomType, vo.beginDate);
        if(todaySpareRoomNum==0){
            return ResultMessage.TYPE_CANNOT_SATISFIED;
        }
        if(todaySpareRoomNum<vo.num){
            return ResultMessage.NUM_CANNOT_SATISFIED;
        }
        //遍历未来6天的空房列表，看看每天的空房数是否能满足订单需求,如果不满足，返回时间不能满足
        while(day.compareTo(vo.finishDate)!=0){
            calendar.add(Calendar.DATE, 1);//+1今天的时间加一天
            day= calendar.getTime();
            spareRoomNum=getAvailableRoomNum(vo.hotelAddress, vo.roomType, vo.beginDate);
            if(spareRoomNum<vo.num){
                return ResultMessage.TIME_CANNOT_SATISFIED;
            }
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
                calendar.add(Calendar.DATE, i);//+1今天的时间加一天
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
        HotelVO hotelVO = availableRoomService.getHotelDetails(address);
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

    @Override
    public ResultMessage checkOrder(String hotelAddress, RoomType roomType, int num, Date beginDate, Date finishDate)
            throws RemoteException {
        OrderVO orderVO=new OrderVO("", "", "", hotelAddress, beginDate, finishDate, roomType, num, 0, OrderState.ABNORMAL_ORDER, new Date(), new Date(), 0, false, true, false);
        return checkOrder(orderVO);
    }
}
