package po;

import java.util.HashMap;

import vo.HotelVO;

/**
 * 酒店详细信息的实体类，负责持久化数据传输
 * @author 原
 * @version 1.0
 * @see
 */
public class HotelPO extends BriefHotelInfoPO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5323675892066362088L;
	private String briefIntroduction;
	private String facilityAndService;
	private HashMap<RoomType, Integer> roomTypeAndPrice;
	private HashMap<RoomType, Integer> roomTypeAndNums;
	private HashMap<String, String> comments;
	
	public HotelPO(String hotelName, String businessDistrict, String hotelAddress, int starLevel, float mark, String city,
			String briefIntroduction, String facilityAndService, HashMap<RoomType, Integer> roomTypeAndPrice,HashMap<RoomType, Integer> roomTypeAndNums,
			HashMap<String, String> comments) {
		super(hotelName, businessDistrict, hotelAddress, starLevel, mark, city);
		this.briefIntroduction = briefIntroduction;
		this.facilityAndService = facilityAndService;
		this.roomTypeAndPrice = roomTypeAndPrice;
		this.roomTypeAndNums = roomTypeAndNums;
		this.comments = comments;
	}
	
	public HotelPO(HotelVO hotelVO) {
		super(hotelVO);
		this.briefIntroduction = hotelVO.briefIntroduction;
		this.facilityAndService = hotelVO.facilityAndService;
		this.roomTypeAndPrice = hotelVO.roomTypeAndPrice;
		this.roomTypeAndNums = hotelVO.roomTypeAndNums;
		this.comments = hotelVO.comments;
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
