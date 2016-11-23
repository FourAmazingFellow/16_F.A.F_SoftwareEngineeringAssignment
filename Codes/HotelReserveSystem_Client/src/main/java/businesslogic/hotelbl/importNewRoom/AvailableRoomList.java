package businesslogic.hotelbl.importNewRoom;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import dataservice.hotelDAO.HotelDAO;
import po.HotelPO;
import po.RoomType;
import rmi.RemoteHelper;
import vo.RoomVO;

public class AvailableRoomList {
	private HotelDAO hotelDAO;
	private String hotelAddress;
	
	public AvailableRoomList(String hotelAddress) {
		this.hotelAddress = hotelAddress;
		this.hotelDAO = RemoteHelper.getInstance().getHotelDAO();
	}
	
	public ArrayList<RoomVO> getAvailableRoomList() {
		try {
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
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
}
