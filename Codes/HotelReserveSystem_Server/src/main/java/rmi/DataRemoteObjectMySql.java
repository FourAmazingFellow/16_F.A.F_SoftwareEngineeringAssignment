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
	public void insertUser(UserPO userPO) throws RemoteException {
		userDAO.insertUser(userPO);
	}
	
	@Override
    public void insertClient(ClientInfoPO clientInfoPO) throws RemoteException {
        userDAO.insertClient(clientInfoPO);
        
    }

    @Override
    public void insertHotelStaff(HotelStaffInfoPO hotelStaffInfoPO) throws RemoteException {
        userDAO.insertHotelStaff(hotelStaffInfoPO);
        
    }

	@Override
	public void updateUser(UserPO po) throws RemoteException {
		userDAO.updateUser(po);
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
	public void updateStrategy(StrategyPO po) throws RemoteException {
		strategyDAO.updateStrategy(po);
	}

	@Override
	public void insertStrategy(StrategyPO po) throws RemoteException {
		strategyDAO.insertStrategy(po);
	}

	@Override
	public void deleteStrategy(StrategyPO po) throws RemoteException {
		strategyDAO.deleteStrategy(po);
	}

	@Override
	public ArrayList<RoomPO> getSpareRoomInfoList(String address) throws RemoteException {
		return roomDAO.getSpareRoomInfoList(address);
	}

	@Override
	public RoomPO getSpareRoomInfo(String address, Enum<RoomType> roomType) throws RemoteException {
		return roomDAO.getSpareRoomInfo(address, roomType);
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
	public void updateRoom(RoomPO po) throws RemoteException {
		roomDAO.updateRoom(po);
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
	public ArrayList<BriefHotelInfoPO> getHotelBriefInfoListBySearching(String[] condition) throws RemoteException {
		return hotelDAO.getHotelBriefInfoListBySearching(condition);
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
	public void updateHotel(HotelPO po) throws RemoteException {
		hotelDAO.updateHotel(po);
	}

	@Override
	public void insertHotel(HotelPO po) throws RemoteException {
		hotelDAO.insertHotel(po);
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
    public void updateClient(ClientInfoPO clientInfoPO) throws RemoteException {
    	userDAO.updateClient(clientInfoPO);
    }

    @Override
    public void signRegularVip(RegularVipPO regularVipPO) throws RemoteException {
    	userDAO.signRegularVip(regularVipPO);
    }

    @Override
    public void signEnterpriseVip(EnterpriseVipPO enterpriseVipPO) throws RemoteException {
    	userDAO.signEnterpriseVip(enterpriseVipPO);
    }

    @Override
    public boolean verifyEnterpriseMember(String enterpriseName, String securityCode) {
        return strategyDAO.verifyEnterpriseMember(enterpriseName, securityCode);
    }

<<<<<<< HEAD
    @Override
    public RegularVipPO getRegularVipInfo(String userID) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public EnterpriseVipPO getEnterpriseVipInfo(String userID) {
        // TODO Auto-generated method stub
        return null;
    }

    



=======
>>>>>>> origin/master
}
