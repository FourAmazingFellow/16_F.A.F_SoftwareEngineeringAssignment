package bl_Stub.hotelblservice_Stub;

import java.util.HashMap;

import businesslogicservice.hotelblservice.MaintainHotelBasicInfoService;
import po.RoomType;
import vo.HotelVO;

public class MaintainHotelBasicInfoServiceImpl_Stub implements MaintainHotelBasicInfoService {

	public String briefIntroduction;
	public String facilityAndService;
	public HashMap<RoomType, Integer> roomTypeAndPrice;
	public HashMap<String, String> comments;
	
	public MaintainHotelBasicInfoServiceImpl_Stub(String briefIntroduction, String facilityAndService,
			HashMap<RoomType, Integer> roomTypeAndPrice, HashMap<String, String> comments) {
		this.briefIntroduction = briefIntroduction;
		this.facilityAndService = facilityAndService;
		this.roomTypeAndPrice = roomTypeAndPrice;
		this.comments = comments;
	}
	@Override
	public HotelVO enrollHotelBasicInfo(String address) {
		return null;
	}

	@Override
	public boolean confirmModify(HotelVO modified) {
		return false;
	}

}
