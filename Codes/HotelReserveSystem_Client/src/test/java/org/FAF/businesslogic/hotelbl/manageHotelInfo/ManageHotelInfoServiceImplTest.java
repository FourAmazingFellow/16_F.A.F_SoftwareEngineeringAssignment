package org.FAF.businesslogic.hotelbl.manageHotelInfo;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.hotelbl.manageHotelInfo.ManageHotelInfoServiceImpl;
import businesslogic.userbl.MockUserInfoImpl;
import data_Stub.HotelDAOImpl_Stub;
import dataservice.hotelDAO.HotelDAO;
import po.RoomType;
import po.UserType;
import rmi.LinkToServer;
import vo.HotelStaffInfoVO;
import vo.HotelVO;

public class ManageHotelInfoServiceImplTest {

	private static LinkToServer linkToServer;
	
	private ManageHotelInfoServiceImpl manageHotelInfoService;
	private String hotelName;
	private String tradeArea;
	private String hotelAddress;
	private int starLevel;
	private float mark;
	private String city;
	private int min_Price;
	private String briefIntroduction;
	private String facilityAndService;
	private HashMap<RoomType, Integer> roomTypeAndPrice;
	private HashMap<RoomType, Integer> roomTypeAndNums;
	private HashMap<String, String> comments;
	HotelVO hotelVO;
	HotelStaffInfoVO hotelStaff;
	
	

	@BeforeClass
	public static void set() {
		linkToServer = new LinkToServer();
		linkToServer.linkToServer();
	}
	
	@Before
	public void setUp() throws Exception {
		this.hotelName = "南京中公汇悦酒店";
		this.tradeArea = "栖霞区";
		this.hotelAddress = "仙林大学城元化路8号(南大科学园东门)";
		this.starLevel = 4;
		this.mark = 4.6f;
		this.city = "南京市";
		this.min_Price = 395;
		this.briefIntroduction = "非常好";
		this.facilityAndService = "wifi;washer;park;air-condition;elevator;restaurant";
		HashMap<RoomType, Integer> roomTypeAndPrice = new HashMap<>();
		roomTypeAndPrice.put(RoomType.SINGLE_ROOM, 395);
		roomTypeAndPrice.put(RoomType.STANDARD_ROOM, 595);
		roomTypeAndPrice.put(RoomType.TRIBLE_ROOM, 695);
		roomTypeAndPrice.put(RoomType.KING_SIZE_ROOM, 899);
		this.roomTypeAndPrice = roomTypeAndPrice;
		HashMap<RoomType, Integer> roomTypeAndNums = new HashMap<>();
		roomTypeAndNums.put(RoomType.SINGLE_ROOM, 60);
		roomTypeAndNums.put(RoomType.STANDARD_ROOM, 50);
		roomTypeAndNums.put(RoomType.TRIBLE_ROOM, 50);
		roomTypeAndNums.put(RoomType.KING_SIZE_ROOM, 30);
		this.roomTypeAndNums = roomTypeAndNums;
		HashMap<String, String> comments = new HashMap<>();
		comments.put("原", "环境一流，服务贴心");
		this.comments = comments;
		hotelVO = new HotelVO(hotelName, tradeArea, hotelAddress, starLevel, mark, city, briefIntroduction, facilityAndService, roomTypeAndPrice, roomTypeAndNums, comments);
		hotelVO.min_Price = min_Price;
		this.hotelStaff = new HotelStaffInfoVO("Accident", "123456789", "13655255834", UserType.HotelStaff, "江苏省南京市栖霞区仙林大道163号");
	}

	@Test
	public void testAddHotel() {
		manageHotelInfoService = new ManageHotelInfoServiceImpl();
		boolean result = manageHotelInfoService.addHotel(hotelVO);
		assertEquals(true, result);
	}
	
//	@Test
//	public void testAddHotelStaff() {
//		manageHotelInfoService = new ManageHotelInfoServiceImpl();
//		manageHotelInfoService.setUserService(new MockUserInfoImpl());
//		boolean result = manageHotelInfoService.addHotelStaff(hotelStaff);
//		assertEquals(true, result);
//	}

}
