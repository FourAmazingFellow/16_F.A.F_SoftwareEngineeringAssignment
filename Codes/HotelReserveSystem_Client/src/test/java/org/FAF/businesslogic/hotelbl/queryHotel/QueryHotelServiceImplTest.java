package org.FAF.businesslogic.hotelbl.queryHotel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import businesslogic.hotelbl.queryHotel.MockQueryHotelServiceImpl;
import businesslogic.hotelbl.queryHotel.QueryHotelServiceImpl;
import po.RoomType;
import vo.HotelVO;
import vo.OrderVO;
import vo.OrderedHotelInfoVO;

public class QueryHotelServiceImplTest {

	private QueryHotelServiceImpl queryHotel;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetHotelBriefInfoListByQuerying() {
		queryHotel = new MockQueryHotelServiceImpl("原");
		String[] conditions  = {"从低到高", "从高到低", "从高到低", "是"};
		ArrayList<OrderedHotelInfoVO> orderedHotelInfoVOs = queryHotel.getHotelBriefInfoListByQuerying(conditions);
		
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetHotelDetails() {
		queryHotel = new MockQueryHotelServiceImpl("原");
		HotelVO hotelDetails = queryHotel.getHotelDetails("江苏省南京市栖霞区仙林大道163号");
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in hotelName!", "Jingling Hotel", hotelDetails.hotelName);
	 	assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in businessDistrict!", "新街口", hotelDetails.businessDistrict);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in hotelAddress!", "江苏省南京市栖霞区仙林大道163号", hotelDetails.hotelAddress);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in starLevel!", 5, hotelDetails.starLevel);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in mark!", 5.0f, hotelDetails.mark, 0);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in briefIntroduction!", "南京市最好的酒店", hotelDetails.briefIntroduction);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in facilityAndService!", "wifi;washer;park;air-condition;elevator", hotelDetails.facilityAndService);
		HashMap<RoomType, Integer> roomTypeAndPrice = new HashMap<>();
		roomTypeAndPrice.put(RoomType.KING_SIZE_ROOM, 1000);
		HashMap<String, String> comments = new HashMap<>();
		comments.put("原", "该酒店服务到位，应有尽有！");
		HashMap<RoomType, Integer> roomTypeAndNums = new HashMap<>();
		roomTypeAndNums.put(RoomType.KING_SIZE_ROOM, 20);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in roomTypeAndPrice!", roomTypeAndPrice, hotelDetails.roomTypeAndPrice);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in roomTypeAndNums!", roomTypeAndNums, hotelDetails.roomTypeAndNums);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in comments!", comments, hotelDetails.comments);	
	}
	
	@Test
	public void testGetOrders() {
		queryHotel = new MockQueryHotelServiceImpl("原");
		ArrayList<OrderVO> orderVOs = queryHotel.getOrders("江苏省南京市栖霞区仙林大道163号", "原");
		
	}

}
