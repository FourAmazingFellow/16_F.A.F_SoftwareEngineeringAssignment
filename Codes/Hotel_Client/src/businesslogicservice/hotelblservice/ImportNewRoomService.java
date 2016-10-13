package businesslogicservice.hotelblservice;

import java.util.ArrayList;

import vo.RoomVO;

/**
 * 
 * @author 原
 * @version
 */
public interface ImportNewRoomService {
	
	/**
	 * 
	 * @param address
	 * @return
	 * @see
	 */
	public ArrayList<RoomVO> getAvailableRoomList(String address);
	
	/**
	 * 
	 * @param room
	 * @return
	 * @see
	 */
	public boolean addRoom(RoomVO room);

}
