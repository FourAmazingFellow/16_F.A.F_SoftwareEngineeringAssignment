package po;

import java.util.HashMap;

/**
 * 酒店详细信息的实体类，负责持久化数据传输
 * @author 原
 * @version 1.0
 * @see
 */
public class HotelPO extends BriefHotelInfoPO {
	
	private String briefIntroduction;
	private String facilityAndService;
	private HashMap<RoomType, Integer> roomTypeAndPrice;
	private HashMap<RoomType, Integer> roomTypeAndNums;
	private HashMap<String, String> comments;
	
	public HotelPO(String hotelName, String businessDistrict, String hotelAddress, int starLevel, int mark,
			String briefIntroduction, String facilityAndService, HashMap<RoomType, Integer> roomTypeAndPrice,HashMap<RoomType, Integer> roomTypeAndNums,
			HashMap<String, String> comments) {
		super(hotelName, businessDistrict, hotelAddress, starLevel, mark);
		this.briefIntroduction = briefIntroduction;
		this.facilityAndService = facilityAndService;
		this.roomTypeAndPrice = roomTypeAndPrice;
		this.roomTypeAndNums = roomTypeAndNums;
		this.comments = comments;
	}
	public String getBriefIntroduction() {
		return briefIntroduction;
	}
	public void setBriefIntroduction(String briefIntroduction) {
		this.briefIntroduction = briefIntroduction;
	}
	public String getFacilityAndService() {
		return facilityAndService;
	}
	public void setFacilityAndService(String facilityAndService) {
		this.facilityAndService = facilityAndService;
	}
	public HashMap<RoomType, Integer> getRoomTypeAndPrice() {
		return roomTypeAndPrice;
	}
	public void setRoomTypeAndPrice(HashMap<RoomType, Integer> roomTypeAndPrice) {
		this.roomTypeAndPrice = roomTypeAndPrice;
	}
	public HashMap<RoomType, Integer> getRoomTypeAndNums() {
		return roomTypeAndNums;
	}
	public void setRoomTypeAndNums(HashMap<RoomType, Integer> roomTypeAndNums) {
		this.roomTypeAndNums = roomTypeAndNums;
	}
	public HashMap<String, String> getComments() {
		return comments;
	}
	public void setComments(HashMap<String, String> comments) {
		this.comments = comments;
	}
	
	
}
