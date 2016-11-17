package org.FAF.businesslogic.hotelbl.maintainHotelBasicInfo;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import businesslogic.hotelbl.maintainHotelBasicInfo.MaintainHotelBasicInfoServiceImpl;
import data_Stub.HotelDAOImpl_Stub;
import dataservice.hotelDAO.HotelDAO;
import po.RoomType;
import vo.HotelVO;

public class MaintainHotelBasicInfoServiceImplTest {

	private MaintainHotelBasicInfoServiceImpl maintainHotelBasicInfo;
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
	HotelVO modified;
	
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
		modified = new HotelVO(hotelName, businessDistrict, hotelAddress, starLevel, mark, briefIntroduction, facilityAndService, roomTypeAndPrice, roomTypeAndNums, comments);
	}

	@Test
	public void testEnrollHotelBasicInfo() {
		maintainHotelBasicInfo = new MaintainHotelBasicInfoServiceImpl(this.hotelAddress);
		maintainHotelBasicInfo.setHotelDAO(this.hotelDAO);
		HotelVO hotel = maintainHotelBasicInfo.enrollHotelBasicInfo(this.hotelAddress);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in hotelName!", hotelName, hotel.hotelName);
	 	assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in businessDistrict!", businessDistrict, hotel.businessDistrict);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in hotelAddress!", hotelAddress, hotel.hotelAddress);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in starLevel!", starLevel, hotel.starLevel);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in mark!", mark, hotel.mark, 0);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in briefIntroduction!", briefIntroduction, hotel.briefIntroduction);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in facilityAndService!", facilityAndService, hotel.facilityAndService);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in roomTypeAndPrice!", roomTypeAndPrice, hotel.roomTypeAndPrice);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in roomTypeAndNums!", roomTypeAndNums, hotel.roomTypeAndNums);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in comments!", comments, hotel.comments);
	}
	
	@Test
	public void testConfirmModify() {
		maintainHotelBasicInfo = new MaintainHotelBasicInfoServiceImpl(this.hotelAddress);
		maintainHotelBasicInfo.setHotelDAO(this.hotelDAO);
		boolean result = maintainHotelBasicInfo.confirmModify(modified);
		assertEquals(true, result);
	}

}
