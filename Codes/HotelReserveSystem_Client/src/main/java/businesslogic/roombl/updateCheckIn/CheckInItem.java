package businesslogic.roombl.updateCheckIn;

import java.rmi.RemoteException;
import java.util.Date;

import dataservice.roomDAO.RoomDAO;
import po.CheckInOutPO;
import po.RoomPO;
import po.RoomType;
import vo.CheckInOutVO;
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
    
    public CheckInItem(){
        
    }
    /**
     * 
     * @param roomPO RoomPO型，入住信息
     */
    public CheckInItem(RoomPO roomPO) {
        super();
        CheckInOutPO checkInPO=(CheckInOutPO)roomPO;
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
        super();
        CheckInOutVO checkInVO=(CheckInOutVO)roomVO;
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
        RoomPO checkInPO=new CheckInOutPO(roomType, roomNum, address, checkInTime, expDepartTime);
        try {
            checkInDAO.insertRoom(checkInPO);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
        //根据布尔值决定是否更新空房
        
        return true;
    }
    
    /**
     * 判断该入住信息是否有效
     * @return 返回是否入住信息有效
     * @see
     */
    public boolean validCheckIn(){
        //roomNum小于空房数量大于0
        //入住时间大于等于当前时间
        //预计离开时间大于入住时间
        return true;
    }
    
    /**
     * 转成CheckInOutVO型
     * @return RoomVO型，包含入住信息
     * @see
     */
    public RoomVO toVO(){
        return new CheckInOutVO(roomType, roomNum, address, checkInTime, expDepartTime);
    }
}
