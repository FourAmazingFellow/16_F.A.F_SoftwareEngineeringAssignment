package vo;

import java.util.Date;

import po.RoomType;

/**
 * 退房信息的VO类,负责在逻辑层和界面层传递数据
 * @author 双
 * @version 
 * @see
 */
public class CheckOutVO extends RoomVO{

    public Date actDepartTime;
    
    public CheckOutVO(Enum<RoomType> roomType, int roomNum, String address, Date actDepartTime){
        super(roomType, roomNum, address);
        this.actDepartTime=actDepartTime;
    }
}
