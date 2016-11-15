package businesslogic.hotelbl.importNewRoom;

import java.util.ArrayList;

import po.RoomType;
import vo.RoomVO;

public class MockAvailableRoomList extends AvailableRoomList {

	private String hotelAddress;

	public MockAvailableRoomList(String hotelAddress) {
		super(hotelAddress);
		this.hotelAddress = hotelAddress;
	}
	
	@Override
	public ArrayList<RoomVO> getAvailableRoomList() {
		RoomVO roomVO1 = new RoomVO(RoomType.KING_SIZE_ROOM, 20, this.hotelAddress);
		RoomVO roomVO2 = new RoomVO(RoomType.SINGLE_ROOM, 40, this.hotelAddress);
		RoomVO roomVO3 = new RoomVO(RoomType.STANDARD_ROOM, 30, this.hotelAddress);
		ArrayList<RoomVO> availableRoomList = new ArrayList<>();
		availableRoomList.add(roomVO1);
		availableRoomList.add(roomVO2);
		availableRoomList.add(roomVO3);
		return availableRoomList;
	}
	
}
