package presentation.hotelui.enrollavaluableroom;

import java.util.ArrayList;
import java.util.List;

import vo.RoomVO;

public class RoomList {

	private List<Room> roomList = new ArrayList<>();

	public List<Room> getStrategyList() {
		return roomList;
	}

	public void setRoomList(ArrayList<RoomVO> roomVOs) {
		roomList.clear();
		for (RoomVO roomVO : roomVOs) {
			roomList.add(new Room(roomVO));
		}
	}
}
