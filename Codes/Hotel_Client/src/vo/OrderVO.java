package vo;

import java.util.Date;
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
	public OrderState orderState;
	public boolean isCommented;

	public OrderVO(long userID, String orID, String hN, String hA, Date bD, Date fD, RoomType rT, int n, int tP,
			String ID, Date oPT, Date lODT, int nOP, boolean isChild, boolean isOnSale, OrderState orderS,
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

	@SuppressWarnings("deprecation")
	public OrderVO() {
		orderProducedTime = new Date(2016, 10, 16, 18, 0);
		lastedOrderDoneTime = new Date(2016, 10, 16, 20, 0);
		numOfPerson = 2;
		isChildren = false;
		this.isOnSale = false;
		orderState = OrderState.NOT_DONE_ORDER;
		isCommented = false;
	}
}
