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
	private OrderState orderState;
	private boolean isCommented;

	public OrderPO(String userID, String orID, String hN, String hA, Date bD, Date fD, RoomType rT, int n, int tP,
			Date oPT, Date lODT, int nOP, boolean isChild, boolean isOnSale, OrderState orderS,
			boolean isCom) {

		super(userID, orID, hN, hA, bD, fD, rT, n, tP);

		orderProducedTime = oPT;
		lastedOrderDoneTime = lODT;
		numOfPerson = nOP;
		isChildren = isChild;
		this.isOnSale = isOnSale;
		orderState = orderS;
		isCommented = isCom;
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

	public OrderState getOrderState() {
		return orderState;
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
