package org.FAF.businesslogic.hotelbl.queryHotel;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import businesslogic.hotelbl.queryHotel.MockQueryHotelList;
import businesslogic.hotelbl.queryHotel.QueryHotelList;
import po.BriefHotelInfoPO;
import po.BriefOrderInfoPO;
import po.OrderState;
import po.RoomType;

public class QueryHotelListTest {

	private QueryHotelList queryHotelList;
	private ArrayList<BriefOrderInfoPO> orderedHotelList;
	
	@Before
	public void setUp() throws Exception {
		orderedHotelList = new ArrayList<>();
		
		@SuppressWarnings("deprecation")
		BriefOrderInfoPO briefOrderInfoPO = new BriefOrderInfoPO("19970206", "0001000100010001", "汉庭酒店", "江苏省南京市栖霞区仙林大道163号", new Date(2016, 12, 20), new Date(2016, 12, 21), RoomType.STANDARD_ROOM,
				1, 200, OrderState.NOT_DONE_ORDER);
		orderedHotelList.add(briefOrderInfoPO);
	}

	@Test
	public void testGetHotelBriefInfoListByQuerying() {
		queryHotelList = new MockQueryHotelList();
		String[] conditions  = {"从低到高", "从高到低", "从高到低", "是"};
		ArrayList<BriefHotelInfoPO> hotelInfoPOs = queryHotelList.getHotelBriefInfoListByQuerying(conditions, orderedHotelList);
		assertEquals(1, hotelInfoPOs.size());
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in hotelName!", "汉庭酒店", hotelInfoPOs.get(0).getHotelName());
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in businessDistrict!", "新街口", hotelInfoPOs.get(0).getBusinessDistrict());
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in hotelAddress!", "江苏省南京市栖霞区仙林大道163号", hotelInfoPOs.get(0).getHotelAddress());
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in starLevel!", 5, hotelInfoPOs.get(0).getStarLevel());
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in mark!", 5.0f, hotelInfoPOs.get(0).getMark(), 0);
	}

}
