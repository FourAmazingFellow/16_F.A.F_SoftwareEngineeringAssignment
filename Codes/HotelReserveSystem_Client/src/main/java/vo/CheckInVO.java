package vo;

import java.util.Date;

import po.RoomType;

/**
 * 入住信息的vo,负责在逻辑层和界面层传递数据
 * @author 双
 * @version 
 * @see
 */
public class CheckInVO extends RoomVO{

    public Date checkInTime;
    public Date expDepartTime;
    
    public CheckInVO(Enum<RoomType> roomType, int roomNum, String address, Date checkInTime, Date expDepartTime){
        super(roomType, roomNum, address);
        this.checkInTime=checkInTime;
        this.expDepartTime=expDepartTime;
    }
}
