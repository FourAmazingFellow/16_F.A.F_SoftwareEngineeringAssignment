package data_Stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import dataservice.orderDAO.OrderDAO;
import po.BriefOrderInfoPO;
import po.OrderPO;
import po.OrderState;
import po.OrderType;
import po.RoomType;

public class OrderDAOImpl_Stub implements OrderDAO {
	BriefOrderInfoPO testBriefOrderInfoPO;
	OrderPO testOrderPO;
	
	public OrderDAOImpl_Stub(String userID, String orID, String hN, String hA, Date bD, Date fD, RoomType rT, int n, int tP,
			Date oPT, Date lODT, int nOP, boolean isChild, boolean isOnSale, OrderState orderS,
			boolean isCom) {
		testBriefOrderInfoPO = new BriefOrderInfoPO(userID, orID, hN, hA, bD, fD, rT, n, tP, orderS);
		testOrderPO = new OrderPO(userID, orID, hN, hA, bD, fD, rT, n, tP ,oPT, lODT, nOP, isChild, isOnSale, orderS, isCom);
	}
	
	@Override
	public ArrayList<OrderPO> getUserAllOrders(String userID) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<OrderPO> a = new ArrayList<OrderPO>();
		a.add(testOrderPO);
		return a;
	}

	@Override
	public ArrayList<OrderPO> getCommentableOrders(String userID) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<OrderPO> a = new ArrayList<OrderPO>();
		a.add(testOrderPO);
		return a;
	}

	@Override
	public boolean isReserved(String userID, String address) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<OrderPO> getUserOrdersByHotel(String userID, String address) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<OrderPO> a = new ArrayList<OrderPO>();
		a.add(testOrderPO);
		return a;
	}

	@Override
	public ArrayList<BriefOrderInfoPO> getUserOrderList(String userID, Enum<OrderType> orderType) throws RemoteException {
		ArrayList<BriefOrderInfoPO> b = new ArrayList<BriefOrderInfoPO>();
		b.add(testBriefOrderInfoPO);
		return b;
	}

	@Override
	public ArrayList<BriefOrderInfoPO> getHotelOrderList(String address, Enum<OrderType> orderType)
			throws RemoteException {
		
		ArrayList<BriefOrderInfoPO> b = new ArrayList<BriefOrderInfoPO>();
		b.add(testBriefOrderInfoPO);
		return b;
	}

	@Override
	public ArrayList<BriefOrderInfoPO> getAllAbnormalList(Date date) throws RemoteException {
		ArrayList<BriefOrderInfoPO> b = new ArrayList<BriefOrderInfoPO>();
		b.add(testBriefOrderInfoPO);
		return b;
	}

	@Override
	public OrderPO getSingleOrder(String address, String orderID) throws RemoteException {
		// TODO Auto-generated method stub
		return testOrderPO;
	}

	@Override
	public boolean insert(OrderPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("OrderDAO insert.");
		return true;
	}

	@Override
	public boolean delete(OrderPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("OrderDAO delete");
		return true;
	}

	@Override
	public boolean update(OrderPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("OrderDAO update.");
		return true;
	}

	@Override
	public boolean finish() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("OrderDAO finish.");
		return true;
	}

	@Override
	public OrderPO getDetailedOrder(String orderID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
