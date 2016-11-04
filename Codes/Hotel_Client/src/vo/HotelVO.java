package vo;

import java.util.HashMap;

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
	
	public HotelVO(String hotelName, String businessDistrict, String hotelAddress, int starLevel, int mark,
			String briefIntroduction, String facilityAndService, HashMap<RoomType, Integer> roomTypeAndPrice, HashMap<RoomType, Integer> roomTypeAndNums,
			HashMap<String, String> comments) {
		super(hotelName, businessDistrict, hotelAddress, starLevel, mark);
		this.briefIntroduction = briefIntroduction;
		this.facilityAndService = facilityAndService;
		this.roomTypeAndPrice = roomTypeAndPrice;
		this.roomTypeAndNums = roomTypeAndNums;
		this.comments = comments;
	}
}
