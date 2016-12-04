package businesslogic.orderbl.browseHotelOrder;

import java.util.ArrayList;
import java.util.Date;

import po.OrderState;
import po.OrderType;
import po.RoomType;
import vo.BriefOrderInfoVO;
import vo.OrderVO;

public class MockHotelOrderList extends HotelOrderList{
	private BriefOrderInfoVO mockBriefOrderInfoVO;
	private OrderVO mockOrderVO;
	
	@SuppressWarnings("deprecation")
	public MockHotelOrderList(String addresss) {
		// TODO Auto-generated constructor stub
		mockBriefOrderInfoVO = new BriefOrderInfoVO("原", "0000000000000003", "汉庭酒店", "江苏省南京市栖霞区仙林大道163号", 
				new Date(2016, 12, 20), new Date(2016, 12, 21), RoomType.STANDARD_ROOM,
				1, 200, OrderState.NOT_DONE_ORDER);
		
		mockOrderVO = new OrderVO("原", "0000000000000003", "汉庭酒店", "江苏省南京市栖霞区仙林大道163号", 
				new Date(2016, 12, 20), new Date(2016, 12, 21), RoomType.STANDARD_ROOM,
				1, 200, OrderState.NOT_DONE_ORDER, new Date(2016, 12, 15, 18, 0), new Date(2016, 12, 20, 22, 0), 2, 
				false, false, false);
	}
	
	/**
	 * 得到简要酒店订单列表
	 * @param address
	 * @param orderType
	 * @return
	 * @see
	 */
	public ArrayList<BriefOrderInfoVO> getHotelOrderList(String address, Enum<OrderType> orderType) {
		ArrayList<BriefOrderInfoVO> mockBriefOrderlist = new ArrayList<BriefOrderInfoVO>();
		mockBriefOrderlist.add(mockBriefOrderInfoVO);
		return mockBriefOrderlist;
	}
	
	public OrderVO getSingleOrder(String address, String orderID){
		mockBriefOrderInfoVO.hotelAddress = address;
		mockOrderVO.orderID = orderID;
		return mockOrderVO;
	}
	
}
