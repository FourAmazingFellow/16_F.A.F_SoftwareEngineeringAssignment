package bl_Driver.hotelblservice_Driver;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.hotelblservice.ImportNewRoomService;
import po.RoomType;
import vo.RoomVO;

public class ImportNewRoomService_Driver {
	public void drive(ImportNewRoomService importNewRoomService) throws RemoteException {
		ArrayList<RoomVO> roomVOList = importNewRoomService.getAvailableRoomList("江苏省南京市栖霞区仙林大道163号");
		if(roomVOList.isEmpty())
			System.out.println("No rooms");
		else
			System.out.println("There are " + roomVOList.size() + " such room types");
		
		RoomVO room = new RoomVO(RoomType.SINGLE_ROOM, 0000000000000003, "江苏省南京市栖霞区仙林大道163号");
		boolean result = importNewRoomService.addRoom(room);
		if(result)
			System.out.println("Add Succeed!\n");
		else
			System.out.println("Add Failed!\n");
	}
}
