package businesslogic.orderbl.checkAbnormalOrder;

import java.util.ArrayList;
import java.util.Date;

import po.OrderState;
import po.RoomType;
import vo.BriefOrderInfoVO;
import vo.OrderVO;

public class MockAbnormalOrderList extends AbnormalOrderList {
	private BriefOrderInfoVO mockAbnormalBriefOrderInfoVO;
	private OrderVO mockAbnormalOrderVO;
	
	@SuppressWarnings("deprecation")
	public MockAbnormalOrderList() {
		mockAbnormalBriefOrderInfoVO = new BriefOrderInfoVO("Wan", "0000000000000003","仙林大酒店", "仙林大道163号",new Date(2016,10,16),
				new Date(2016,10,17),RoomType.KING_SIZE_ROOM,1,100, OrderState.ABNORMAL_ORDER);
		
		mockAbnormalOrderVO = new OrderVO("Wan","0000000000000003","仙林大酒店", "仙林大道163号" ,new Date(2016,10,16),
				new Date(2016,10,17), RoomType.KING_SIZE_ROOM, 1, 100, OrderState.ABNORMAL_ORDER, new Date(2016,10,16,18,0),
				new java.util.Date(2016, 10, 16, 20, 0),2,false,true,false);
	}
	
	public ArrayList<BriefOrderInfoVO> getAbnormalOrderList(Date date) {
		ArrayList<BriefOrderInfoVO> mockAbnormalBriefOrderInfoVOList = new ArrayList<BriefOrderInfoVO>();
		mockAbnormalBriefOrderInfoVOList.add(mockAbnormalBriefOrderInfoVO);
		return mockAbnormalBriefOrderInfoVOList;
	}
	
	public OrderVO getDetailedOrder(String orderID) {
		
		return mockAbnormalOrderVO;
	}
}
