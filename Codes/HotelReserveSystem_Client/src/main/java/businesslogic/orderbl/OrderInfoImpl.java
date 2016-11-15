package businesslogic.orderbl;

import java.util.ArrayList;

import businesslogic.hotelbl.OrderInfo;
import vo.BriefOrderInfoVO;
import vo.OrderVO;

public class OrderInfoImpl implements OrderInfo {

	@Override
	public ArrayList<OrderVO> getAllOrders(String userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isReserved(String userID, String address) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<OrderVO> getCommentableOrderList(String userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderVO> getOrderList(String userID, String address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BriefOrderInfoVO> getReservedOrderList(String userID) {
		// TODO Auto-generated method stub
		return null;
	}

}
