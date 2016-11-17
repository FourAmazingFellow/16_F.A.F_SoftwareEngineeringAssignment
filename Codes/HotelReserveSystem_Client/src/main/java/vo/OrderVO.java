package vo;

import java.util.Date;
import po.OrderState;
import po.RoomType;

/**
 * 详细订单信息的值对象
 * 
 * @author Accident
 * @version 1.0
 * @see
 */
public class OrderVO extends BriefOrderInfoVO {
	public Date orderProducedTime;
	public Date lastedOrderDoneTime;
	public int numOfPerson;
	public boolean isChildren;
	public boolean isOnSale;
	public boolean isCommented;

	public OrderVO(String userID, String orderID, String hotelName, String hotelAddress, Date beginDate, 
			Date finishDate, Enum<RoomType> roomType, int num, int totalPrice, Enum<OrderState> orderState, Date orderProducedTime,
			Date lastedOrderDoneTime, int numOfPerson, boolean isChild, boolean isOnSale, boolean isCommented) {

		super(userID, orderID, hotelAddress, hotelName, beginDate, finishDate, roomType, num, totalPrice, orderState);

		this.orderProducedTime = orderProducedTime;
		this.lastedOrderDoneTime = lastedOrderDoneTime;
		this.numOfPerson = numOfPerson;
		this.isChildren = isChild;
		this.isOnSale = isOnSale;
		this.isCommented = isCommented;
	}
}