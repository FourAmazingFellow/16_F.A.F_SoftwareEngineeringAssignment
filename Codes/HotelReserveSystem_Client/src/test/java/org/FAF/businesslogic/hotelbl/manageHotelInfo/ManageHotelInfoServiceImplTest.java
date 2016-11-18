package org.FAF.businesslogic.hotelbl.manageHotelInfo;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import businesslogic.hotelbl.manageHotelInfo.ManageHotelInfoServiceImpl;
import businesslogic.userbl.MockUserInfoImpl;
import data_Stub.HotelDAOImpl_Stub;
import dataservice.hotelDAO.HotelDAO;
import po.RoomType;
import po.UserType;
import vo.HotelStaffInfoVO;
import vo.HotelVO;

public class ManageHotelInfoServiceImplTest {

	private ManageHotelInfoServiceImpl manageHotelInfoService;
	private HotelDAO hotelDAO;
	private String hotelName;
	private String businessDistrict;
	private String hotelAddress;
	private int starLevel;
	private float mark;
	private String city;
	private String briefIntroduction;
	private String facilityAndService;
	private HashMap<RoomType, Integer> roomTypeAndPrice;
	private HashMap<RoomType, Integer> roomTypeAndNums;
	private HashMap<String, String> comments;
	HotelVO hotelVO;
	HotelStaffInfoVO hotelStaff;
	
	@Before
	public void setUp() throws Exception {
		this.hotelName = "Jingling Hotel";
		this.businessDistrict = "新街口";
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
		roomTypeAndNums.put(RoomType.SINGLE_ROOM, 40);
		roomTypeAndNums.put(RoomType.STANDARD_ROOM, 50);
		roomTypeAndNums.put(RoomType.TRIBLE_ROOM, 50);
		roomTypeAndNums.put(RoomType.KING_SIZE_ROOM, 50);
		this.roomTypeAndNums = roomTypeAndNums;
		HashMap<String, String> comments = new HashMap<>();
		comments.put("原", "环境一流，服务贴心");
		this.comments = comments;
		hotelDAO = new HotelDAOImpl_Stub(hotelName, businessDistrict, hotelAddress, starLevel, mark, city,  briefIntroduction, facilityAndService, this.roomTypeAndPrice, this.roomTypeAndNums, this.comments);
		hotelVO = new HotelVO(hotelName, businessDistrict, hotelAddress, starLevel, mark, city, briefIntroduction, facilityAndService, roomTypeAndPrice, roomTypeAndNums, comments);
		this.hotelStaff = new HotelStaffInfoVO("Accident", "123456789", "13655255834", UserType.HotelStaff, "江苏省南京市栖霞区仙林大道163号");
	}

	@Test
	public void testAddHotel() {
		manageHotelInfoService = new ManageHotelInfoServiceImpl();
		manageHotelInfoService.setHotelDAO(hotelDAO);
		boolean result = manageHotelInfoService.addHotel(hotelVO);
		assertEquals(true, result);
	}
	
	@Test
	public void testAddHotelStaff() {
		manageHotelInfoService = new ManageHotelInfoServiceImpl();
		manageHotelInfoService.setUserService(new MockUserInfoImpl());
		boolean result = manageHotelInfoService.addHotelStaff(hotelStaff);
		assertEquals(true, result);
	}

}
