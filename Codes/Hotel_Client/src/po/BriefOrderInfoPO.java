package po;

import java.util.Date;

/**
 * 
 * @author Accident
 * @version 
 * @see
 */
public class BriefOrderInfoPO {
	private long userID;
	private String orderID;
	private String hotelName;
	private String hotelAddress;
	private Date beginDate;
	private Date finishDate;
	private RoomType roomType;
	private int num;
	private int totalPrice;

	public BriefOrderInfoPO(long userID, String orderID, String hN, String hA, Date bD,
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

	public long getUserID() {
		return userID;
	}

	public String getOrderID(){
		return orderID;
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

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public void setOrderID(String orderID){
		this.orderID = orderID;
	}
	
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
}
