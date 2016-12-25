package businesslogic.roombl.browseSpareRoom;

import po.RoomPO;
import po.RoomType;
import vo.RoomVO;

/**
 * 空房的Item类
 * @author 双
 * @version 
 * @see
 */
public class SpareRoomItem {
     
    private Enum<RoomType> roomType;
    private int roomNum;
    private int roomPrice;
    private String address;
    
    /**
     * 
     * @param roomType RoomType枚举类，房间类型
     * @param roomNum int型，空房数量
     * @param roomPrice double型，房间价格
     * @param address string型，酒店地址
     */
    public SpareRoomItem(Enum<RoomType> roomType, int roomNum, int roomPrice, String address) {
        super();
        this.roomType = roomType;
        this.roomNum = roomNum;
        this.roomPrice = roomPrice;
        this.address = address;
    }
    
    
    public SpareRoomItem(RoomPO roomPO){
        this.roomType = roomPO.getRoomType();
        this.roomNum = roomPO.getRoomNum();
        this.roomPrice = roomPO.getRoomPrice();
        this.address = roomPO.getAddress();
    }
    
    public SpareRoomItem(RoomVO roomVO){
        this.roomType = roomVO.roomType;
        this.roomNum = roomVO.roomNum;
        this.roomPrice = roomVO.roomPrice;
        this.address = roomVO.address;
    }
    
    /**
     * 把SpareRoomItem转成RoomVO型
     * @return 返回RoomVO型，包含房间信息
     * @see
     */
    public RoomVO toVO(){
        return new RoomVO(roomType, roomNum, roomPrice, address);
    }
}
