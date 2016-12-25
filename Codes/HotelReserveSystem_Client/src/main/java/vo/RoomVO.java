package vo;

import po.RoomType;

/**
 * 空房的VO类,负责在逻辑层和界面层传递数据
 * @author 双
 * @version
 * @see
 */
public class RoomVO {
    
    public Enum<RoomType> roomType;
    public int roomNum;
    public int roomPrice;
    public String address;
    
    public RoomVO(Enum<RoomType> roomType, int roomNum, int roomPrice, String address){
        this.roomType=roomType;
        this.roomNum=roomNum;
        this.roomPrice=roomPrice;
        this.address=address;
    }
    
    public RoomVO(Enum<RoomType> roomType, int roomNum, String address){
        this.roomType=roomType;
        this.roomNum=roomNum;
        this.address=address;
    }
    
}
