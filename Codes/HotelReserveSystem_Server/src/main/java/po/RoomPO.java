package po;

/**
 * 酒店房间信息PO，负责持久化数据传输
 * @author 双
 * @version 
 * @see
 */
public class RoomPO {
    
    private Enum<RoomType> roomType;
    private int roomNum;
    private int roomPrice;
    private String address;
    
    public RoomPO(Enum<RoomType> roomType, int roomNum, int roomPrice, String address){
        this.roomType=roomType;
        this.roomNum=roomNum;
        this.roomPrice=roomPrice;
        this.address=address;
    }
    
    public RoomPO(Enum<RoomType> roomType, int roomNum, String address){
        this.roomType=roomType;
        this.roomNum=roomNum;
        this.address=address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
}
