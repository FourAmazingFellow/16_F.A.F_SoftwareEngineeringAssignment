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
	public OrderState orderState;
	public boolean isCommented;

	public OrderVO(String userID, String orID, String hN, String hA, Date bD, Date fD, RoomType rT, int n, int tP,
			Date oPT, Date lODT, int nOP, boolean isChild, boolean isOnSale, OrderState orderS, boolean isCom) {

		super(userID, orID, hN, hA, bD, fD, rT, n, tP);

		orderProducedTime = oPT;
		lastedOrderDoneTime = lODT;
		numOfPerson = nOP;
		isChildren = isChild;
		this.isOnSale = isOnSale;
		orderState = orderS;
		isCommented = isCom;
	}
}
