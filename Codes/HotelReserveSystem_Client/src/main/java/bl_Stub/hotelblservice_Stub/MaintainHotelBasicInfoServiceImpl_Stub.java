package bl_Stub.hotelblservice_Stub;

import java.util.HashMap;

import businesslogicservice.hotelblservice.MaintainHotelBasicInfoService;
import po.RoomType;
import vo.HotelVO;

public class MaintainHotelBasicInfoServiceImpl_Stub implements MaintainHotelBasicInfoService {

	public String hotelName;
	public String tradeArea;
	public String hotelAddress;
	public int starLevel;
	public int mark;
	public String city;
	public String briefIntroduction;
	public String facilityAndService;
	public HashMap<RoomType, Integer> roomTypeAndPrice;
	public HashMap<RoomType, Integer> roomTypeAndNums;
	public HashMap<String, String> comments;
	
	public MaintainHotelBasicInfoServiceImpl_Stub(String hotelName, String tradeArea, String hotelAddress,
			int starLevel, int mark, String city, String briefIntroduction, String facilityAndService,
			HashMap<RoomType, Integer> roomTypeAndPrice, HashMap<RoomType, Integer> roomTypeAndNums, HashMap<String, String> comments) {
		this.hotelName = hotelName;
		this.tradeArea = tradeArea;
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
	@Override
	public HotelVO enrollHotelBasicInfo(String address) {
		return new HotelVO(hotelName, tradeArea, address, starLevel, mark, city, briefIntroduction, facilityAndService, roomTypeAndPrice, roomTypeAndNums, comments);
	}

	@Override
	public boolean confirmModify(HotelVO modified) {
		return true;
	}

}
