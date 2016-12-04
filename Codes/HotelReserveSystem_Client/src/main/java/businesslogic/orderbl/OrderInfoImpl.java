package businesslogic.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.hotelbl.OrderInfo;
import businesslogic.utilitybl.POList2VOList;
import dataservice.orderDAO.OrderDAO;
import rmi.RemoteHelper;
import vo.BriefOrderInfoVO;
import vo.OrderVO;

public class OrderInfoImpl implements OrderInfo {
	OrderDAO orderDAO;
	POList2VOList transformer;
	
	public OrderInfoImpl() {
		transformer = new POList2VOList();
		orderDAO = RemoteHelper.getInstance().getOrderDAO();
	}
	
	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}
	
	@Override
	public ArrayList<OrderVO> getAllOrders(String userID) {
		ArrayList<OrderVO> result = null;
		try {
			result = transformer.detailedPo2voList(orderDAO.getUserAllOrders(userID));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean isReserved(String userID, String address) {
		boolean result = false;
		try {
			result = orderDAO.isReserved(userID, address);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ArrayList<OrderVO> getCommentableOrderList(String userID) {
		ArrayList<OrderVO> result = null;
		try {
			result = transformer.detailedPo2voList(orderDAO.getCommentableOrders(userID));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ArrayList<OrderVO> getOrderList(String userID, String address) {
		ArrayList<OrderVO> result = null;
		try {
			result = transformer.detailedPo2voList(orderDAO.getUserOrdersByHotel(userID, address));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ArrayList<BriefOrderInfoVO> getReservedOrderList(String userID) {
		ArrayList<BriefOrderInfoVO> result = null;
		try {
			if(orderDAO.getReservedOrderList(userID) != null) {
				result = transformer.briefPo2voList(orderDAO.getReservedOrderList(userID));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

}
