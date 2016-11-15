package businesslogic.hotelbl.importNewRoom;

import vo.RoomVO;

public class MockAvailableRoomItem extends AvailableRoomItem {

	public MockAvailableRoomItem(String address) {
		super(address);
	}
	
	@Override
	public boolean addRoom(RoomVO room) {
		return true;
	}
	
}
