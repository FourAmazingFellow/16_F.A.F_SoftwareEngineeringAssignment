package bl_Stub.orderblservice_Stub;

import java.util.ArrayList;
import java.util.Date;

import businesslogicservice.orderblservice.GetOrderDoneService;
import po.OrderState;
import po.OrderType;
import po.RoomType;
import vo.BriefOrderInfoVO;
import vo.OrderVO;

public class GetOrderDoneServiceImpl_Stub implements GetOrderDoneService {

	BriefOrderInfoVO testBriefOrderInfoVO;
	OrderVO testOrderVO;
	
	public GetOrderDoneServiceImpl_Stub(String userID, String orID, String hN, String hA, Date bD, Date fD, RoomType rT, int n, int tP,
			Date oPT, Date lODT, int nOP, boolean isChild, boolean isOnSale, OrderState orderS,
			boolean isCom) {
		testBriefOrderInfoVO = new BriefOrderInfoVO(userID, orID, hN, hA, bD, fD, rT, n, tP, orderS);
		testOrderVO = new OrderVO(userID, orID, hN, hA, bD, fD, rT, n, tP ,oPT, lODT, nOP, isChild, isOnSale, orderS, isCom);
	}
	
	@Override
	public ArrayList<BriefOrderInfoVO> getHotelOrderList(String address, Enum<OrderType> orderType) {
		// TODO Auto-generated method stub
		System.out.println("得到酒店所有订单列表");
		ArrayList<BriefOrderInfoVO> a = new ArrayList<BriefOrderInfoVO>();
		a.add(testBriefOrderInfoVO);
		return a;
	}

	@Override
	public OrderVO getSingleOrder(String address, String orderID) {
		// TODO Auto-generated method stub
		System.out.println("得到F.A.F酒店的对应订单");
		return testOrderVO;
	}

	@Override
	public boolean getOrderDone(OrderVO vo) {
		// TODO Auto-generated method stub
		System.out.println("执行订单");
		return false;
	}

	@Override
	public boolean delayCheckIn(OrderVO vo, int hours) {
		// TODO Auto-generated method stub
		System.out.println("延迟入住");
		return false;
	}

}
