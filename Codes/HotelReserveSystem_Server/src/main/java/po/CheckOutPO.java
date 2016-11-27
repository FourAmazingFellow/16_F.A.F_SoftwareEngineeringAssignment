package po;

import java.util.Date;

public class CheckOutPO extends RoomPO{

    /**
     * 
     */
    private static final long serialVersionUID = -6285215757115159539L;
    private Date actDepartTime;

    public CheckOutPO(Enum<RoomType> roomType, int roomNum, String address, Date actDepartTime) {
        super(roomType, roomNum, address);
        this.actDepartTime = actDepartTime;
    }

    public Date getActDepartTime() {
        return actDepartTime;
    }

    public void setActDepartTime(Date actDepartTime) {
        this.actDepartTime = actDepartTime;
    }

}
