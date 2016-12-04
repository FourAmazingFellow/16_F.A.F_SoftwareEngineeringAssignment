package businesslogic.orderbl.browseUserOrder;

import java.util.ArrayList;
import java.util.Date;

import po.OrderState;
import po.OrderType;
import po.RoomType;
import vo.BriefOrderInfoVO;
import vo.OrderVO;

public class MockUserOrderList extends UserOrderList {
	private BriefOrderInfoVO mockBriefOrderInfoVO;
	private OrderVO mockOrderVO;
	
	@SuppressWarnings("deprecation")
	public MockUserOrderList(String userID) {
		mockBriefOrderInfoVO = new BriefOrderInfoVO(userID, "0001000100010001","仙林大酒店", "仙林大道163号",new Date(2016,10,16),
				new Date(2016,10,17),RoomType.KING_SIZE_ROOM,1,100, OrderState.NOT_DONE_ORDER);
		
		mockOrderVO = new OrderVO(userID,"0001000100010001","仙林大酒店", "仙林大道163号" ,new Date(2016,10,16),
				new Date(2016,10,17),RoomType.KING_SIZE_ROOM,1,100,OrderState.NOT_DONE_ORDER,new Date(2016,10,16,18,0),
				new java.util.Date(2016, 10, 16, 20, 0),2,false,true,false);
	}

	/**
	 * 得到客户简要订单列表
	 * @param userID
	 * @param orderType
	 * @return 客户简要订单列表
	 * @see
	 */
	public ArrayList<BriefOrderInfoVO> getUserOrderList(String userID, Enum<OrderType> orderType) {
		ArrayList<BriefOrderInfoVO> mockBriefOrderlist = new ArrayList<BriefOrderInfoVO>();
		mockBriefOrderlist.add(mockBriefOrderInfoVO);
		return mockBriefOrderlist;
	}
	
	public OrderVO getDetailedOrder(String orderID) {
		
		return mockOrderVO;
	}
}
