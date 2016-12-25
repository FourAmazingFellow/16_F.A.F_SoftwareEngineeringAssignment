package vo;

import java.util.HashMap;

import po.HotelPO;
import po.RoomType;

/**
 * 
 * @author 原
 * @version 1.0
 * @see
 */
public class HotelVO extends BriefHotelInfoVO{

	public String briefIntroduction;
	public String facilityAndService;
	public HashMap<RoomType, Integer> roomTypeAndPrice;
	public HashMap<RoomType, Integer> roomTypeAndNums;
	public HashMap<String, String> comments;
	
	public HotelVO(String hotelName, String tradeArea, String hotelAddress, int starLevel, float mark, String city, int min_Price, int max_Price,
			String briefIntroduction, String facilityAndService, HashMap<RoomType, Integer> roomTypeAndPrice, HashMap<RoomType, Integer> roomTypeAndNums,
			HashMap<String, String> comments) {
		super(hotelName, tradeArea, hotelAddress, starLevel, mark, city, min_Price, max_Price);
		this.briefIntroduction = briefIntroduction;
		this.facilityAndService = facilityAndService;
		this.roomTypeAndPrice = roomTypeAndPrice;
		this.roomTypeAndNums = roomTypeAndNums;
		this.comments = comments;
	}
	
	public HotelVO(HotelPO hotelPO) {
		super(hotelPO);
		this.briefIntroduction = hotelPO.getBriefIntroduction();
		this.facilityAndService = hotelPO.getFacilityAndService();
		this.roomTypeAndPrice = hotelPO.getRoomTypeAndPrice();
		this.roomTypeAndNums = hotelPO.getRoomTypeAndNums();
		this.comments = hotelPO.getComments();
	}
}
