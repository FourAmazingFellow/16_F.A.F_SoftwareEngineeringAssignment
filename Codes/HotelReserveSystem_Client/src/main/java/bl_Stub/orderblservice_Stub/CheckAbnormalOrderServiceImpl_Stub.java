package bl_Stub.orderblservice_Stub;

import java.util.ArrayList;
import java.util.Date;

import businesslogicservice.orderblservice.CheckAbnormalOrderService;
import po.OrderState;
import po.RoomType;
import vo.BriefOrderInfoVO;
import vo.OrderVO;

public class CheckAbnormalOrderServiceImpl_Stub implements CheckAbnormalOrderService {

	BriefOrderInfoVO testBriefOrderInfoVO;
	OrderVO testOrderVO;
	
	public CheckAbnormalOrderServiceImpl_Stub(String userID, String orderID, String hotelName, String hotelAddress, Date beginDate, 
			Date finishDate, Enum<RoomType> roomType, int num, int totalPrice, Enum<OrderState> orderState, Date orderProducedTime,
			Date lastedOrderDoneTime, int numOfPerson, boolean isChild, boolean isOnSale, boolean isCommented) {
		testBriefOrderInfoVO = new BriefOrderInfoVO(userID, orderID, hotelName, hotelAddress, beginDate, finishDate, roomType, numOfPerson, totalPrice, orderState);
		testOrderVO = new OrderVO(userID, orderID, hotelName, hotelAddress, beginDate, finishDate, roomType, num, totalPrice, orderState, orderProducedTime, lastedOrderDoneTime, numOfPerson, isChild, isOnSale, isCommented);
	}
	
	@Override
	public ArrayList<BriefOrderInfoVO> getAbnormalOrderList(Date date) {
		System.out.println("得到所有异常订单列表");
		ArrayList<BriefOrderInfoVO> a = new ArrayList<BriefOrderInfoVO>();
		a.add(testBriefOrderInfoVO);
		return a;
	}

	@Override
	public OrderVO getDetailedOrder(String orderID) {
		// TODO Auto-generated method stub
		System.out.println("展开异常订单详情");
		return testOrderVO;
	}

	@Override
	public boolean systemWithdrawOrder(OrderVO vo, boolean isRecoverHalfCredit) {
		// TODO Auto-generated method stub
		System.out.println("网站营销人员撤销订单");
		return false;
	}

}
