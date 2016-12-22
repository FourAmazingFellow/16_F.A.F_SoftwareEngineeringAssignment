package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.ArrayList;

import data.hoteldata.HotelDAOImpl;
import data.orderdata.OrderDAOImpl;
import data.roomdata.RoomDAOImpl;
import data.strategydata.StrategyDAOImpl;
import data.userdata.UserDAOImpl;
import dataservice.hotelDAO.HotelDAO;
import dataservice.orderDAO.OrderDAO;
import dataservice.roomDAO.RoomDAO;
import dataservice.strategyDAO.StrategyDAO;
import dataservice.userDAO.UserDAO;
import po.BriefHotelInfoPO;
import po.BriefOrderInfoPO;
import po.BusinessDistrictPO;
import po.CheckInPO;
import po.CheckOutPO;
import po.ClientInfoPO;
import po.CreditRecordPO;
import po.EnterpriseVipPO;
import po.HotelPO;
import po.HotelStaffInfoPO;
import po.OrderPO;
import po.OrderType;
import po.RegularVipPO;
import po.RoomPO;
import po.RoomType;
import po.StrategyPO;
import po.StrategyType;
import po.UserPO;

public class DataRemoteObjectMySql extends UnicastRemoteObject implements HotelDAO, OrderDAO, RoomDAO, StrategyDAO, UserDAO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8528871221863822838L;
	private HotelDAO hotelDAO;
	private OrderDAO orderDAO;
	private RoomDAO roomDAO;
	private StrategyDAO strategyDAO;
	private UserDAO userDAO;
	
	protected DataRemoteObjectMySql() throws RemoteException {
		hotelDAO = new HotelDAOImpl();
		orderDAO = new OrderDAOImpl();
		roomDAO = new RoomDAOImpl();
		strategyDAO = new StrategyDAOImpl();
		userDAO = new UserDAOImpl();
	}

	@Override
	public UserPO getUserInfo(String userID) throws RemoteException {
		return userDAO.getUserInfo(userID);
	}

	@Override
	public ArrayList<CreditRecordPO> queryCreditRecord(String userID) throws RemoteException {
		return userDAO.queryCreditRecord(userID);
	}

	@Override
	public int getCreditValue(String userID) throws RemoteException {
		return userDAO.getCreditValue(userID);
	}

	@Override
	public boolean insertUser(UserPO userPO) throws RemoteException {
		return userDAO.insertUser(userPO);
	}
	
	@Override
    public boolean insertClient(ClientInfoPO clientInfoPO) throws RemoteException {
		return userDAO.insertClient(clientInfoPO);
        
    }

    @Override
    public boolean insertHotelStaff(HotelStaffInfoPO hotelStaffInfoPO) throws RemoteException {
    	return userDAO.insertHotelStaff(hotelStaffInfoPO);
        
    }

	@Override
	public boolean updateUser(UserPO po, String oldUserID) throws RemoteException {
		return userDAO.updateUser(po, oldUserID);
	}

	@Override
	public ArrayList<StrategyPO> getStrategyList(String address, Enum<StrategyType> strategyType)
			throws RemoteException {
		return strategyDAO.getStrategyList(address, strategyType);
	}

	@Override
	public StrategyPO getStrategyInfo(String address, Enum<StrategyType> strategyType, String strategyName) throws RemoteException {
		return strategyDAO.getStrategyInfo(address, strategyType, strategyName);
	}

	@Override
	public boolean updateStrategy(StrategyPO po) throws RemoteException {
		return strategyDAO.updateStrategy(po);
	}

	@Override
	public boolean insertStrategy(StrategyPO po) throws RemoteException {
	    return strategyDAO.insertStrategy(po);
	}

	@Override
	public boolean deleteStrategy(StrategyPO po) throws RemoteException {
	    return strategyDAO.deleteStrategy(po);
	}

	@Override
	public ArrayList<RoomPO> getSpareRoomInfoList(String address, Date day) throws RemoteException {
		return roomDAO.getSpareRoomInfoList(address,day);
	}

	@Override
	public RoomPO getSpareRoomInfo(String address, Enum<RoomType> roomType, Date day) throws RemoteException {
		return roomDAO.getSpareRoomInfo(address, roomType,day);
	}

	@Override
	public ArrayList<RoomPO> getCheckInInfoList(String address) throws RemoteException {
		return roomDAO.getCheckInInfoList(address);
	}

	@Override
	public ArrayList<RoomPO> getCheckInInfo(String address, Date startTime, Date endTime) throws RemoteException {
		return roomDAO.getCheckInInfo(address, startTime, endTime);
	}

	@Override
	public ArrayList<RoomPO> getCheckInInfo(String address, Enum<RoomType> roomType) throws RemoteException {
		return roomDAO.getCheckInInfo(address, roomType);
	}

	@Override
	public ArrayList<RoomPO> getCheckOutInfoList(String address) throws RemoteException {
		return roomDAO.getCheckOutInfoList(address);
	}

	@Override
	public ArrayList<RoomPO> getCheckOutInfo(String address, Date startTime, Date endTime) throws RemoteException {
		return roomDAO.getCheckOutInfo(address, startTime, endTime);
	}

	@Override
	public ArrayList<RoomPO> getCheckOutInfo(String address, Enum<RoomType> roomType) throws RemoteException {
		return roomDAO.getCheckOutInfo(address, roomType);
	}

	@Override
	public void updateRoom(RoomPO po, Date day) throws RemoteException {
		roomDAO.updateRoom(po,day);
	}

	@Override
	public void insertRoom(RoomPO po) throws RemoteException {
		roomDAO.insertRoom(po);
	}
	
	@Override
	public void insertCheckIn(CheckInPO po) throws RemoteException {
	    roomDAO.insertCheckIn(po);
	}
	
	@Override
	public void insertCheckOut(CheckOutPO po) throws RemoteException {
	    roomDAO.insertCheckOut(po);
	}

	@Override
	public ArrayList<OrderPO> getUserAllOrders(String userID) throws RemoteException {
		return orderDAO.getUserAllOrders(userID);
	}

	@Override
	public ArrayList<BriefOrderInfoPO> getReservedOrderList(String userID) throws RemoteException {
		return orderDAO.getReservedOrderList(userID);
	}

	@Override
	public ArrayList<OrderPO> getCommentableOrders(String userID) throws RemoteException {
		return orderDAO.getCommentableOrders(userID);
	}

	@Override
	public boolean isReserved(String userID, String address) throws RemoteException {
		return orderDAO.isReserved(userID, address);
	}

	@Override
	public ArrayList<OrderPO> getUserOrdersByHotel(String userID, String address) throws RemoteException {
		return orderDAO.getUserOrdersByHotel(userID, address);
	}

	@Override
	public ArrayList<BriefOrderInfoPO> getUserOrderList(String userID, Enum<OrderType> orderType)
			throws RemoteException {
		return orderDAO.getUserOrderList(userID, orderType);
	}

	@Override
	public ArrayList<BriefOrderInfoPO> getHotelOrderList(String address, Enum<OrderType> orderType)
			throws RemoteException {
		return orderDAO.getHotelOrderList(address, orderType);
	}

	@Override
	public ArrayList<BriefOrderInfoPO> getAllAbnormalList(java.util.Date date) throws RemoteException {
		return orderDAO.getAllAbnormalList(date);
	}

	@Override
	public OrderPO getSingleOrder(String address, String orderID) throws RemoteException {
		return orderDAO.getSingleOrder(address, orderID);
	}

	@Override
	public OrderPO getDetailedOrder(String orderID) throws RemoteException {
		return orderDAO.getDetailedOrder(orderID);
	}

	@Override
	public boolean insertOrder(OrderPO po) throws RemoteException {
		return orderDAO.insertOrder(po);
	}

	@Override
	public boolean deleteOrder(OrderPO po) throws RemoteException {
		return orderDAO.deleteOrder(po);
	}

	@Override
	public boolean updateOrder(OrderPO po) throws RemoteException {
		return orderDAO.updateOrder(po);
	}

	@Override
	public BriefHotelInfoPO getHotelBriefInfo(String address) throws RemoteException {
		return hotelDAO.getHotelBriefInfo(address);
	}

	@Override
	public ArrayList<BriefHotelInfoPO> getHotelBriefInfoListBySearching(String[] condition,
			ArrayList<BriefOrderInfoPO> orderedHotelList) throws RemoteException {
		return hotelDAO.getHotelBriefInfoListBySearching(condition, orderedHotelList);
	}

	@Override
	public ArrayList<BriefHotelInfoPO> getHotelBriefInfoListByQuerying(String[] condition,
			ArrayList<BriefOrderInfoPO> orderedHotelList) throws RemoteException {
		return hotelDAO.getHotelBriefInfoListByQuerying(condition, orderedHotelList);
	}

	@Override
	public HotelPO getHotelDetails(String address) throws RemoteException {
		return hotelDAO.getHotelDetails(address);
	}

	@Override
	public boolean updateHotel(HotelPO po) throws RemoteException {
		return hotelDAO.updateHotel(po);
	}

	@Override
	public boolean insertHotel(HotelPO po) throws RemoteException {
		return hotelDAO.insertHotel(po);
	}

    @Override
    public ClientInfoPO getClientInfo(String userID) throws RemoteException {
        return userDAO.getClientInfo(userID);
    }

    @Override
    public HotelStaffInfoPO getHotelStaffInfo(String userID) throws RemoteException {
        return userDAO.getHotelStaffInfo(userID);
    }

    @Override
    public boolean signRegularVip(RegularVipPO regularVipPO) throws RemoteException {
    	return userDAO.signRegularVip(regularVipPO);
    }

    @Override
	public boolean updateClient(ClientInfoPO clientInfoPO, String oldUserID) throws RemoteException {
    	return userDAO.updateClient(clientInfoPO, oldUserID);
	}

	@Override
    public boolean signEnterpriseVip(EnterpriseVipPO enterpriseVipPO) throws RemoteException {
		return userDAO.signEnterpriseVip(enterpriseVipPO);
    }

    @Override
    public boolean verifyEnterpriseMember(String enterpriseName, String securityCode) throws RemoteException {
        return strategyDAO.verifyEnterpriseMember(enterpriseName, securityCode);
    }

    @Override
    public RegularVipPO getRegularVipInfo(String userID) throws RemoteException {
        return userDAO.getRegularVipInfo(userID);
    }

    @Override
    public EnterpriseVipPO getEnterpriseVipInfo(String userID) throws RemoteException {
        return userDAO.getEnterpriseVipInfo(userID);
    }

	@Override
	public ArrayList<BusinessDistrictPO> getBusinessDistrictList(String city) throws RemoteException {
		return hotelDAO.getBusinessDistrictList(city);
	}

	@Override
	public boolean updateRegularVipInfo(RegularVipPO regularVipPO) throws RemoteException {
		return userDAO.updateRegularVipInfo(regularVipPO);
	}

	@Override
	public boolean setOrderCommented(String orderID) throws RemoteException {
		return orderDAO.setOrderCommented(orderID);
	}

}
