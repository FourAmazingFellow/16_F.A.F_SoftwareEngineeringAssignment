package factory;

import businesslogic.hotelbl.OrderInfo;
import businesslogic.roombl.RoomInfoService;
import businesslogic.userbl.UserInfo;

public interface FactoryService {
	
	public OrderInfo createOrderInfo();
	
	public RoomInfoService createRoomInfoService();
	
	public UserInfo createUserInfo();
}
