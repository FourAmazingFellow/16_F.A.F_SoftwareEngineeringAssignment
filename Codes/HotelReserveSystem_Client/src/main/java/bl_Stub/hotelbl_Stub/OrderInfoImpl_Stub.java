package bl_Stub.hotelbl_Stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import businesslogic.hotelbl.OrderInfo;
import po.OrderState;
import po.RoomType;
import vo.BriefOrderInfoVO;
import vo.OrderVO;

public class OrderInfoImpl_Stub implements OrderInfo{
	OrderVO testOrderVO;
	
	public OrderInfoImpl_Stub(String userID, String orderID, String hotelName, String hotelAddress, Date beginDate, 
			Date finishDate, Enum<RoomType> roomType, int num, int totalPrice, Enum<OrderState> orderState, Date orderProducedTime,
			Date lastedOrderDoneTime, int numOfPerson, boolean isChild, boolean isOnSale, boolean isCommented) {
		testOrderVO = new OrderVO(userID, orderID, hotelName, hotelAddress, beginDate, finishDate, roomType, num, totalPrice, orderState, orderProducedTime, lastedOrderDoneTime, numOfPerson, isChild, isOnSale, isCommented);
	}
	
	@Override
	public ArrayList<OrderVO> getAllOrders(String userID) {
		ArrayList<OrderVO> a = new ArrayList<OrderVO>();
		a.add(testOrderVO);
		return a;
	}

	@Override
	public boolean isReserved(String userID, String address) {
		return false;
	}

	@Override
	public ArrayList<OrderVO> getCommentableOrderList(String userID) {
		ArrayList<OrderVO> a = new ArrayList<OrderVO>();
		a.add(testOrderVO);
		return a;
	}

	@Override
	public ArrayList<OrderVO> getOrderList(String userID, String address) {
		ArrayList<OrderVO> a = new ArrayList<OrderVO>();
		a.add(testOrderVO);
		return a;
	}

	@Override
	public ArrayList<BriefOrderInfoVO> getReservedOrderList(String userID) {
		ArrayList<BriefOrderInfoVO> a = new ArrayList<BriefOrderInfoVO>();
		a.add(testOrderVO);
		return a;
	}

	@Override
	public boolean setOrderCommented(String orderID) throws RemoteException {
		return true;
	}
	
}
