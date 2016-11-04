package businesslogic.hotelbl.ImportNewRoom;

import businesslogic.roombl.RoomInfoService;
import vo.RoomVO;

public class AvailableRoomItem {
	private RoomInfoService roomInfoService;
	private String address;
	
	public AvailableRoomItem(String address) {
		this.address = address;
	}
	
	public boolean addRoom(RoomVO room) {
		return roomInfoService.updateSpareRoom(address, room);
	}
}
