package bl_Stub.hotelblservice_Stub;

import java.util.HashMap;

import businesslogicservice.hotelblservice.ManageHotelInfoService;
import po.RoomType;
import po.UserType;
import vo.HotelStaffInfoVO;
import vo.HotelVO;

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
	
	public String hotelName;
	public String city;
	public String tradeArea;
	public int starLevel;
	public float mark;
	public HashMap<RoomType, Integer> roomTypeAndNums;
	
	
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
	
	public ManageHotelInfoServiceImpl_Stub(){
		
	}
	
	@Override
	public boolean addHotel(HotelVO hotel) {
		return true;
	}

	@Override
	public boolean addHotelStaff(HotelStaffInfoVO staff) {
		return true;
	}

	@Override
	public HotelVO getHotelInfo(String hotelAddress) {
		this.hotelName = "F.A.F酒店";
		this.tradeArea = "栖霞区";
		this.starLevel = 4;
		this.mark = (float) 4.6;
		this.city = "南京市";
		this.facilityAndService = "空调、热水";
		this.briefIntroduction = "南京市最好的酒店";
		this.roomTypeAndPrice = new HashMap<>();
		roomTypeAndPrice.put(RoomType.KING_SIZE_ROOM, 150);
		this.roomTypeAndNums = new HashMap<>();
		roomTypeAndNums.put(RoomType.KING_SIZE_ROOM, 30);
		this.comments = new HashMap<>();
		comments.put("原", "这是我住过最舒服的酒店！！！！！");
		
		return new HotelVO(hotelName, tradeArea, hotelAddress, starLevel, mark, city, 100, 500, briefIntroduction, facilityAndService, roomTypeAndPrice, roomTypeAndNums, comments);
	}

}
