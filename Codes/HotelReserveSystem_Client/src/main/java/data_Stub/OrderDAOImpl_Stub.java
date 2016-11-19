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
	private BriefOrderInfoPO testBriefOrderInfoPO;
	private OrderPO testOrderPO;
	private boolean isReserved;
	
	
	public OrderDAOImpl_Stub(String userID, String orderID, String hotelName, String hotelAddress, Date beginDate, 
			Date finishDate, Enum<RoomType> roomType, int num, int totalPrice, Enum<OrderState> orderState, Date orderProducedTime,
			Date lastedOrderDoneTime, int numOfPerson, boolean isChild, boolean isOnSale, boolean isCommented, boolean isReserved) {
		testBriefOrderInfoPO = new BriefOrderInfoPO(userID, orderID, hotelName, hotelAddress, beginDate, finishDate, roomType, num, totalPrice, orderState);
		testOrderPO = new OrderPO(userID, orderID, hotelName, hotelAddress, beginDate, finishDate, roomType, num, totalPrice, orderState, orderProducedTime, lastedOrderDoneTime, numOfPerson, isChild, isOnSale, isCommented);
		this.isReserved = isReserved;
	}
	
	@Override
	public ArrayList<OrderPO> getUserAllOrders(String userID) throws RemoteException {
		ArrayList<OrderPO> a = new ArrayList<OrderPO>();
		a.add(testOrderPO);
		return a;
	}

	@Override
	public ArrayList<BriefOrderInfoPO> getReservedOrderList(String userID) {
		ArrayList<BriefOrderInfoPO> a = new ArrayList<BriefOrderInfoPO>();
		a.add(testBriefOrderInfoPO);
		return a;
	}

	@Override
	public ArrayList<OrderPO> getCommentableOrders(String userID) throws RemoteException {
		ArrayList<OrderPO> a = new ArrayList<OrderPO>();
		a.add(testOrderPO);
		return a;
	}

	@Override
	public boolean isReserved(String userID, String address) throws RemoteException {
		return isReserved;
	}

	@Override
	public ArrayList<OrderPO> getUserOrdersByHotel(String userID, String address) throws RemoteException {
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
		return testOrderPO;
	}
	
	@Override
	public OrderPO getDetailedOrder(String orderID) throws RemoteException {
		return testOrderPO;
	}
	
	@Override
	public boolean insertOrder(OrderPO po) throws RemoteException {
		System.out.println("OrderDAO insert.");
		return true;
	}

	@Override
	public boolean deleteOrder(OrderPO po) throws RemoteException {
		System.out.println("OrderDAO delete");
		return true;
	}

	@Override
	public boolean updateOrder(OrderPO po) throws RemoteException {
		System.out.println("OrderDAO update.");
		return true;
	}
}
