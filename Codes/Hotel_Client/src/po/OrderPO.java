package po;

import java.util.Calendar;
import java.util.Date;

public class OrderPO extends OrderBriefInfoPO {
	String orderID;
	Calendar orderProducedTime;
	Calendar lastedOrderDoneTime;
	int numOfPerson;
	boolean isChildren;
	boolean isOnSale;
	OrderState orderState;
	boolean isCommented;

	public OrderPO(long userID,String hN, String hA, Date bD, Date fD, RoomType rT, int n, int tP,
			String ID, Calendar oPT, Calendar lODT, int nOP, boolean isChild,
			boolean isOnSale, OrderState orderS, boolean isCom) {
		
		super(userID, hN, hA, bD, fD, rT, n, tP);
		
		orderID = ID;
		orderProducedTime = oPT;
		lastedOrderDoneTime = lODT;
		numOfPerson = nOP;
		isChildren = isChild;
		this.isOnSale = isOnSale;
		orderState = orderS;
		isCommented = isCom;
	}

	public String getOrderID() {
		return orderID;
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
	
}
