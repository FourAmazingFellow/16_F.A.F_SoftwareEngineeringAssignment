package businesslogic.hotelbl.importNewRoom;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import dataservice.hotelDAO.HotelDAO;
import factory.FactoryService;
import factory.FactoryServiceImpl;
import po.HotelPO;
import po.RoomType;
import vo.RoomVO;

public class AvailableRoomList {
	private HotelDAO hotelDAO;
	private String hotelAddress;

	private FactoryService factory;
	
	public AvailableRoomList(String hotelAddress) {
		this.hotelAddress = hotelAddress;
		this.factory = new FactoryServiceImpl();
		this.hotelDAO = factory.getHotelDAO();
	}
	
	public ArrayList<RoomVO> getAvailableRoomList() throws RemoteException {
		HotelPO hotel = hotelDAO.getHotelDetails(hotelAddress);
		HashMap<RoomType, Integer> roomTypeAndPrice = hotel.getRoomTypeAndPrice();
		HashMap<RoomType, Integer> roomTypeAndNums = hotel.getRoomTypeAndNums();
		ArrayList<RoomVO> roomVOs = new ArrayList<>();
		Set<RoomType> roomTypes = roomTypeAndPrice.keySet();
		for(RoomType roomType : roomTypes) {
			RoomVO roomVO = new RoomVO(roomType, roomTypeAndNums.get(roomType), roomTypeAndPrice.get(roomType), hotel.getHotelAddress());
			roomVOs.add(roomVO);
		}
		return roomVOs;
	}
}
