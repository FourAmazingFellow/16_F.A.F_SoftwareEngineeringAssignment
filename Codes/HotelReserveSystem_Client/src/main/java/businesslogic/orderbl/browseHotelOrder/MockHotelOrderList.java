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
		super(addresss);
		// TODO Auto-generated constructor stub
		mockBriefOrderInfoVO = new BriefOrderInfoVO("原","0001000100010001","仙林大酒店", addresss ,new Date(2016,10,16),
				new Date(2016,10,17),RoomType.KING_SIZE_ROOM,1,100, OrderState.NOT_DONE_ORDER);
		
		mockOrderVO = new OrderVO("原","0001000100010001","仙林大酒店", addresss ,new Date(2016,10,16),
				new Date(2016,10,17),RoomType.KING_SIZE_ROOM,1,100, OrderState.NOT_DONE_ORDER,new Date(2016,10,16,18,0),
				new java.util.Date(2016, 10, 16, 20, 0),2,false,true,false);
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
