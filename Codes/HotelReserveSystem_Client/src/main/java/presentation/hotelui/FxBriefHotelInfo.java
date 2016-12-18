package presentation.hotelui;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class FxBriefHotelInfo {
	private StringProperty hotelName;
	private StringProperty tradeArea;
	private StringProperty hotelAddress;
	private StringProperty starLevel;
	private StringProperty mark;
	private StringProperty orderTypes;
	
	public FxBriefHotelInfo(String hotelName, String tradeArea, String hotelAddress,
			String starLevel, float mark, String orderTypes) {
		this.hotelName = new SimpleStringProperty(hotelName);
		this.tradeArea = new SimpleStringProperty(tradeArea);
		this.hotelAddress = new SimpleStringProperty(hotelAddress);
		this.starLevel = new SimpleStringProperty(starLevel);
		this.mark = new SimpleStringProperty(String.valueOf(mark));
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
	
	public StringProperty getOrderTypes() {
		return orderTypes;
	}
}
