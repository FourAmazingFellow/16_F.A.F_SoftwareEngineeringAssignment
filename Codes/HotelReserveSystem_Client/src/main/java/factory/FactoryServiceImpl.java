package factory;

import businesslogic.hotelbl.HotelInfoService;
import businesslogic.hotelbl.HotelInfoServiceImpl;
import businesslogic.hotelbl.OrderInfo;
import businesslogic.orderbl.OrderInfoImpl;
import businesslogic.roombl.RoomInfoService;
import businesslogic.roombl.RoomInfoServiceImpl;
import businesslogic.roombl.updateCheckOut.AvailableRoomService;
import businesslogic.strategybl.StrategyInfoService;
import businesslogic.strategybl.StrategyInfoServiceImpl;
import businesslogic.strategybl.VerifyEnterpriseVipImpl;
import businesslogic.userbl.ClientCreditInfo;
import businesslogic.userbl.ClientCreditInfoImpl;
import businesslogic.userbl.UserInfo;
import businesslogic.userbl.UserInfoImpl;
import businesslogic.userbl.VerifyEnterpriseVip;
import businesslogic.userbl.VipInfo;
import businesslogic.userbl.VipInfoImpl;
import dataservice.hotelDAO.HotelDAO;
import dataservice.orderDAO.OrderDAO;
import dataservice.roomDAO.RoomDAO;
import dataservice.strategyDAO.StrategyDAO;
import dataservice.userDAO.UserDAO;
import rmi.RemoteHelper;

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

	@Override
	public AvailableRoomService createAvailableRoomService() {
		return new HotelInfoServiceImpl();
	}

    @Override
    public VipInfo createVipInfo() {
        return new VipInfoImpl();
    }

	@Override
	public VerifyEnterpriseVip createVerifyEnterpriseVip() {
		return new VerifyEnterpriseVipImpl();
	}

	@Override
	public HotelDAO getHotelDAO() {
		return RemoteHelper.getInstance().getHotelDAO();
	}

	@Override
	public OrderDAO getOrderDAO() {
		return RemoteHelper.getInstance().getOrderDAO();
	}

	@Override
	public RoomDAO getRoomDAO() {
		return RemoteHelper.getInstance().getRoomDAO();
	}

	@Override
	public StrategyDAO getStrategyDAO() {
		return RemoteHelper.getInstance().getStrategyDAO();
	}

	@Override
	public UserDAO getUserDAO() {
		return RemoteHelper.getInstance().getUserDAO();
	}
}
