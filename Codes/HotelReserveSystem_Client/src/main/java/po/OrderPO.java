package po;

import java.util.Date;

/**
 * 详细订单信息PO（继承简要订单信息PO），负责持久化数据传输
 * 
 * @author Accident
 * @version 1.0
 * @see
 */

public class OrderPO extends BriefOrderInfoPO {
	private Date orderProducedTime;
	private Date lastedOrderDoneTime;
	private int numOfPerson;
	private boolean isChildren;
	private boolean isOnSale;
	private boolean isCommented;

	public OrderPO(String userID, String orderID, String hotelName, String hotelAddress, Date beginDate, 
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

	public Date getOrderProducedTime() {
		return orderProducedTime;
	}

	public Date getLastedOrderDoneTime() {
		return lastedOrderDoneTime;
	}

	public int getNumOfPerson() {
		return numOfPerson;
	}

	public boolean isChildren() {
		return isChildren;
	}

	public boolean isOnSale() {
		return isOnSale;
	}

	public boolean isCommented() {
		return isCommented;
	}

	public void setOrderProducedTime(Date orderProducedTime) {
		this.orderProducedTime = orderProducedTime;
	}

	public void setLastedOrderDoneTime(Date lastedOrderDoneTime) {
		this.lastedOrderDoneTime = lastedOrderDoneTime;
	}

	public void setNumOfPerson(int numOfPerson) {
		this.numOfPerson = numOfPerson;
	}

	public void setChildren(boolean isChildren) {
		this.isChildren = isChildren;
	}

	public void setOnSale(boolean isOnSale) {
		this.isOnSale = isOnSale;
	}

	public void setOrderState(OrderState orderState) {
		this.orderState = orderState;
	}

	public void setCommented(boolean isCommented) {
		this.isCommented = isCommented;
	}

}
