package bl_Stub.hotelblservice_Stub;

import java.util.HashMap;

import businesslogicservice.hotelblservice.MaintainHotelBasicInfoService;
import po.RoomType;
import vo.HotelVO;

public class MaintainHotelBasicInfoServiceImpl_Stub implements MaintainHotelBasicInfoService {

	public String hotelName;
	public String businessDistrict;
	public String hotelAddress;
	public int starLevel;
	public int mark;
	public String briefIntroduction;
	public String facilityAndService;
	public HashMap<RoomType, Integer> roomTypeAndPrice;
	public HashMap<String, String> comments;
	
	public MaintainHotelBasicInfoServiceImpl_Stub(String hotelName, String businessDistrict, String hotelAddress,
			int starLevel, int mark, String briefIntroduction, String facilityAndService,
			HashMap<RoomType, Integer> roomTypeAndPrice, HashMap<String, String> comments) {
		super();
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
	@Override
	public HotelVO enrollHotelBasicInfo(String address) {
		return new HotelVO(hotelName, businessDistrict, hotelAddress, starLevel, mark, address, address, roomTypeAndPrice, comments);
	}

	@Override
	public boolean confirmModify(HotelVO modified) {
		return true;
	}

}
