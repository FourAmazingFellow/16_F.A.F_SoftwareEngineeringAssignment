package businesslogic.hotelbl.importNewRoom;

import java.util.ArrayList;

import businesslogicservice.hotelblservice.ImportNewRoomService;
import vo.RoomVO;

public class ImportNewRoomServiceImpl implements ImportNewRoomService {

	private AvailableRoomList availableRoomList;
	private String hotelAddress;
	private AvailableRoomItem availableRoomItem;
	@Override
	public ArrayList<RoomVO> getAvailableRoomList(String address) {
		this.hotelAddress = address;
		availableRoomList = new AvailableRoomList(address);
		return availableRoomList.getAvailableRoomList();
	}

	@Override
	public boolean addRoom(RoomVO room) {
		availableRoomItem = new MockAvailableRoomItem(hotelAddress);
		return availableRoomItem.addRoom(room);
	}

}

