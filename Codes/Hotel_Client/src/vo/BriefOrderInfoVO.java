package vo;

import java.util.Date;

import po.BriefOrderInfoPO;
import po.OrderState;
import po.RoomType;

/**
 * 简要订单信息的值对象
 * @author Accident
 * @version 
 * @see
 */
public class BriefOrderInfoVO {
	public String userID;
	public String orderID;
	public String hotelName;
	public String hotelAddress;
	public Date beginDate;
	public Date finishDate;
	public RoomType roomType;
	public int num;
	public int totalPrice;
	public Enum<OrderState> orderState;
	
	public BriefOrderInfoVO(String userID, String orderID, String hN, String hA, Date bD,
			Date fD, RoomType rT, int n, int tP, Enum<OrderState> orderS) {
		this.orderID = orderID;
		this.userID = userID;
		hotelName = hN;
		hotelAddress = hA;
		beginDate = bD;
		finishDate = fD;
		roomType = rT;
		num = n;
		totalPrice = tP;
		orderState = orderS;
	}
	
	public BriefOrderInfoVO(BriefOrderInfoPO po){
		userID = po.getUserID();
		orderID = po.getOrderID();
		hotelName = po.getHotelName();
		hotelAddress = po.getHotelAddress();
		beginDate = po.getBeginDate();
		finishDate = po.getFinishDate();
		roomType = po.getRoomType();
		num = po.getNum();
		totalPrice = po.getTotalPrice();
		orderState = po.getOrderState();
	}
}
