package presentation.orderui;

import java.util.Date;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import po.OrderState;
import po.RoomType;

public class FxBriefOrder {
	private StringProperty userID;
	private StringProperty orderID;
	private StringProperty hotelName;
	private StringProperty hotelAddress;
	private StringProperty beginDate;
	private StringProperty finishDate;
	private StringProperty roomType;
	private StringProperty num;
	private StringProperty totalPrice;
	private StringProperty orderState;
	
	public FxBriefOrder(String userID, String orderID, String hotelName, String hotelAddress, Date beginDate, 
			Date finishDate, Enum<RoomType> roomType, int num, int totalPrice, Enum<OrderState> orderState) {
		this.userID = new SimpleStringProperty(userID);
		this.orderID = new SimpleStringProperty(orderID);
		this.hotelName = new SimpleStringProperty(hotelName);
		this.hotelAddress = new SimpleStringProperty(hotelAddress);
		this.beginDate = new SimpleStringProperty(toDate(beginDate));
		this.finishDate = new SimpleStringProperty(toDate(finishDate));
		//判断房型
		switch ((RoomType)roomType) {
		case KING_SIZE_ROOM:
			this.roomType = new SimpleStringProperty("大床房");
			break;
		case SINGLE_ROOM:
			this.roomType = new SimpleStringProperty("单人房");
			break;
		case STANDARD_ROOM:
			this.roomType = new SimpleStringProperty("标准间");
			break;
		case TRIBLE_ROOM:
			this.roomType = new SimpleStringProperty("三人房");
			break;
		default:
			break;
		}
		this.num = new SimpleStringProperty(String.valueOf(num));
		this.totalPrice = new SimpleStringProperty(String.valueOf(totalPrice));
		
		//判断订单状态
		switch ((OrderState)orderState) {
		case ABNORMAL_ORDER:
			this.orderState = new SimpleStringProperty("异常订单");
			break;
		case DONE_ORDER:
			this.orderState = new SimpleStringProperty("已执行订单");
			break;
		case NOT_DONE_ORDER:
			this.orderState = new SimpleStringProperty("未执行订单");
			break;
		case WITHDREW_ORDER:
			this.orderState = new SimpleStringProperty("已撤销订单");
			break;
		default:
			break;
		}
	}
	
	@SuppressWarnings("deprecation")
	public static String toDate(Date date) {
		String year = String.valueOf(date.getYear() + 1900);
		String month = String.valueOf(date.getMonth() + 1);
		String day = String.valueOf(date.getDay());
		return year + "年" + month + "月" + day + "日";
	}
	
	@SuppressWarnings("deprecation")
	public static String toSec(Date date) {
		String year = String.valueOf(date.getYear() + 1900);
		String month = String.valueOf(date.getMonth() + 1);
		String day = String.valueOf(date.getDay());
		String hour = String.valueOf(date.getHours());
		String min = String.valueOf(date.getMinutes());
		String sec = String.valueOf(date.getSeconds());
		return year + "年" + month + "月" + day + "日" + " " + hour + ":" + min + ":" + sec;
	}
	
	public StringProperty getUserID() {
		return userID;
	}
	public StringProperty getOrderID() {
		return orderID;
	}
	public StringProperty getHotelName() {
		return hotelName;
	}
	public StringProperty getHotelAddress() {
		return hotelAddress;
	}
	public StringProperty getBeginDate() {
		return beginDate;
	}
	public StringProperty getFinishDate() {
		return finishDate;
	}
	public StringProperty getRoomType() {
		return roomType;
	}
	public StringProperty getNum() {
		return num;
	}
	public StringProperty getTotalPrice() {
		return totalPrice;
	}
	public StringProperty getOrderState() {
		return orderState;
	}
}
