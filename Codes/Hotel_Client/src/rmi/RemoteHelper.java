package rmi;

import java.rmi.Remote;

import dataservice.hotelDAO.HotelDAO;
import dataservice.orderDAO.OrderDAO;
import dataservice.roomDAO.RoomDAO;
import dataservice.strategyDAO.StrategyDAO;
import dataservice.userDAO.UserDAO;

public class RemoteHelper {
	
	private Remote remote;
	private static RemoteHelper remoteHelper = new RemoteHelper();
	
	public static RemoteHelper getInstance() {
		return remoteHelper;
	}
	
	private RemoteHelper() {
	}
	
	public void setRemote(Remote remote){
		this.remote = remote;
	}
	
	public HotelDAO getHotelDAO() {
		return (HotelDAO)remote;
	}
	
	public OrderDAO getOrderDAO() {
		return (OrderDAO)remote;
	}
	
	public RoomDAO getRoomDAO() {
		return (RoomDAO)remote;
	}
	
	public StrategyDAO getStrategyDAO() {
		return (StrategyDAO)remote;
	}
	
	public UserDAO getUserDAO() {
		return (UserDAO)remote;
	}
}
