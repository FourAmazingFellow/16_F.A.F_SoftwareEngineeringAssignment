package vo;

import java.util.Date;

import po.RoomType;

public class CheckOutVO extends RoomVO{

    public Date actDepartTime;
    
    public CheckOutVO(Enum<RoomType> roomType, int roomNum, String address, Date actDepartTime){
        super(roomType, roomNum, address);
        this.actDepartTime=actDepartTime;
    }
}
