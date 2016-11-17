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
	
	public BrowseUserOrderServiceImpl_Stub(String userID, String orderID, String hotelName, String hotelAddress, Date beginDate, 
			Date finishDate, Enum<RoomType> roomType, int num, int totalPrice, Enum<OrderState> orderState, Date orderProducedTime,
			Date lastedOrderDoneTime, int numOfPerson, boolean isChild, boolean isOnSale, boolean isCommented) {
		testBriefOrderInfoVO = new BriefOrderInfoVO(userID, orderID, hotelName, hotelAddress, beginDate, finishDate, roomType, numOfPerson, totalPrice, orderState);
		testOrderVO = new OrderVO(userID, orderID, hotelName, hotelAddress, beginDate, finishDate, roomType, num, totalPrice, orderState, orderProducedTime, lastedOrderDoneTime, numOfPerson, isChild, isOnSale, isCommented);
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
