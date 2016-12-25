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
		//酒店原有的房型数量，以及对应的价格
		HashMap<RoomType, Integer> roomTypeAndPrice = hotelPO.getRoomTypeAndPrice();
		HashMap<RoomType, Integer> roomTypeAndNums = hotelPO.getRoomTypeAndNums();
		
		//将增加的房型、数量，或者价格添加到原有的房型数量及其对应价格中，若该房型本来就存在，用新的数据替换原有数据
		if(roomTypeAndNums.containsKey(room.roomType)) {        //如果原本已经存在该房型
			//构造房间信息的变动量（若数量增加则为正，数量减少则为负）
			RoomVO roomVO = new RoomVO(room.roomType, room.roomNum - roomTypeAndNums.get(room.roomType), room.roomPrice, room.address);
			
			//根据调整后的酒店可用客房信息来调整空房列表
			roomInfoService.updateSpareRoom(address, roomVO);
			roomTypeAndNums.put((RoomType)room.roomType, room.roomNum);
			roomTypeAndPrice.put((RoomType)room.roomType, room.roomPrice);
		}
		else {        //如果原本不存在该房型
			roomInfoService.updateSpareRoom(address, room);
			roomTypeAndNums.put((RoomType)room.roomType, room.roomNum);
			roomTypeAndPrice.put((RoomType)room.roomType, room.roomPrice);
		}
		
		//根据调整后的房间价格，调整对应酒店的最低价格和最高价格
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
		
		//更新对应的酒店信息
		return hotelDAO.updateHotel(hotelPO);
		
	}
}
