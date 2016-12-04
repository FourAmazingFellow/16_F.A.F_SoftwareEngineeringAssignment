package businesslogic.orderbl;

import java.util.ArrayList;
import java.util.Date;

import po.OrderState;
import po.RoomType;
import vo.BriefOrderInfoVO;
import vo.OrderVO;

public class MockOrderInfoImpl extends OrderInfoImpl {
	OrderVO testOrderVO;
	
	@SuppressWarnings("deprecation")
	public MockOrderInfoImpl() {
		testOrderVO = new OrderVO("原", "0000000000000003", "汉庭酒店", "江苏省南京市栖霞区仙林大道163号", new Date(2016, 12, 20), new Date(2016, 12, 21), RoomType.STANDARD_ROOM,
				1, 200, OrderState.NOT_DONE_ORDER, new Date(2016, 12, 15), new Date(2016, 12, 20), 2, false, false, false);
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
}
