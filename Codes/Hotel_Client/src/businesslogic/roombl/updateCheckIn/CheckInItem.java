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
    boolean addCheckIn(String address){
        RoomPO checkInPO=new CheckInOutPO(roomType, roomNum, address, checkInTime, expDepartTime);
        try {
            checkInDAO.insert(checkInPO);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    /**
     * 修改 入住信息
     * @param address string型，酒店地址
     * @return 返回是否修改成功
     * @see
     */
    boolean modifyCheckIn(String address){
        RoomPO checkInPO=new CheckInOutPO(roomType, roomNum, address, checkInTime, expDepartTime);
        try {
            checkInDAO.update(checkInPO);;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    /**
     * 删除入住信息
     * @param address string型，酒店地址
     * @return 返回是否删除成功
     * @see
     */
    boolean delCheckIn(String address){
        RoomPO checkInPO=new CheckInOutPO(roomType, roomNum, address, checkInTime, expDepartTime);
        try {
            checkInDAO.delete(checkInPO);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    /**
     * 判断该入住信息是否有效
     * @return 返回是否入住信息有效
     * @see
     */
    boolean validCheckIn(){
        return false;
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