package businesslogic.utilitybl;

import po.OrderPO;
import vo.OrderVO;

public class VO2PO {
	public OrderPO orderVO2PO(OrderVO vo) {
		OrderPO po = new OrderPO(vo.userID, vo.orderID, vo.hotelName, vo.hotelAddress, vo.beginDate, vo.finishDate,
				vo.roomType, vo.num, vo.totalPrice, vo.orderProducedTime, vo.lastedOrderDoneTime, vo.numOfPerson,
				vo.isChildren, vo.isOnSale, vo.orderState, vo.isCommented);
		return po;
	}
}
