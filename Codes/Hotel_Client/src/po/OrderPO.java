package po;

import java.util.Calendar;
import java.util.Date;

/**
 * 详细订单信息PO（继承简要订单信息PO），负责持久化数据传输
 * @author Accident
 * @version 1.0
 * @see
 */

public class OrderPO extends BriefOrderInfoPO {
	private Calendar orderProducedTime;
	private Calendar lastedOrderDoneTime;
	private int numOfPerson;
	private boolean isChildren;
	private boolean isOnSale;
	private OrderState orderState;
	private boolean isCommented;

	public OrderPO(long userID,String orID, String hN, String hA, Date bD, Date fD, RoomType rT, int n, int tP,
			String ID, Calendar oPT, Calendar lODT, int nOP, boolean isChild,
			boolean isOnSale, OrderState orderS, boolean isCom) {
		
		super(userID, orID, hN, hA, bD, fD, rT, n, tP);
		
		orderProducedTime = oPT;
		lastedOrderDoneTime = lODT;
		numOfPerson = nOP;
		isChildren = isChild;
		this.isOnSale = isOnSale;
		orderState = orderS;
		isCommented = isCom;
	}

	public Calendar getOrderProducedTime() {
		return orderProducedTime;
	}

	public Calendar getLastedOrderDoneTime() {
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

	public void setOrderProducedTime(Calendar orderProducedTime) {
		this.orderProducedTime = orderProducedTime;
	}

	public void setLastedOrderDoneTime(Calendar lastedOrderDoneTime) {
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