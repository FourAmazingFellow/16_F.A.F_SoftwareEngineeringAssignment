package vo;

import java.util.Date;

import po.RoomType;

public class CheckInVO extends RoomVO{

    public Date checkInTime;
    public Date expDepartTime;
    
    public CheckInVO(Enum<RoomType> roomType, int roomNum, String address, Date checkInTime, Date expDepartTime){
        super(roomType, roomNum, address);
        this.checkInTime=checkInTime;
        this.expDepartTime=expDepartTime;
    }
}
