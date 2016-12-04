package factory;

import businesslogic.hotelbl.OrderInfo;
import businesslogic.orderbl.OrderInfoImpl;
import businesslogic.roombl.RoomInfoService;
import businesslogic.roombl.RoomInfoServiceImpl;
import businesslogic.userbl.UserInfo;
import businesslogic.userbl.UserInfoImpl;

public class FactoryServiceImpl implements FactoryService {

	@Override
	public OrderInfo createOrderInfo() {
		return new OrderInfoImpl();
	}

	@Override
	public RoomInfoService createRoomInfoService() {
		return new RoomInfoServiceImpl();
	}

	@Override
	public UserInfo createUserInfo() {
		return new UserInfoImpl();
	}

}
