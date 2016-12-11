package presentation.roomui.spareRoom.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import po.RoomType;

/**
 *  Model class for a SpareRoomItem.
 * @author 双
 * @version 
 * @see
 */
public class SpareRoom {

    private final StringProperty roomType;
    private final StringProperty roomNum;
    private final StringProperty roomPrice;
    
    public SpareRoom(Enum<RoomType> roomType,int roomNum, int roomPrice){
        this.roomType=new SimpleStringProperty(roomType.name());
        this.roomNum=new SimpleStringProperty(String.valueOf(roomNum));
        this.roomPrice=new SimpleStringProperty(String.valueOf(roomPrice));
    }
    
    public StringProperty roomTypeProperty(){
        return roomType;
    }
    
    public StringProperty roomNumProperty(){
        return roomNum;
    }
    
    public StringProperty roomPriceProperty(){
        return roomPrice;
    }

    /*
    public String getRoomType(){
        return roomType.get();
    }
    
    public void setRoomType(Enum<RoomType> roomType){
        this.roomType.set(roomType.name());
    }
    
    public String getRoomNum(){
        return roomNum.get();
    }
    
    public void setRoomNum(int roomNum){
        this.roomNum.set(String.valueOf(roomNum));
    }
    
    public String getRoomPrice(){
        return roomPrice.get();
    }
    
    public void setRoomPrice(int roomPrice){
        this.roomPrice.set(String.valueOf(roomPrice));
    }
    */
}
