package vo;

import java.util.Date;

import po.RoomType;

public class CheckInOutVO extends RoomVO{

    public Date checkInTime;
    public Date expDepartTime;
    public Date actDepartTime;
    
    public CheckInOutVO(Enum<RoomType> roomType, int roomNum, String address, Date checkInTime, Date expDepartTime){
        super(roomType, roomNum, address);
        this.checkInTime=checkInTime;
        this.expDepartTime=expDepartTime;
    }
    
    public CheckInOutVO(Enum<RoomType> roomType, int roomNum, String address, Date actDepartTime){
        super(roomType, roomNum, address);
        this.actDepartTime=actDepartTime;
    }
}
