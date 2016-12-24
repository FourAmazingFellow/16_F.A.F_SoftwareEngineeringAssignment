package businesslogic.hotelbl.importNewRoom;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.hotelblservice.ImportNewRoomService;
import vo.RoomVO;

public class ImportNewRoomServiceImpl implements ImportNewRoomService {

	private AvailableRoomList availableRoomList;
	private AvailableRoomItem availableRoomItem;
	@Override
	public ArrayList<RoomVO> getAvailableRoomList(String address) throws RemoteException {
		availableRoomList = new AvailableRoomList(address);
		return availableRoomList.getAvailableRoomList();
	}

	@Override
	public boolean addRoom(RoomVO room) throws RemoteException {
		availableRoomItem = new AvailableRoomItem(room.address);
		return availableRoomItem.addRoom(room);
	}

}

