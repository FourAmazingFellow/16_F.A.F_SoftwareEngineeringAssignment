package businesslogicservice.hotelblservice;

import java.util.ArrayList;

import vo.RoomVO;

public interface ImportNewRoomService {
	public ArrayList<RoomVO> getAvailableRoomList(String address);
	
	public boolean addRoom(RoomVO room);

}
