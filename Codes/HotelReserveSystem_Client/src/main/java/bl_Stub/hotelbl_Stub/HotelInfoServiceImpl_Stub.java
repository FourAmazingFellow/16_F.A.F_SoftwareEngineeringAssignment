package bl_Stub.hotelbl_Stub;

import java.util.HashMap;

import businesslogic.hotelbl.HotelInfoService;
import po.RoomType;
import vo.BriefHotelInfoVO;
import vo.HotelVO;

public class HotelInfoServiceImpl_Stub implements HotelInfoService {

	public String hotelName;
	public String businessDistrict;
	public String hotelAddress;
	public int starLevel;
	public float mark;
	public String city;
	
	public String briefIntroduction;
	public String facilityAndService;
	public HashMap<RoomType, Integer> roomTypeAndPrice;
	public HashMap<RoomType, Integer> roomTypeAndNums;
	public HashMap<String, String> comments;
	
	public HotelInfoServiceImpl_Stub(String hotelName, String businessDistrict, String hotelAddress, int starLevel,
			float mark, String city, String briefIntroduction, String facilityAndService, HashMap<RoomType, Integer> roomTypeAndPrice, HashMap<RoomType, Integer> roomTypeAndNums,
			HashMap<String, String> comments) {
		this.hotelName = hotelName;
		this.businessDistrict = businessDistrict;
		this.hotelAddress = hotelAddress;
		this.starLevel = starLevel;
		this.mark = mark;
		this.city = city;
		this.briefIntroduction = briefIntroduction;
		this.facilityAndService = facilityAndService;
		this.roomTypeAndPrice = roomTypeAndPrice;
		this.roomTypeAndNums = roomTypeAndNums;
		this.comments = comments;
	}
	
	public HotelInfoServiceImpl_Stub(String hotelName, String businessDistrict, String hotelAddress, int starLevel,
			float mark, String city) {
		this.hotelName = hotelName;
		this.businessDistrict = businessDistrict;
		this.hotelAddress = hotelAddress;
		this.starLevel = starLevel;
		this.mark = mark;
		this.city = city;
	}
	
	@Override
	public BriefHotelInfoVO getHotelBriefInfo(String address) {
		return new BriefHotelInfoVO(hotelName, businessDistrict, hotelAddress, starLevel, mark, city);
	}

	@Override
	public HotelVO getHotelDetails(String address) {
		return new HotelVO(hotelName, businessDistrict, hotelAddress, starLevel, mark, city, briefIntroduction, facilityAndService, roomTypeAndPrice, roomTypeAndNums, comments);
	}

}
