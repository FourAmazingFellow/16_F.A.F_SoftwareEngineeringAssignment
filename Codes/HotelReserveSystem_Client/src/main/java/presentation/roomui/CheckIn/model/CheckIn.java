package presentation.roomui.CheckIn.model;

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
}
