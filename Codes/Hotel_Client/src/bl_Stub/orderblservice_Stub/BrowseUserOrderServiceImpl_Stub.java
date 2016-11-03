package bl_Stub.orderblservice_Stub;

import java.util.ArrayList;
import java.util.Date;

import businesslogicservice.orderblservice.BrowseUserOrderService;
import po.OrderState;
import po.OrderType;
import po.RoomType;
import vo.BriefOrderInfoVO;
import vo.OrderVO;

public class BrowseUserOrderServiceImpl_Stub implements BrowseUserOrderService {
	BriefOrderInfoVO testBriefOrderInfoVO;
	OrderVO testOrderVO;
	
	public BrowseUserOrderServiceImpl_Stub(String userID, String orID, String hN, String hA, Date bD, Date fD, RoomType rT, int n, int tP,
			Date oPT, Date lODT, int nOP, boolean isChild, boolean isOnSale, OrderState orderS,
			boolean isCom) {
		testBriefOrderInfoVO = new BriefOrderInfoVO(userID, orID, hN, hA, bD, fD, rT, n, tP, orderS);
		testOrderVO = new OrderVO(userID, orID, hN, hA, bD, fD, rT, n, tP ,oPT, lODT, nOP, isChild, isOnSale, orderS, isCom);
	}
	public ArrayList<BriefOrderInfoVO> getUserOrderList(String userID, Enum<OrderType> orderType) {
		System.out.println("得到用户所有订单列表");
		ArrayList<BriefOrderInfoVO> b = new ArrayList<BriefOrderInfoVO>();
		b.add(testBriefOrderInfoVO);
		return b;
	}

	@Override
	public OrderVO getDetailedOrder(String orderID) {
		System.out.println("展开订单详情");
		return testOrderVO;
	}

}
