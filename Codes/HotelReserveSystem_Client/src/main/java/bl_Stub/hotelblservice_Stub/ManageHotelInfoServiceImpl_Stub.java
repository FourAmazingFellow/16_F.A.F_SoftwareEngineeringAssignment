package bl_Stub.hotelblservice_Stub;

import java.util.HashMap;

import businesslogicservice.hotelblservice.ManageHotelInfoService;
import po.RoomType;
import po.UserType;
import vo.HotelVO;
import vo.UserVO;

public class ManageHotelInfoServiceImpl_Stub implements ManageHotelInfoService {

	public String briefIntroduction;
	public String facilityAndService;
	public HashMap<RoomType, Integer> roomTypeAndPrice;
	public HashMap<String, String> comments;
	
	public long userID;
	public String password;
	public long telNum;
	public String creditChangeRecord;
	public Enum<UserType> UserType;
	
	public ManageHotelInfoServiceImpl_Stub(String briefIntroduction, String facilityAndService,
			HashMap<RoomType, Integer> roomTypeAndPrice, HashMap<String, String> comments) {
		this.briefIntroduction = briefIntroduction;
		this.facilityAndService = facilityAndService;
		this.roomTypeAndPrice = roomTypeAndPrice;
		this.comments = comments;
	}
	
	public ManageHotelInfoServiceImpl_Stub(long userID, String password, long telNum, String creditChangeRecord,
			Enum<po.UserType> userType) {
		this.userID = userID;
		this.password = password;
		this.telNum = telNum;
		this.creditChangeRecord = creditChangeRecord;
		UserType = userType;
	}
	
	@Override
	public boolean addHotel(HotelVO hotel) {
		return true;
	}

	@Override
	public boolean addHotelStaff(UserVO staff) {
		return true;
	}

}
