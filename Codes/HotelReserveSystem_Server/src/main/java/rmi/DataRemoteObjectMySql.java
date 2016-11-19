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
import po.ClientInfoPO;
import po.HotelPO;
import po.OrderPO;
import po.OrderType;
import po.RoomPO;
import po.RoomType;
import po.StrategyPO;
import po.StrategyType;
import po.UserPO;
import po.UserType;

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
	public UserPO getUserInfo(String userID, UserType UserType) throws RemoteException {
		return userDAO.getUserInfo(userID, UserType);
	}

	@Override
	public ClientInfoPO queryCreditRecord(String userID) throws RemoteException {
		return userDAO.queryCreditRecord(userID);
	}

	@Override
	public int getCreditValue(String userID) throws RemoteException {
		return userDAO.getCreditValue(userID);
	}

	@Override
	public void insertUser(UserPO po) throws RemoteException {
		userDAO.insertUser(po);
	}

	@Override
	public void deleteUser(UserPO po) throws RemoteException {
		userDAO.deleteUser(po);
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
	public StrategyPO getMarketStrategyInfo(String address, String strategyName) throws RemoteException {
		return strategyDAO.getMarketStrategyInfo(address, strategyName);
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
	public ArrayList<RoomPO> getCheckInInfo(String address, Date time) throws RemoteException {
		return roomDAO.getCheckInInfo(address, time);
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
	public ArrayList<RoomPO> getCheckOutInfo(String address, Date time) throws RemoteException {
		return roomDAO.getCheckOutInfo(address, time);
	}

	@Override
	public ArrayList<RoomPO> getCheckOutInfo(String address, Enum<RoomType> roomType) throws RemoteException {
		return roomDAO.getCheckOutInfo(address, roomType);
	}

	@Override
	public RoomPO findRoom(String userID) throws RemoteException {
		return roomDAO.findRoom(userID);
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
	public void deleteRoom(RoomPO po) throws RemoteException {
		roomDAO.deleteRoom(po);
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
	public StrategyPO findStrategy(String userID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}



}
