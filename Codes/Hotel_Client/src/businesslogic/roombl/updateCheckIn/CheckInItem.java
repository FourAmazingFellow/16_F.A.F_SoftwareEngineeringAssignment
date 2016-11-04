package businesslogic.roombl.updateCheckIn;

import java.util.Date;

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
    boolean AddCheckIn(String address){
        return false;
        
    }
    
    /**
     * 修改 入住信息
     * @param address string型，酒店地址
     * @return 返回是否修改成功
     * @see
     */
    boolean ModifyCheckIn(String address){
        return false;
        
    }
    
    /**
     * 删除入住信息
     * @param address string型，酒店地址
     * @return 返回是否删除成功
     * @see
     */
    boolean delCheckIn(String address){
        return false;
        
    }
    
    /**
     * 判断该入住信息是否有效
     * @return 返回是否入住信息有效
     * @see
     */
    boolean validCheckIn(){
        return false;
        
    }
}
