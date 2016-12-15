package bl_Stub.orderblservice_Stub;

import java.util.ArrayList;
import java.util.Date;

import businesslogicservice.orderblservice.GetOrderDoneService;
import po.OrderState;
import po.RoomType;
import vo.BriefOrderInfoVO;
import vo.OrderVO;

public class GetOrderDoneServiceImpl_Stub implements GetOrderDoneService {

	BriefOrderInfoVO testBriefOrderInfoVO;
	OrderVO testOrderVO;

	public GetOrderDoneServiceImpl_Stub(String userID, String orderID, String hotelName, String hotelAddress,
			Date beginDate, Date finishDate, Enum<RoomType> roomType, int num, int totalPrice,
			Enum<OrderState> orderState, Date orderProducedTime, Date lastedOrderDoneTime, int numOfPerson,
			boolean isChild, boolean isOnSale, boolean isCommented) {
		testBriefOrderInfoVO = new BriefOrderInfoVO(userID, orderID, hotelName, hotelAddress, beginDate, finishDate,
				roomType, numOfPerson, totalPrice, orderState);
		testOrderVO = new OrderVO(userID, orderID, hotelName, hotelAddress, beginDate, finishDate, roomType, num,
				totalPrice, orderState, orderProducedTime, lastedOrderDoneTime, numOfPerson, isChild, isOnSale,
				isCommented);
	}

	@Override
	public ArrayList<BriefOrderInfoVO> getHotelNotDoneOrderList(String address) {
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
		return true;
	}

	@Override
	public boolean delayCheckIn(OrderVO vo) {
		// TODO Auto-generated method stub
		System.out.println("延迟入住");
		return true;
	}

}
