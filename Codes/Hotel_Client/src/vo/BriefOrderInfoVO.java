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
	public long userID;
	public String orderID;
	public String hotelName;
	public String hotelAddress;
	public Date beginDate;
	public Date finishDate;
	public RoomType roomType;
	public int num;
	public int totalPrice;

	public BriefOrderInfoVO(long userID, String orderID, String hN, String hA, Date bD,
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
	
	@SuppressWarnings("deprecation")
	public BriefOrderInfoVO(){
		this.orderID = "0001000100010001";
		this.userID = 666;
		hotelName = "F.A.F酒店";
		hotelAddress = "南京大学";
		beginDate = new Date(2016,10,16);
		finishDate = new Date(2016,10,17);
		roomType = RoomType.KING_SIZE_ROOM;
		num = 1;
		totalPrice = 100;
	}
}
