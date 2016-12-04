package org.FAF.businesslogic.hotelbl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.hotelbl.HotelInfoServiceImpl;
import po.BusinessDistrictPO;
import po.RoomType;
import rmi.LinkToServer;
import vo.BriefHotelInfoVO;
import vo.HotelVO;

public class HotelInfoServiceImplTest {

	private static LinkToServer linkToServer;
	
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
	
	private HotelInfoServiceImpl hotelInfo;
	public Date orderProducedTime;
	public Date lastedOrderDoneTime;
	public int numOfPerson;
	public boolean isChildren;
	public boolean isOnSale;
	public boolean isCommented;
	
	
	@BeforeClass
	public static void set() {
		linkToServer = new LinkToServer();
		linkToServer.linkToServer();
	}
	
	@Before
	public void setUp() throws Exception {
		this.hotelName = "Jingling Hotel";
		this.tradeArea = "栖霞区";
		this.hotelAddress = "江苏省南京市栖霞区仙林大道163号";
		this.starLevel = 5;
		this.mark = 4.8f;
		this.city = "南京市";
		this.min_Price = 100;
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
		comments.put("Accident", "不愧是南京市最好的酒店");
		comments.put("Superman", "舒服的我都不想飞走了");
		comments.put("Slow_Time", "隔音效果有点差");
		this.comments = comments;
	}

	@Test
	public void testGetHotelBriefInfo1() {
		hotelInfo = new HotelInfoServiceImpl();
//		hotelInfo.setHotelDAO(hotelDAO);
		BriefHotelInfoVO briefHotelInfo = hotelInfo.getHotelBriefInfo("江苏省南京市栖霞区仙林大道163号");
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in hotelName!", hotelName, briefHotelInfo.hotelName);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in tradeArea!", tradeArea, briefHotelInfo.tradeArea);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in hotelAddress!", hotelAddress, briefHotelInfo.hotelAddress);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in starLevel!", starLevel, briefHotelInfo.starLevel);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in mark!", mark, briefHotelInfo.mark, 0);	
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in city!", city, briefHotelInfo.city);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in min_Price!", min_Price, briefHotelInfo.min_Price);
	}
	
	@Test
	public void testGetHotelBriefInfo2() {
		hotelInfo = new HotelInfoServiceImpl();
//		hotelInfo.setHotelDAO(hotelDAO);
		BriefHotelInfoVO briefHotelInfo = hotelInfo.getHotelBriefInfo("江苏省南京市栖霞区仙林大道169号");
		assertNull(briefHotelInfo);				
	}
	
	@Test
	public void testGetHotelDetails1() {
		hotelInfo = new HotelInfoServiceImpl();
//		hotelInfo.setHotelDAO(hotelDAO);
		HotelVO hotelDetails = hotelInfo.getHotelDetails("江苏省南京市栖霞区仙林大道163号");
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in hotelName!", hotelName, hotelDetails.hotelName);
	 	assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in tradeArea!", tradeArea, hotelDetails.tradeArea);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in hotelAddress!", hotelAddress, hotelDetails.hotelAddress);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in starLevel!", starLevel, hotelDetails.starLevel);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in mark!", mark, hotelDetails.mark, 0);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in city!", city, hotelDetails.city);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in min_Price!", min_Price, hotelDetails.min_Price);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in briefIntroduction!", briefIntroduction, hotelDetails.briefIntroduction);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in facilityAndService!", facilityAndService, hotelDetails.facilityAndService);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in roomTypeAndPrice!", roomTypeAndPrice, hotelDetails.roomTypeAndPrice);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in roomTypeAndNums!", roomTypeAndNums, hotelDetails.roomTypeAndNums);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in comments!", comments, hotelDetails.comments);
	}
	
	@Test
	public void testGetHotelDetails2() {
		hotelInfo = new HotelInfoServiceImpl();
//		hotelInfo.setHotelDAO(hotelDAO);
		HotelVO hotelDetails = hotelInfo.getHotelDetails("江苏省南京市栖霞区仙林大道168号");
		assertNull(hotelDetails);
	}
	
	@Test
	public void testGetBusinessDistrctList() {
		hotelInfo = new HotelInfoServiceImpl();
		ArrayList<BusinessDistrictPO> businessDistrictPOs = hotelInfo.getBusinessDistrictList("上海市");
		assertEquals(18, businessDistrictPOs.size());
	}
	

}
