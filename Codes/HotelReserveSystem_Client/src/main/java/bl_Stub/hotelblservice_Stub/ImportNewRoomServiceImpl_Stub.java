package bl_Stub.hotelblservice_Stub;

import java.util.ArrayList;

import businesslogicservice.hotelblservice.ImportNewRoomService;
import po.RoomType;
import vo.RoomVO;

public class ImportNewRoomServiceImpl_Stub implements ImportNewRoomService{

	public Enum<RoomType> roomType;
	public int roomNum;
	public int roomPrice;
	public String address;
	 
	public ImportNewRoomServiceImpl_Stub(Enum<RoomType> roomType, int roomNum, int roomPrice, String address) {
		this.roomType = roomType;
		this.roomNum = roomNum;
		this.roomPrice = roomPrice;
		this.address = address;
	}
	@Override
	public ArrayList<RoomVO> getAvailableRoomList(String address) {
		ArrayList<RoomVO> roomVOList = new ArrayList<>();
		roomVOList.add(new RoomVO(roomType, roomNum, address));
		return roomVOList;
	}

	@Override
	public boolean addRoom(RoomVO room) {
		return true;
	}

}
