package bl_Stub.hotelbl_Stub;

import java.util.ArrayList;
import java.util.Date;

import businesslogic.hotelbl.OrderInfo;
import po.OrderState;
import po.RoomType;
import vo.OrderVO;

public class OrderInfoImpl_Stub implements OrderInfo{
	OrderVO testOrderVO;
	
	public OrderInfoImpl_Stub(long userID, String orID, String hN, String hA, Date bD, Date fD, RoomType rT, int n, int tP,
			Date oPT, Date lODT, int nOP, boolean isChild, boolean isOnSale, OrderState orderS,
			boolean isCom) {
		testOrderVO = new OrderVO(userID, orID, hN, hA, bD, fD, rT, n, tP ,oPT, lODT, nOP, isChild, isOnSale, orderS, isCom);
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
	public ArrayList<OrderVO> getReservedOrderList(String userID) {
		ArrayList<OrderVO> a = new ArrayList<OrderVO>();
		a.add(testOrderVO);
		return a;
	}
	
}
