package hoteldata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import data.hoteldata.HotelDAOImpl;
import po.BriefHotelInfoPO;
import po.BriefOrderInfoPO;
import po.BusinessDistrictPO;
import po.HotelPO;
import po.RoomType;

public class HotelDAOImplTest {

	private HotelDAOImpl hotelDAO;
	private String hotelName;
	private String tradeArea;
	private String hotelAddress;
	private int starLevel;
	private float mark;
	private String city;
	private String briefIntroduction;
	private String facilityAndService;
	private HashMap<RoomType, Integer> roomTypeAndPrice;
	private HashMap<RoomType, Integer> roomTypeAndNums;
	private HashMap<String, String> comments;
	private HotelPO po;
	private HotelPO updatePO;
	
	@Before
	public void setUp() throws Exception {
		hotelDAO = new HotelDAOImpl();
		this.hotelName = "Jingling Hotel";
		this.tradeArea = "栖霞区";
		this.hotelAddress = "江苏省南京市栖霞区仙林大道163号";
		this.starLevel = 5;
		this.mark = 5.0f;
		this.city = "南京市";
		this.briefIntroduction = "南京最好的酒店";
		this.facilityAndService = "wifi;washer;park;air-condition;elevator";
		HashMap<RoomType, Integer> roomTypeAndPrice = new HashMap<>();
		roomTypeAndPrice.put(RoomType.SINGLE_ROOM, 100);
		roomTypeAndPrice.put(RoomType.STANDARD_ROOM, 200);
		roomTypeAndPrice.put(RoomType.TRIBLE_ROOM, 300);
		roomTypeAndPrice.put(RoomType.KING_SIZE_ROOM, 400);
		this.roomTypeAndPrice = roomTypeAndPrice;
		HashMap<RoomType, Integer> roomTypeAndNums = new HashMap<>();
		roomTypeAndNums.put(RoomType.SINGLE_ROOM, 50);
		roomTypeAndNums.put(RoomType.STANDARD_ROOM, 50);
		roomTypeAndNums.put(RoomType.TRIBLE_ROOM, 50);
		roomTypeAndNums.put(RoomType.KING_SIZE_ROOM, 50);
		this.roomTypeAndNums = roomTypeAndNums;
		HashMap<String, String> comments = new HashMap<>();
		comments.put("原", "环境一流，服务贴心");
		this.comments = comments;
		po = new HotelPO("锦江之星", "松江区", "上海松江区九亭涞坊路1000号", 0000000000000003, 0000000000000003.5f, "上海市", "中规中矩", facilityAndService, roomTypeAndPrice, roomTypeAndNums, comments);
		po.setMin_Price(100);
		comments.put("Accident", "不愧是南京市最好的酒店");
		comments.put("Superman", "舒服的我都不想飞走了");
		comments.put("Slow_Time", "隔音效果有点差");
		updatePO = new HotelPO(hotelName, tradeArea, hotelAddress, starLevel, 5.0f, city, briefIntroduction, facilityAndService, roomTypeAndPrice, roomTypeAndNums, comments);
	}

	@Test
	public void testGetHotelBriefInfo() {
		try {
			BriefHotelInfoPO briefHotelInfoPO = hotelDAO.getHotelBriefInfo(this.hotelAddress);
			assertEquals("HotelDAOImpl.getHotelBriefInfo(String addtrss) has an error in hotelName!", hotelName, briefHotelInfoPO.getHotelName());
			assertEquals("HotelDAOImpl.getHotelBriefInfo(String addtrss) has an error in tradeArea!", tradeArea, briefHotelInfoPO.getTradeArea());
			assertEquals("HotelDAOImpl.getHotelBriefInfo(String addtrss) has an error in hotelAddress!", hotelAddress, briefHotelInfoPO.getHotelAddress());
			assertEquals("HotelDAOImpl.getHotelBriefInfo(String addtrss) has an error in starLevel!", starLevel, briefHotelInfoPO.getStarLevel());
			assertEquals("HotelDAOImpl.getHotelBriefInfo(String addtrss) has an error in mark!", mark, briefHotelInfoPO.getMark(), 0);	
			assertEquals("HotelDAOImpl.getHotelBriefInfo(String addtrss) has an error in city!", city, briefHotelInfoPO.getCity());
		} catch (RemoteException e) {
			e.printStackTrace();
			fail("RemoteException has happened!");
		}
	}
	
	@Test
	public void testGetHotelDetails() {
		try {
			HotelPO hotelDetails = hotelDAO.getHotelDetails(this.hotelAddress);
			assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in hotelName!", hotelName, hotelDetails.getHotelName());
		 	assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in tradeArea!", tradeArea, hotelDetails.getTradeArea());
			assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in hotelAddress!", hotelAddress, hotelDetails.getHotelAddress());
			assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in starLevel!", starLevel, hotelDetails.getStarLevel());
			assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in mark!", mark, hotelDetails.getMark(), 0);
			assertEquals("HotelDAOImpl.getHotelBriefInfo(String addtrss) has an error in city!", city, hotelDetails.getCity());
			assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in briefIntroduction!", briefIntroduction, hotelDetails.getBriefIntroduction());
			assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in facilityAndService!", facilityAndService, hotelDetails.getFacilityAndService());
			assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in roomTypeAndPrice!", roomTypeAndPrice, hotelDetails.getRoomTypeAndPrice());
			assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in roomTypeAndNums!", roomTypeAndNums, hotelDetails.getRoomTypeAndNums());
			assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in comments!", comments, hotelDetails.getComments());
		} catch(RemoteException e) {
			e.printStackTrace();
			fail("RemoteException has happened!");
		}
	}
	
//	@Test
//	public void testInsert() {
//		try {
//			hotelDAO.insertHotel(po);
//		} catch(RemoteException e) {
//			e.printStackTrace();
//			fail("RemoteException has happened!");
//		}
//	}
//	
//	@Test
//	public void testUpdate() {
//		try {
//			hotelDAO.updateHotel(updatePO);
//		} catch(RemoteException e) {
//			e.printStackTrace();
//			fail("RemoteException has happened!");
//		}
//	}
//	
//	@Test
//	public void testGetHotelBriefInfoListByQuerying() {
//		String condition[] = {"南京市", "栖霞区", "mark desc", "0"};
//		ArrayList<BriefOrderInfoPO> orderedHotelList = new ArrayList<>();
//		try {
//			ArrayList<BriefHotelInfoPO> briefHotelInfoPOs = hotelDAO.getHotelBriefInfoListByQuerying(condition, orderedHotelList);
//			assertEquals(0000000000000003, briefHotelInfoPOs.size());
//			assertEquals("格林豪泰", briefHotelInfoPOs.get(0).getHotelName());
//			assertEquals("汉庭酒店", briefHotelInfoPOs.get(1).getHotelName());
//			assertEquals("如家酒店", briefHotelInfoPOs.get(2).getHotelName());
//		} catch (RemoteException e) {
//			e.printStackTrace();
//			fail("RemoteException has happened!");
//		}
//	}
	
	@Test
	public void testGetBusinessDistrctList() {
		ArrayList<BusinessDistrictPO> businessDistrictPOs;
		try {
			businessDistrictPOs = hotelDAO.getBusinessDistrictList("南京市");
			assertEquals(11, businessDistrictPOs.size());
			assertEquals("栖霞区", businessDistrictPOs.get(0).getBusinessDistrictName());
		} catch (RemoteException e) {
			e.printStackTrace();
			fail("RemoteException has happened!");
		}
	}

}
