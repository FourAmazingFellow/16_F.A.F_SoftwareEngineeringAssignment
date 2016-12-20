package businesslogic.hotelbl.importNewRoom;

import java.rmi.RemoteException;
import java.util.HashMap;

import businesslogic.roombl.RoomInfoService;
import dataservice.hotelDAO.HotelDAO;
import factory.FactoryService;
import factory.FactoryServiceImpl;
import po.HotelPO;
import po.RoomType;
import vo.RoomVO;

public class AvailableRoomItem {
	private RoomInfoService roomInfoService;
	private String address;
	private HotelDAO hotelDAO;
	
	private FactoryService factory;
	
	public AvailableRoomItem(String address) {
		this.address = address;
		this.factory = new FactoryServiceImpl();
		hotelDAO = factory.getHotelDAO();
		this.roomInfoService = factory.createRoomInfoService();
	}
	
	public boolean addRoom(RoomVO room) throws RemoteException {
		HotelPO hotelPO = hotelDAO.getHotelDetails(address);
		HashMap<RoomType, Integer> roomTypeAndPrice = hotelPO.getRoomTypeAndPrice();
		HashMap<RoomType, Integer> roomTypeAndNums = hotelPO.getRoomTypeAndNums();
		roomTypeAndNums.put((RoomType)room.roomType, room.roomNum);
		roomTypeAndPrice.put((RoomType)room.roomType, room.roomPrice);
		hotelDAO.updateHotel(hotelPO);
		return roomInfoService.updateSpareRoom(address, room);
	}
}
