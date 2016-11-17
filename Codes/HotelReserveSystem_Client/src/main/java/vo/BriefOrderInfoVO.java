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
	public Enum<RoomType> roomType;
	public int num;
	public int totalPrice;
	public Enum<OrderState> orderState;
	
	public BriefOrderInfoVO(String userID, String orderID, String hotelName, String hotelAddress, Date beginDate, 
			Date finishDate, Enum<RoomType> roomType, int num, int totalPrice, Enum<OrderState> orderState) {
		this.orderID = orderID;
		this.userID = userID;
		this.hotelName = hotelName;
		this.hotelAddress = hotelAddress;
		this.beginDate = beginDate;
		this.finishDate = finishDate;
		this.roomType = roomType;
		this.num = num;
		this.totalPrice = totalPrice;
		this.orderState = orderState;
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
