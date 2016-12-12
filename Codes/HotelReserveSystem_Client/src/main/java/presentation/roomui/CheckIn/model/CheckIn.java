package presentation.roomui.CheckIn.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import po.RoomType;

public class CheckIn {

    private final StringProperty roomType;
    private final StringProperty roomNum;
    private final StringProperty checkInTime;
    private final StringProperty expDepartTime;
    
    private SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    public CheckIn(Enum<RoomType> roomType, int roomNum, Date checkInTime, Date expDepartTime){
        this.roomType=new SimpleStringProperty(roomType.name());
        this.roomNum=new SimpleStringProperty(String.valueOf(roomNum));
        this.checkInTime=new SimpleStringProperty(dateFormat.format(checkInTime));
        this.expDepartTime=new SimpleStringProperty(dateFormat.format(expDepartTime));
    }
    
    public StringProperty roomTypeProperty(){
        return roomType;
    }
    
    public StringProperty roomNumProperty(){
        return roomNum;
    }
    
    public StringProperty checkInTimeProperty(){
        return checkInTime;
    }
    
    public StringProperty expDepartTimeProperty(){
        return expDepartTime;
    }
    
    public void setRoomType(String roomTypeShowed){
        String roomType="";
        if(roomTypeShowed.equals("单人间")){
            roomType=RoomType.SINGLE_ROOM.name();
        }else if(roomTypeShowed.endsWith("标准间")){
            roomType=RoomType.STANDARD_ROOM.name();
        }else if(roomTypeShowed.endsWith("三人间")){
            roomType=RoomType.TRIBLE_ROOM.name();
        }else{
            roomType=RoomType.KING_SIZE_ROOM.name();
        }
        this.roomType.set(roomType);
    }
    
    public void setRoomNum(int roomNum){
        this.roomNum.set(String.valueOf(roomNum));
    }
    
    public void setCheckInTime(Date date, int hour, int minute){
        String dateStr=dateFormat.format(date);
        dateStr=dateStr+" "+hour+":"+minute+":00";
        this.checkInTime.set(dateStr);
    }
    
    public void setExpDepartTime(Date date, int hour, int minute){
        String dateStr=dateFormat.format(date);
        dateStr=dateStr+" "+hour+":"+minute+":00";
        this.expDepartTime.set(dateStr);
    }
    
    public Enum<RoomType> getRoomType(){
        return RoomType.valueOf(roomType.get());
    }
    
    public int getRoomNum(){
        return Integer.parseInt(roomNum.get());
    }
    
    public Date getCheckInTime() throws ParseException{
        return dateFormat.parse(checkInTime.get());
    }
    
    public Date getExpDepartTime() throws ParseException{
        return dateFormat.parse(expDepartTime.get());
    }
       
}
