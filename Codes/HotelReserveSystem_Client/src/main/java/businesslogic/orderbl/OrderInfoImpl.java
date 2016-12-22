package businesslogic.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.hotelbl.OrderInfo;
import businesslogic.utilitybl.POList2VOList;
import dataservice.orderDAO.OrderDAO;
import factory.FactoryService;
import factory.FactoryServiceImpl;
import vo.BriefOrderInfoVO;
import vo.OrderVO;

public class OrderInfoImpl implements OrderInfo {
	OrderDAO orderDAO;
	POList2VOList transformer;
	
	private FactoryService factory;
	
	public OrderInfoImpl() {
		transformer = new POList2VOList();
		this.factory = new FactoryServiceImpl();
		orderDAO = factory.getOrderDAO();
	}
	
	
	@Override
	public ArrayList<OrderVO> getAllOrders(String userID) throws RemoteException {
		ArrayList<OrderVO> result = null;
		result = transformer.detailedPo2voList(orderDAO.getUserAllOrders(userID));
		return result;
	}

	@Override
	public boolean isReserved(String userID, String address) throws RemoteException {
		boolean result = false;
		result = orderDAO.isReserved(userID, address);
		return result;
	}

	@Override
	public ArrayList<OrderVO> getCommentableOrderList(String userID) throws RemoteException {
		ArrayList<OrderVO> result = null;
		result = transformer.detailedPo2voList(orderDAO.getCommentableOrders(userID));
		return result;
	}

	@Override
	public ArrayList<OrderVO> getOrderList(String userID, String address) throws RemoteException {
		ArrayList<OrderVO> result = null;
		result = transformer.detailedPo2voList(orderDAO.getUserOrdersByHotel(userID, address));
		return result;
	}

	@Override
	public ArrayList<BriefOrderInfoVO> getReservedOrderList(String userID) throws RemoteException {
		ArrayList<BriefOrderInfoVO> result = null;
		if(orderDAO.getReservedOrderList(userID) != null) {
			result = transformer.briefPo2voList(orderDAO.getReservedOrderList(userID));
		}
		return result;
	}


	@Override
	public boolean setOrderCommented(String orderID) throws RemoteException {
		return false;
	}

}
