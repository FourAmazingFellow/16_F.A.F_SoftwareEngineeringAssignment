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
		initailedOrder = new OrderVO(userID, "0000000000000003", "汉庭酒店", address, new Date(2016, 12, 20),
				new Date(2016, 12, 21), RoomType.STANDARD_ROOM, 1, 200, OrderState.NOT_DONE_ORDER,
				new Date(2016, 12, 15, 18, 0), new Date(2016, 12, 20, 22, 0), 2, false, false, false);
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
