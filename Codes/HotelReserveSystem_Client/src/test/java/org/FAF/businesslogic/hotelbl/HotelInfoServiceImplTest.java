package org.FAF.businesslogic.hotelbl;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import businesslogic.hotelbl.HotelInfoServiceImpl;
import data_Stub.HotelDAOImpl_Stub;
import dataservice.hotelDAO.HotelDAO;
import po.RoomType;
import vo.BriefHotelInfoVO;
import vo.HotelVO;

public class HotelInfoServiceImplTest {

	private HotelDAO hotelDAO;
	private String hotelName;
	private String businessDistrict;
	private String hotelAddress;
	private int starLevel;
	private float mark;
	private String briefIntroduction;
	private String facilityAndService;
	private HashMap<RoomType, Integer> roomTypeAndPrice;
	private HashMap<RoomType, Integer> roomTypeAndNums;
	private HashMap<String, String> comments;
	private HotelInfoServiceImpl hotelInfo;
	
	@Before
	public void setUp() throws Exception {
		this.hotelName = "Jingling Hotel";
		this.businessDistrict = "新街口";
		this.hotelAddress = "江苏省南京市栖霞区仙林大道163号";
		this.starLevel = 5;
		this.mark = 5.0f;
		this.briefIntroduction = "南京最好的酒店";
		this.facilityAndService = "wifi;washer;park;air-condition;elevator";
		HashMap<RoomType, Integer> roomTypeAndPrice = new HashMap<>();
		roomTypeAndPrice.put(RoomType.SINGLE_ROOM, 100);
		roomTypeAndPrice.put(RoomType.STANDARD_ROOM, 200);
		roomTypeAndPrice.put(RoomType.TRIBLE_ROOM, 300);
		roomTypeAndPrice.put(RoomType.KING_SIZE_ROOM, 400);
		this.roomTypeAndPrice = roomTypeAndPrice;
		HashMap<RoomType, Integer> roomTypeAndNums = new HashMap<>();
		roomTypeAndNums.put(RoomType.SINGLE_ROOM, 40);
		roomTypeAndNums.put(RoomType.STANDARD_ROOM, 50);
		roomTypeAndNums.put(RoomType.TRIBLE_ROOM, 50);
		roomTypeAndNums.put(RoomType.KING_SIZE_ROOM, 50);
		this.roomTypeAndNums = roomTypeAndNums;
		HashMap<String, String> comments = new HashMap<>();
		comments.put("原", "环境一流，服务贴心");
		this.comments = comments;
		hotelDAO = new HotelDAOImpl_Stub(hotelName, businessDistrict, hotelAddress, starLevel, mark, briefIntroduction, facilityAndService, this.roomTypeAndPrice, this.roomTypeAndNums, this.comments);
	}

	@Test
	public void testGetHotelBriefInfo1() {
		hotelInfo = new HotelInfoServiceImpl();
		hotelInfo.setHotelDAO(hotelDAO);
		BriefHotelInfoVO briefHotelInfo = hotelInfo.getHotelBriefInfo("江苏省南京市栖霞区仙林大道163号");
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in hotelName!", hotelName, briefHotelInfo.hotelName);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in businessDistrict!", businessDistrict, briefHotelInfo.businessDistrict);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in hotelAddress!", hotelAddress, briefHotelInfo.hotelAddress);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in starLevel!", starLevel, briefHotelInfo.starLevel);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in mark!", mark, briefHotelInfo.mark, 0);				
	}
	
	@Test
	public void testGetHotelBriefInfo2() {
		hotelInfo = new HotelInfoServiceImpl();
		hotelInfo.setHotelDAO(hotelDAO);
		BriefHotelInfoVO briefHotelInfo = hotelInfo.getHotelBriefInfo("江苏省南京市栖霞区仙林大道166号");
		assertNull(briefHotelInfo);				
	}
	
	@Test
	public void testGetHotelDetails1() {
		hotelInfo = new HotelInfoServiceImpl();
		hotelInfo.setHotelDAO(hotelDAO);
		HotelVO hotelDetails = hotelInfo.getHotelDetails("江苏省南京市栖霞区仙林大道163号");
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in hotelName!", hotelName, hotelDetails.hotelName);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in businessDistrict!", businessDistrict, hotelDetails.businessDistrict);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in hotelAddress!", hotelAddress, hotelDetails.hotelAddress);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in starLevel!", starLevel, hotelDetails.starLevel);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in mark!", mark, hotelDetails.mark, 0);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in briefIntroduction!", briefIntroduction, hotelDetails.briefIntroduction);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in facilityAndService!", facilityAndService, hotelDetails.facilityAndService);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in roomTypeAndPrice!", roomTypeAndPrice, hotelDetails.roomTypeAndPrice);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in roomTypeAndNums!", roomTypeAndNums, hotelDetails.roomTypeAndNums);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in comments!", comments, hotelDetails.comments);
	}
	
	@Test
	public void testGetHotelDetails2() {
		hotelInfo = new HotelInfoServiceImpl();
		hotelInfo.setHotelDAO(hotelDAO);
		HotelVO hotelDetails = hotelInfo.getHotelDetails("江苏省南京市栖霞区仙林大道166号");
		assertNull(hotelDetails);
	}
	

}
