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
	public ArrayList<OrderVO> getAllOrders(long ID) {
		ArrayList<OrderVO> a = new ArrayList<OrderVO>();
		a.add(testOrderVO);
		return a;
	}

	@Override
	public boolean isReserved(long ID, String address) {
		return false;
	}

	@Override
	public ArrayList<OrderVO> getCommentableOrderList(long ID) {
		ArrayList<OrderVO> a = new ArrayList<OrderVO>();
		a.add(testOrderVO);
		return a;
	}

	@Override
	public ArrayList<OrderVO> getOrderList(long ID, String address) {
		ArrayList<OrderVO> a = new ArrayList<OrderVO>();
		a.add(testOrderVO);
		return a;
	}
	
}
