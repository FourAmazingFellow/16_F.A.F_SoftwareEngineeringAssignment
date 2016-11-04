package businesslogic.roombl.updateCheckOut;

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
public class CheckOutItem {

    private Enum<RoomType> roomType;
    private int roomNum;
    private String address;
    private Date actDepartTime;
    
    /**
     * 
     * @param roomPO RoomPO型，退房信息
     */
    public CheckOutItem(RoomPO roomPO) {
        super();
        CheckInOutPO CheckOutPO=(CheckInOutPO)roomPO;
        this.roomType = CheckOutPO.getRoomType();
        this.roomNum = CheckOutPO.getRoomNum();
        this.address = CheckOutPO.getAddress();
        this.actDepartTime = CheckOutPO.getActDepartTime();
    }
    
    /**
     * 
     * @param roomVO RoomVO型，退房信息
     */
    public CheckOutItem(RoomVO roomVO){
        super();
        CheckInOutVO CheckOutVO=(CheckInOutVO)roomVO;
        this.roomType = CheckOutVO.roomType;
        this.roomNum = CheckOutVO.roomNum;
        this.address = CheckOutVO.address;
        this.actDepartTime = CheckOutVO.actDepartTime;
    }
    
    /**
     * 增加退房信息
     * @param address string型，酒店地址
     * @return
     * @see
     */
    boolean AddCheckOut(String address){
        return false;
        
    }
    
    /**
     * 修改 退房信息
     * @param address string型，酒店地址
     * @return 返回是否修改成功
     * @see
     */
    boolean ModifyCheckOut(String address){
        return false;
        
    }
    
    /**
     * 删除退房信息
     * @param address string型，酒店地址
     * @return 返回是否删除成功
     * @see
     */
    boolean delCheckOut(String address){
        return false;
        
    }
    
    /**
     * 判断该退房信息是否有效
     * @return 返回是否退房信息有效
     * @see
     */
    boolean validCheckOut(){
        return false;
        
    }
}

