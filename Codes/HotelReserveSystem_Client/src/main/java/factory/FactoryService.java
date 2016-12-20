package factory;

import businesslogic.hotelbl.HotelInfoService;
import businesslogic.hotelbl.OrderInfo;
import businesslogic.roombl.RoomInfoService;
import businesslogic.roombl.updateCheckOut.AvailableRoomService;
import businesslogic.strategybl.StrategyInfoService;
import businesslogic.userbl.ClientCreditInfo;
import businesslogic.userbl.UserInfo;
import businesslogic.userbl.VerifyEnterpriseVip;
import businesslogic.userbl.VipInfo;
import dataservice.hotelDAO.HotelDAO;
import dataservice.orderDAO.OrderDAO;
import dataservice.roomDAO.RoomDAO;
import dataservice.strategyDAO.StrategyDAO;
import dataservice.userDAO.UserDAO;

public interface FactoryService {
	
	public HotelInfoService createHotelInfoService();
	
	public OrderInfo createOrderInfo();
	
	public RoomInfoService createRoomInfoService();
	
	public UserInfo createUserInfo();
	
	public ClientCreditInfo createClientCreditInfoService();
	
	public StrategyInfoService createStrategyInfoService();
	
	public AvailableRoomService createAvailableRoomService();
	
	public VipInfo createVipInfo();
	
	public VerifyEnterpriseVip createVerifyEnterpriseVip();
	
	public HotelDAO getHotelDAO();
	
	public OrderDAO getOrderDAO();
	
	public RoomDAO getRoomDAO();
	
	public StrategyDAO getStrategyDAO();
	
	public UserDAO getUserDAO();
}
