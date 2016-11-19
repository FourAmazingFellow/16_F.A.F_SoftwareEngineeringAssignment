package data.orderdata;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import dataservice.orderDAO.OrderDAO;
import po.BriefOrderInfoPO;
import po.OrderPO;
import po.OrderType;

public class OrderDAOImpl implements OrderDAO {

	@Override
	public ArrayList<OrderPO> getUserAllOrders(String userID) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<OrderPO> getCommentableOrders(String userID) throws RemoteException {
		return null;
	}

	@Override
	public boolean isReserved(String userID, String address) throws RemoteException {
		return false;
	}

	@Override
	public ArrayList<OrderPO> getUserOrdersByHotel(String userID, String address) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<BriefOrderInfoPO> getUserOrderList(String userID, Enum<OrderType> orderType)
			throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<BriefOrderInfoPO> getHotelOrderList(String address, Enum<OrderType> orderType)
			throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<BriefOrderInfoPO> getAllAbnormalList(Date date) throws RemoteException {
		return null;
	}

	@Override
	public OrderPO getSingleOrder(String address, String orderID) throws RemoteException {
		return null;
	}

	@Override
	public OrderPO getDetailedOrder(String orderID) throws RemoteException {
		return null;
	}

	@Override
	public boolean insertOrder(OrderPO po) throws RemoteException {
		return false;
	}

	@Override
	public boolean deleteOrder(OrderPO po) throws RemoteException {
		return false;
	}

	@Override
	public boolean updateOrder(OrderPO po) throws RemoteException {
		return false;
	}


	@Override
	public ArrayList<BriefOrderInfoPO> getReservedOrderList(String userID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
