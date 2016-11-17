package bl_Stub.orderblservice_Stub;

import java.util.ArrayList;
import java.util.Date;

import businesslogicservice.orderblservice.BrowseHotelOrderService;
import po.OrderState;
import po.OrderType;
import po.RoomType;
import vo.BriefOrderInfoVO;
import vo.OrderVO;

public class BrowseHotelOrderServiceImpl_Stub implements BrowseHotelOrderService{
	BriefOrderInfoVO testBriefOrderInfoVO;
	OrderVO testOrderVO;
	
	public BrowseHotelOrderServiceImpl_Stub(String userID, String orderID, String hotelName, String hotelAddress, Date beginDate, 
			Date finishDate, Enum<RoomType> roomType, int num, int totalPrice, Enum<OrderState> orderState, Date orderProducedTime,
			Date lastedOrderDoneTime, int numOfPerson, boolean isChild, boolean isOnSale, boolean isCommented) {
		testBriefOrderInfoVO = new BriefOrderInfoVO(userID, orderID, hotelName, hotelAddress, beginDate, finishDate, roomType, numOfPerson, totalPrice, orderState);
		testOrderVO = new OrderVO(userID, orderID, hotelName, hotelAddress, beginDate, finishDate, roomType, num, totalPrice, orderState, orderProducedTime, lastedOrderDoneTime, numOfPerson, isChild, isOnSale, isCommented);
	}
	
	@Override
	public ArrayList<BriefOrderInfoVO> getHotelOrderList(String address, Enum<OrderType> orderType) {
		// TODO Auto-generated method stub
		System.out.println("得到酒店所有订单列表");
		ArrayList<BriefOrderInfoVO> b = new ArrayList<BriefOrderInfoVO>();
		b.add(testBriefOrderInfoVO);
		return b;
	}

	@Override
	public OrderVO getSingleOrder(String address, String orderID) {
		// TODO Auto-generated method stub
		System.out.println("得到F.A.F酒店的对应订单");
		return testOrderVO;
	}

}
