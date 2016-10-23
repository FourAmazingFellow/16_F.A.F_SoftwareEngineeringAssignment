package vo;

import java.util.Date;

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

	public BriefOrderInfoVO(String userID, String orderID, String hN, String hA, Date bD,
			Date fD, RoomType rT, int n, int tP) {
		this.orderID = orderID;
		this.userID = userID;
		hotelName = hN;
		hotelAddress = hA;
		beginDate = bD;
		finishDate = fD;
		roomType = rT;
		num = n;
		totalPrice = tP;
	}
}
