package po;

/**
 * 
 * @author 双
 * @version 
 * @see
 */
public class RoomPO {
    
    private Enum<RoomType> roomType;
    private int roomNum;
    private int roomPrice;
    
    public RoomPO(Enum<RoomType> roomType, int roomNum, int roomPrice){
        this.roomType=roomType;
        this.roomNum=roomNum;
        this.roomPrice=roomPrice;
    }
    
    public RoomPO(Enum<RoomType> roomType, int roomNum){
        this.roomType=roomType;
        this.roomNum=roomNum;
    }
    
    public Enum<RoomType> getRoomType() {
        return roomType;
    }
    public void setRoomType(Enum<RoomType> roomType) {
        this.roomType = roomType;
    }
    public int getRoomNum() {
        return roomNum;
    }
    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }
    public int getRoomPrice() {
        return roomPrice;
    }
    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }
    
}
