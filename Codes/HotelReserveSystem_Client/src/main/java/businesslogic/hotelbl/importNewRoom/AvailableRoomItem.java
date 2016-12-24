package businesslogic.hotelbl.importNewRoom;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Set;

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
		Set<RoomType> roomTypes = roomTypeAndPrice.keySet();
		int min_Price = 10000000;
		int max_Price = 0;
		for(RoomType roomType : roomTypes) {
			if(roomTypeAndPrice.get(roomType) < min_Price)
				min_Price = roomTypeAndPrice.get(roomType);
			if(roomTypeAndPrice.get(roomType) > max_Price)
				max_Price = roomTypeAndPrice.get(roomType);
		}
		hotelPO.setMin_Price(min_Price);
		hotelPO.setMax_Price(max_Price);
		hotelDAO.updateHotel(hotelPO);
		return roomInfoService.updateSpareRoom(address, room);
	}
}
