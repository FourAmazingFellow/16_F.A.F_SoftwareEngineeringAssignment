package po;

import java.sql.Date;

/**
 * 
 * @author 双
 * @version 
 * @see
 */
public class CheckInOutPO extends RoomPO{
    
    private Date checkInTime;
    private Date expDepartTime;
    private Date actDepartTime;
    
    public CheckInOutPO(Enum<RoomType> roomType, int roomNum, Date checkInTime, Date expDepartTime){
        super(roomType, roomNum);
        this.checkInTime=checkInTime;
        this.expDepartTime=expDepartTime;
    }
    
    public CheckInOutPO(Enum<RoomType> roomType, int roomNum, Date actDepartTime){
        super(roomType, roomNum);
        this.actDepartTime=actDepartTime;
    }
    
    public Date getCheckInTime() {
        return checkInTime;
    }
    public void setCheckInTime(Date checkInTime) {
        this.checkInTime = checkInTime;
    }
    public Date getExpDepartTime() {
        return expDepartTime;
    }
    public void setExpDepartTime(Date expDepartTime) {
        this.expDepartTime = expDepartTime;
    }
    public Date getActDepartTime() {
        return actDepartTime;
    }
    public void setActDepartTime(Date actDepartTime) {
        this.actDepartTime = actDepartTime;
    }
    
}
