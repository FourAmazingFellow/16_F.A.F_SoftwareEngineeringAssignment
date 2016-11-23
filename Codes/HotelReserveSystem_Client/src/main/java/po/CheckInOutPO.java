package po;

import java.util.Date;

/**
 * 入住退房信息PO（继承酒店房间信息RoomPO），负责持久化数据传输
 * @author 双
 * @version 
 * @see
 */
public class CheckInOutPO extends RoomPO{
    /**
	 * 
	 */
	private static final long serialVersionUID = -5123885900595460789L;
	
	
	private Date checkInTime;
    private Date expDepartTime;
    private Date actDepartTime;
    
    public CheckInOutPO(Enum<RoomType> roomType, int roomNum, String address, Date checkInTime, Date expDepartTime){
        super(roomType, roomNum, address);
        this.checkInTime=checkInTime;
        this.expDepartTime=expDepartTime;
    }
    
    public CheckInOutPO(Enum<RoomType> roomType, int roomNum, String address, Date actDepartTime){
        super(roomType, roomNum, address);
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
