package businesslogic.hotelbl.importNewRoom;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import dataservice.hotelDAO.HotelDAO;
import po.HotelPO;
import po.RoomType;
import vo.RoomVO;

public class AvailableRoomList {
	private HotelDAO hotelDAO;
	private String hotelAddress;
	
	public AvailableRoomList(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}
	
	public ArrayList<RoomVO> getAvailableRoomList() {
		try {
			HotelPO hotel = hotelDAO.getHotelDetails(hotelAddress);
			HashMap<RoomType, Integer> roomTypeAndPrice = hotel.getRoomTypeAndPrice();
			HashMap<RoomType, Integer> roomTypeAndNums = hotel.getRoomTypeAndNums();
			ArrayList<RoomVO> roomVOs = new ArrayList<>();
			return roomVOs;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
