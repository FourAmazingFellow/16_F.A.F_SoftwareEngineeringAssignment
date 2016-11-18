package hoteldata;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import data.hoteldata.HotelDAOImpl;
import po.BriefHotelInfoPO;

public class HotelDAOImplTest {

	private HotelDAOImpl hotelDAO;
	private String hotelName;
	private String businessDistrict;
	private String hotelAddress;
	private int starLevel;
	private float mark;
//	private String briefIntroduction;
//	private String facilityAndService;
//	private HashMap<RoomType, Integer> roomTypeAndPrice;
//	private HashMap<RoomType, Integer> roomTypeAndNums;
//	private HashMap<String, String> comments;
	
	@Before
	public void setUp() throws Exception {
		hotelDAO = new HotelDAOImpl();
		this.hotelName = "Jingling Hotel";
		this.businessDistrict = "新街口";
		this.hotelAddress = "江苏省南京市栖霞区仙林大道163号";
		this.starLevel = 5;
		this.mark = 5.0f;
//		this.briefIntroduction = "南京最好的酒店";
//		this.facilityAndService = "wifi;washer;park;air-condition;elevator";
//		HashMap<RoomType, Integer> roomTypeAndPrice = new HashMap<>();
//		roomTypeAndPrice.put(RoomType.SINGLE_ROOM, 100);
//		roomTypeAndPrice.put(RoomType.STANDARD_ROOM, 200);
//		roomTypeAndPrice.put(RoomType.TRIBLE_ROOM, 300);
//		roomTypeAndPrice.put(RoomType.KING_SIZE_ROOM, 400);
//		this.roomTypeAndPrice = roomTypeAndPrice;
//		HashMap<RoomType, Integer> roomTypeAndNums = new HashMap<>();
//		roomTypeAndNums.put(RoomType.SINGLE_ROOM, 40);
//		roomTypeAndNums.put(RoomType.STANDARD_ROOM, 50);
//		roomTypeAndNums.put(RoomType.TRIBLE_ROOM, 50);
//		roomTypeAndNums.put(RoomType.KING_SIZE_ROOM, 50);
//		this.roomTypeAndNums = roomTypeAndNums;
//		HashMap<String, String> comments = new HashMap<>();
//		comments.put("原", "环境一流，服务贴心");
//		this.comments = comments;
	}

	@Test
	public void test() {
		try {
			BriefHotelInfoPO briefHotelInfoPO = hotelDAO.getHotelBriefInfo("江苏省南京市栖霞区仙林大道163号");
			assertEquals("HotelDAOImpl.getHotelBriefInfo(String addtrss) has an error in hotelName!", hotelName, briefHotelInfoPO.getHotelName());
			assertEquals("HotelDAOImpl.getHotelBriefInfo(String addtrss) has an error in businessDistrict!", businessDistrict, briefHotelInfoPO.getBusinessDistrict());
			assertEquals("HotelDAOImpl.getHotelBriefInfo(String addtrss) has an error in hotelAddress!", hotelAddress, briefHotelInfoPO.getHotelAddress());
			assertEquals("HotelDAOImpl.getHotelBriefInfo(String addtrss) has an error in starLevel!", starLevel, briefHotelInfoPO.getStarLevel());
			assertEquals("HotelDAOImpl.getHotelBriefInfo(String addtrss) has an error in mark!", mark, briefHotelInfoPO.getMark(), 0);	
		} catch (RemoteException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}

}
