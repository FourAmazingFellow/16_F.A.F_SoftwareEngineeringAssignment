package org.FAF.businesslogic.hotelbl.queryHotel;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.hotelbl.queryHotel.QueryHotelList;
import po.BriefHotelInfoPO;
import po.BriefOrderInfoPO;
import po.OrderState;
import po.RoomType;
import rmi.LinkToServer;

public class QueryHotelListTest {

	private static LinkToServer linkToServer;
	
	private QueryHotelList queryHotelList;
	private ArrayList<BriefOrderInfoPO> orderedHotelList;
	
	
	@BeforeClass
	public static void set() {
		linkToServer = new LinkToServer();
		linkToServer.linkToServer();
	}
	
	@Before
	public void setUp() throws Exception {
		orderedHotelList = new ArrayList<>();
		
		@SuppressWarnings("deprecation")
		BriefOrderInfoPO briefOrderInfoPO = new BriefOrderInfoPO("原", "0000000000000003", "汉庭酒店", "江苏省南京市栖霞区仙林大道163号", new Date(2016, 12, 20), new Date(2016, 12, 21), RoomType.STANDARD_ROOM,
				1, 200, OrderState.NOT_DONE_ORDER);
		orderedHotelList.add(briefOrderInfoPO);
	}

	@Test
	public void testGetHotelBriefInfoListByQuerying() {
		queryHotelList = new QueryHotelList();
		String[] conditions  = {"南京市", "栖霞区", "starLevel", "0"};
		ArrayList<BriefHotelInfoPO> hotelInfoPOs = queryHotelList.getHotelBriefInfoListByQuerying(conditions, orderedHotelList);
		assertEquals(5, hotelInfoPOs.size());
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in hotelName!", "如家酒店", hotelInfoPOs.get(0).getHotelName());
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in tradeArea!", "栖霞区", hotelInfoPOs.get(0).getTradeArea());
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in hotelAddress!", "江苏省南京市栖霞区仙林大道165号", hotelInfoPOs.get(0).getHotelAddress());
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in starLevel!", 0000000000000003, hotelInfoPOs.get(0).getStarLevel());
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in mark!", 0000000000000003.8f, hotelInfoPOs.get(0).getMark(), 0);
	}

}
