package businesslogic.orderbl.createNewOrder;

import java.util.Date;

import po.OrderState;
import po.RoomType;
import vo.OrderVO;

public class MockNewOrder extends NewOrder {
	private int price;
	private boolean result;
	private OrderVO initailedOrder;
	
	@SuppressWarnings("deprecation")
	public MockNewOrder(int price, boolean result, String userID, String address) {
		this.price = price;
		this.result = result;
		initailedOrder = new OrderVO(userID, "0001000100010002", "汉庭", address, new Date(2016,10,16),
				new Date(2016,10,17),RoomType.KING_SIZE_ROOM,1,-1, OrderState.ABNORMAL_ORDER, new Date(2016,10,16,18,0),
				new java.util.Date(2016, 10, 16, 20, 0),2,false,true,false);
	}
	
	public OrderVO initNewOrder(String userID, String address) {
		return initailedOrder;
	}

	public int getPrice(OrderVO vo) {
		return price;
	}

	public boolean addNewOrder(OrderVO vo) {
		return result;
	}
}
