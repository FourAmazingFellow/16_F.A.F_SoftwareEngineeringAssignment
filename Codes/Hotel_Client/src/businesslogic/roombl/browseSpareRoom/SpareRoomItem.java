package businesslogic.roombl.browseSpareRoom;

import po.RoomPO;
import po.RoomType;

/**
 * 
 * @author 双
 * @version 
 * @see
 */
public class SpareRoomItem {
     
    private Enum<RoomType> roomType;
    private int roomNum;
    private double roomPrice;
    private String address;
    
    /**
     * 
     * @param roomType RoomType枚举类，房间类型
     * @param roomNum int型，空房数量
     * @param roomPrice double型，房间价格
     * @param address string型，酒店地址
     */
    public SpareRoomItem(Enum<RoomType> roomType, int roomNum, double roomPrice, String address) {
        super();
        this.roomType = roomType;
        this.roomNum = roomNum;
        this.roomPrice = roomPrice;
        this.address = address;
    }
    
    
}
