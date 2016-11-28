package businesslogic.roombl.updateCheckIn;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

import businesslogic.roombl.RoomInfoService;
import businesslogic.roombl.RoomInfoServiceImpl;
import businesslogic.roombl.browseSpareRoom.NoThisRoomTypeSpareRoomException;
import businesslogic.roombl.browseSpareRoom.SpareRoomList;
import businesslogic.strategybl.exception.WrongInputException;
import businesslogic.strategybl.updateStrategy.StrategyItem;
import dataservice.roomDAO.RoomDAO;
import po.CheckInPO;
import po.RoomPO;
import po.RoomType;
import rmi.RemoteHelper;
import vo.CheckInVO;
import vo.RoomVO;

/**
 * 
 * @author 双
 * @version 
 * @see
 */
public class CheckInItem {

    private Enum<RoomType> roomType;
    private int roomNum;
    private String address;
    private Date checkInTime;
    private Date expDepartTime;
    
    private RoomDAO checkInDAO;
    private RoomInfoService roomInfoService;
    private StrategyItem strategyItem;
    private SpareRoomList spareRoomList;
    
    public CheckInItem(){
        checkInDAO=RemoteHelper.getInstance().getRoomDAO();
        roomInfoService=new RoomInfoServiceImpl();
    }
    /**
     * 
     * @param roomPO RoomPO型，入住信息
     */
    public CheckInItem(RoomPO roomPO) {
        this();
        CheckInPO checkInPO=(CheckInPO)roomPO;
        this.roomType = checkInPO.getRoomType();
        this.roomNum = checkInPO.getRoomNum();
        this.address = checkInPO.getAddress();
        this.checkInTime = checkInPO.getCheckInTime();
        this.expDepartTime = checkInPO.getExpDepartTime();
    }
    
    /**
     * 
     * @param roomVO RoomVO型，入住信息
     */
    public CheckInItem(RoomVO roomVO){
        this();
        CheckInVO checkInVO=(CheckInVO)roomVO;
        this.roomType = checkInVO.roomType;
        this.roomNum = checkInVO.roomNum;
        this.address = checkInVO.address;
        this.checkInTime = checkInVO.checkInTime;
        this.expDepartTime = checkInVO.expDepartTime;
    }
    
    /**
     * 增加入住信息
     * @param address string型，酒店地址
     * @return
     * @see
     */
    public boolean addCheckIn(String address, boolean updateSpareRoom){
        CheckInPO checkInPO=new CheckInPO(roomType, roomNum, address, checkInTime, expDepartTime);
        try {
            checkInDAO.insertCheckIn(checkInPO);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
        //根据布尔值决定是否更新空房
        if(updateSpareRoom){
            roomInfoService.reduceRoom(address, roomNum, roomType);
        }
        return true;
    }
    
    /**
     * 判断该入住信息是否有效
     * @return 返回是否入住信息有效
     * @throws WrongInputException 
     * @see
     */
    public boolean validCheckIn() throws WrongInputException{
        //格式验证
        
        //验证地址
        if (address.length() > 50 || address.length() < 1) {
            throw new WrongInputException("the address can't be longer than 50 characters");
        }
        //调用strategyItem的isRightName方法验证地址名称是否正确
        strategyItem=new StrategyItem();
        if(!strategyItem.isRightName(address)){
            throw new WrongInputException("the address only includes number,letter, Chinese characters and underline");
        }
        
        //验证房间数为正整数
        if(roomNum<=0){
            throw new WrongInputException("the number of room should large than 0");
        }
        
        //验证时间是否合法，如果入住时间必须在当天内，预计离开时间大于入住时间，则错误
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if(sdf.format(checkInTime)!=sdf.format(new Date())){
            throw new WrongInputException("check-in time must be today");
        }
        if(expDepartTime.compareTo(checkInTime)<=0){
            throw new WrongInputException("expected depart time should be earlier than the Check-in time");
        }
        
        //非格式验证
        
        //验证该房间类型是否有空房
        spareRoomList=SpareRoomList.getInstance(address);
        try {
            if(spareRoomList.getSprareRoomInfo(address, roomType)==null){
                return false;
            }
        } catch (NoThisRoomTypeSpareRoomException e) {
            throw new WrongInputException(e.getMessage());
        }
        
        //roomNum小于空房数量
        int spareRoomNum=roomInfoService.getAvailableRoomNum(address, roomType);
        if(roomNum>spareRoomNum){
            throw new WrongInputException("the room number of check-in is larger than the spare Room number");
        }
        return true;
    }
    
    /**
     * 转成CheckInOutVO型
     * @return RoomVO型，包含入住信息
     * @see
     */
    public RoomVO toVO(){
        return new CheckInVO(roomType, roomNum, address, checkInTime, expDepartTime);
    }
}
