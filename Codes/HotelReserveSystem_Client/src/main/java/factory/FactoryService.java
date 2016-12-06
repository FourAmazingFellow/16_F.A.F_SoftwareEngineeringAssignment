package factory;

import businesslogic.hotelbl.HotelInfoService;
import businesslogic.hotelbl.OrderInfo;
import businesslogic.roombl.RoomInfoService;
import businesslogic.roombl.updateCheckOut.AvailableRoomService;
import businesslogic.strategybl.StrategyInfoService;
import businesslogic.userbl.ClientCreditInfo;
import businesslogic.userbl.UserInfo;
import businesslogic.userbl.VipInfo;

public interface FactoryService {
	
	public HotelInfoService createHotelInfoService();
	
	public OrderInfo createOrderInfo();
	
	public RoomInfoService createRoomInfoService();
	
	public UserInfo createUserInfo();
	
	public ClientCreditInfo createClientCreditInfoService();
	
	public StrategyInfoService createStrategyInfoService();
	
	public AvailableRoomService createAvailableRoomService();
	
	public VipInfo createVipInfo();
}
