package po;

import java.util.Date;

public class OrderBriefInfoPO {
	long userID;
	String hotelName;
	String hotelAddress;
	Date beginDate;
	Date finishDate;
	RoomType roomType;
	int num;
	int totalPrice;
	
	public OrderBriefInfoPO(long userID,String hN, String hA, Date bD,
			Date fD, RoomType rT, int n, int tP) {
		this.userID = userID;
		hotelName = hN;
		hotelAddress = hA;
		beginDate = bD;
		finishDate = fD;
		roomType = rT;
		num = n;
		totalPrice = tP;
	}
	public long getUserID() {
		return userID;
	}
	public String getHotelName() {
		return hotelName;
	}

	public String getHotelAddress() {
		return hotelAddress;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public int getNum() {
		return num;
	}

	public int getTotalPrice() {
		return totalPrice;
	}
}
