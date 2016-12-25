package org.FAF.businesslogic.hotelbl.maintainHotelBasicInfo;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.HashMap;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.hotelbl.maintainHotelBasicInfo.MaintainHotelBasicInfoServiceImpl;
import po.RoomType;
import rmi.LinkToServer;
import vo.HotelVO;

public class MaintainHotelBasicInfoServiceImplTest {
	
	private static LinkToServer linkToServer;

	private MaintainHotelBasicInfoServiceImpl maintainHotelBasicInfo;
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
	HotelVO modified;
	
	
	@BeforeClass
	public static void set() {
		linkToServer = new LinkToServer();
		try {
			linkToServer.linkToServer();
		} catch (RemoteException e) {
			System.out.println("网络连接错误");
		}
	}
	
	@Before
	public void setUp() throws Exception {
		this.hotelName = "Jingling Hotel";
		this.tradeArea = "栖霞区";
		this.hotelAddress = "江苏省南京市栖霞区仙林大道163号";
		this.starLevel = 5;
		this.mark = 5.0f;
		this.city = "南京市";
		this.min_Price = 100;
		this.briefIntroduction = "南京最好的酒店";
		this.facilityAndService = "wifi;washer;park;air-condition;elevator";
		HashMap<RoomType, Integer> roomTypeAndPrice = new HashMap<>();
		roomTypeAndPrice.put(RoomType.SINGLE_ROOM, 100);
		roomTypeAndPrice.put(RoomType.STANDARD_ROOM, 200);
		roomTypeAndPrice.put(RoomType.TRIBLE_ROOM, 300);
		roomTypeAndPrice.put(RoomType.KING_SIZE_ROOM, 500);
		this.roomTypeAndPrice = roomTypeAndPrice;
		HashMap<RoomType, Integer> roomTypeAndNums = new HashMap<>();
		roomTypeAndNums.put(RoomType.SINGLE_ROOM, 50);
		roomTypeAndNums.put(RoomType.STANDARD_ROOM, 50);
		roomTypeAndNums.put(RoomType.TRIBLE_ROOM, 50);
		roomTypeAndNums.put(RoomType.KING_SIZE_ROOM, 52);
		this.roomTypeAndNums = roomTypeAndNums;
		HashMap<String, String> comments = new HashMap<>();
		comments.put("原", "环境一流，服务贴心");
		comments.put("Accident", "不愧是南京市最好的酒店");
		comments.put("Superman", "舒服的我都不想飞走了");
		comments.put("Slow_Time", "隔音效果有点差");
		this.comments = comments;
		modified = new HotelVO(hotelName, tradeArea, hotelAddress, starLevel, mark, city, 100, 500, briefIntroduction, facilityAndService, roomTypeAndPrice, roomTypeAndNums, comments);
		modified.min_Price = min_Price;
	}

	@Test
	public void testEnrollHotelBasicInfo() {
		try {
			maintainHotelBasicInfo = new MaintainHotelBasicInfoServiceImpl();
			HotelVO hotel = maintainHotelBasicInfo.enrollHotelBasicInfo(this.hotelAddress);
			assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in hotelName!", hotelName, hotel.hotelName);
		 	assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in tradeArea!", tradeArea, hotel.tradeArea);
			assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in hotelAddress!", hotelAddress, hotel.hotelAddress);
			assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in starLevel!", starLevel, hotel.starLevel);
			assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in mark!", mark, hotel.mark, 0);
			assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in city!", city, hotel.city);
			assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in min_Price!", min_Price, hotel.min_Price);
			assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in briefIntroduction!", briefIntroduction, hotel.briefIntroduction);
			assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in facilityAndService!", facilityAndService, hotel.facilityAndService);
			assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in roomTypeAndPrice!", roomTypeAndPrice, hotel.roomTypeAndPrice);
			assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in roomTypeAndNums!", roomTypeAndNums, hotel.roomTypeAndNums);
			assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in comments!", comments, hotel.comments);
		} catch (RemoteException e) {
			e.printStackTrace();
			fail();
		}

	}
	
	@Test
	public void testConfirmModify() {
		try {
			maintainHotelBasicInfo = new MaintainHotelBasicInfoServiceImpl();
			boolean result = maintainHotelBasicInfo.confirmModify(modified);
			assertEquals(true, result);
		} catch (RemoteException e) {
			e.printStackTrace();
			fail();
		}
		
	}

}
