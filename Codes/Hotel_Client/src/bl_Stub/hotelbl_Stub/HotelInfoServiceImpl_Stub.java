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
	public int mark;
	
	public String briefIntroduction;
	public String facilityAndService;
	public HashMap<RoomType, Integer> roomTypeAndPrice;
	public HashMap<String, String> comments;
	
	public HotelInfoServiceImpl_Stub(String hotelName, String businessDistrict, String hotelAddress, int starLevel,
			int mark, String briefIntroduction, String facilityAndService, HashMap<RoomType, Integer> roomTypeAndPrice,
			HashMap<String, String> comments) {
		this.hotelName = hotelName;
		this.businessDistrict = businessDistrict;
		this.hotelAddress = hotelAddress;
		this.starLevel = starLevel;
		this.mark = mark;
		this.briefIntroduction = briefIntroduction;
		this.facilityAndService = facilityAndService;
		this.roomTypeAndPrice = roomTypeAndPrice;
		this.comments = comments;
	}
	
	public HotelInfoServiceImpl_Stub(String hotelName, String businessDistrict, String hotelAddress, int starLevel,
			int mark) {
		this.hotelName = hotelName;
		this.businessDistrict = businessDistrict;
		this.hotelAddress = hotelAddress;
		this.starLevel = starLevel;
		this.mark = mark;
	}
	
	@Override
	public BriefHotelInfoVO getHotelBriefInfo(String address) {
		return new BriefHotelInfoVO(hotelName, businessDistrict, hotelAddress, starLevel, mark);
	}

	@Override
	public HotelVO getHotelDetails(String address) {
		return new HotelVO(hotelName, businessDistrict, hotelAddress, starLevel, mark, briefIntroduction, facilityAndService, roomTypeAndPrice, comments);
	}

}
