package po;

import java.util.Date;

/**
 * 简要订单信息PO，负责持久化数据传输
 * @author Accident
 * @version 1.0
 * @see
 */
public class BriefOrderInfoPO {
	private String userID;
	private String orderID;
	private String hotelName;
	private String hotelAddress;
	private Date beginDate;
	private Date finishDate;
	private RoomType roomType;
	private int num;
	private int totalPrice;
	public Enum<OrderState> orderState;

	public BriefOrderInfoPO(String userID, String orderID, String hN, String hA, Date bD,
			Date fD, RoomType rT, int n, int tP, Enum<OrderState> orderState) {
		this.orderID = orderID;
		this.userID = userID;
		hotelName = hN;
		hotelAddress = hA;
		beginDate = bD;
		finishDate = fD;
		roomType = rT;
		num = n;
		totalPrice = tP;
		this.orderState = orderState;
	}
	
	public String getUserID() {
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

	public Enum<OrderState> getOrderState() {
		return orderState;
	}
	
	public void setUserID(String userID) {
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
	
	public void setOrderState(Enum<OrderState> orderState) {
		this.orderState = orderState;
	}
}
