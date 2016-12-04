package factory;

import businesslogic.hotelbl.HotelInfoService;
import businesslogic.hotelbl.HotelInfoServiceImpl;
import businesslogic.hotelbl.OrderInfo;
import businesslogic.orderbl.OrderInfoImpl;
import businesslogic.roombl.RoomInfoService;
import businesslogic.roombl.RoomInfoServiceImpl;
import businesslogic.strategybl.StrategyInfoService;
import businesslogic.strategybl.StrategyInfoServiceImpl;
import businesslogic.userbl.ClientCreditInfo;
import businesslogic.userbl.ClientCreditInfoImpl;
import businesslogic.userbl.UserInfo;
import businesslogic.userbl.UserInfoImpl;

public class FactoryServiceImpl implements FactoryService {
	@Override
	public HotelInfoService createHotelInfoService() {
		return new HotelInfoServiceImpl();
	}
	
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

	@Override
	public StrategyInfoService createStrategyInfoService() {
		return new StrategyInfoServiceImpl();
	}

	@Override
	public ClientCreditInfo createClientCreditInfoService() {
		return new ClientCreditInfoImpl();
	}
}
