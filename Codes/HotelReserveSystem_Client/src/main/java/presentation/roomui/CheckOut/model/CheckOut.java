package presentation.roomui.CheckOut.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import po.RoomType;
import vo.CheckOutVO;

public class CheckOut {
    
    private final StringProperty roomType;
    private final StringProperty roomNum;
    private final StringProperty actDepartTime;
    
    private SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    public CheckOut(){
        this(null,0,null);
    }
    
    public CheckOut(Enum<RoomType> roomType, int roomNum, Date actDepartTime){
        this.roomType=new SimpleStringProperty(RoomType.enumToChinese(roomType));
        this.roomNum=new SimpleStringProperty(String.valueOf(roomNum));
        this.actDepartTime=new SimpleStringProperty(dateFormat.format(actDepartTime));
    }
    
    public StringProperty roomTypeProperty(){
        return roomType;
    }
    
    public StringProperty roomNumProperty(){
        return roomNum;
    }
    
    public StringProperty actDepartTimeProperty(){
        return actDepartTime;
    }
    
    public void setRoomType(Enum<RoomType> roomType){
        String roomTypeStr=roomType.name();
        this.roomType.set(roomTypeStr);
    }
    
    public void setRoomNum(int roomNum){
        this.roomNum.set(String.valueOf(roomNum));
    }
    
    public void setActDepartTime(Date date, int hour, int minute){
        String dateStr=dateFormat.format(date);
        dateStr=dateStr+" "+hour+":"+minute+":00";
        this.actDepartTime.set(dateStr);
    }
    
    public Enum<RoomType> getRoomType(){
        return RoomType.chineseToEnum(roomType.get());
    }
    
    public int getRoomNum(){
        return Integer.parseInt(roomNum.get());
    }
    
    public Date getActDepartTime() throws ParseException{
        return dateFormat.parse(actDepartTime.get());
    }
    
    public CheckOutVO toVO(String address) throws ParseException{
        return new CheckOutVO(getRoomType(), getRoomNum(),address, getActDepartTime());
    }
}