package bl_Stub.roomblservice_Stub;

import java.util.ArrayList;

import businesslogicservice.roomblservice.BrowseSpareRoomService;
import po.RoomType;
import vo.RoomVO;

/**
 * 
 * @author 双
 * @version 
 * @see
 */
public class BrowseSpareRoomServiceImpl_Stub implements BrowseSpareRoomService{

    public Enum<RoomType> roomType;
    public int roomNum;
    public int roomPrice;
    public String address;
    
    public BrowseSpareRoomServiceImpl_Stub(Enum<RoomType> roomType, int roomNum, int roomPrice, String address) {
        this.roomType = roomType;
        this.roomNum = roomNum;
        this.roomPrice = roomPrice;
        this.address = address;
    }

    @Override
    public ArrayList<RoomVO> getRoomInfoList(String address) {
        RoomVO roomvo=new RoomVO(roomType, roomNum, roomPrice, address);
        ArrayList<RoomVO> arrayList=new ArrayList<RoomVO>();
        arrayList.add(roomvo);
        return arrayList;
    }

}
