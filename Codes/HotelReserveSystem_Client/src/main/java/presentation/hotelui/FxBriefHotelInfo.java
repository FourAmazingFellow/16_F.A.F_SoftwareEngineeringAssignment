package presentation.hotelui;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * 自定义HotelModel类，用于界面层展示
 * @author Accident
 * @version 
 * @see
 */
public class FxBriefHotelInfo {
	private StringProperty hotelName;
	private StringProperty tradeArea;
	private StringProperty hotelAddress;
	private StringProperty starLevel;
	private StringProperty mark;
	private StringProperty minPrice;
	private StringProperty orderTypes;
	
	public FxBriefHotelInfo(String hotelName, String tradeArea, String hotelAddress,
			String starLevel, float mark, int minPrice, String orderTypes) {
		this.hotelName = new SimpleStringProperty(hotelName);
		this.tradeArea = new SimpleStringProperty(tradeArea);
		this.hotelAddress = new SimpleStringProperty(hotelAddress);
		this.starLevel = new SimpleStringProperty(starLevel);
		this.mark = new SimpleStringProperty(String.valueOf(mark));
		this.minPrice = new SimpleStringProperty(String.valueOf(minPrice));
		this.orderTypes = new SimpleStringProperty(orderTypes);
	}

	public StringProperty getHotelName() {
		return hotelName;
	}

	public StringProperty getTradeArea() {
		return tradeArea;
	}

	public StringProperty getHotelAddress() {
		return hotelAddress;
	}

	public StringProperty getStarLevel() {
		return starLevel;
	}

	public StringProperty getMark() {
		return mark;
	}
	
	public StringProperty getMinPrice() {
		return minPrice;
	}
	
	public StringProperty getOrderTypes() {
		return orderTypes;
	}
}
