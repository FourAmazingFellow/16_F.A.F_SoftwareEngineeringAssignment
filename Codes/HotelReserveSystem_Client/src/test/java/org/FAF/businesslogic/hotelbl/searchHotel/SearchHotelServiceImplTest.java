package org.FAF.businesslogic.hotelbl.searchHotel;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import businesslogic.hotelbl.searchHotel.MockSearchHotelServiceImpl;
import businesslogic.hotelbl.searchHotel.SearchHotelServiceImpl;
import vo.BriefHotelInfoVO;

public class SearchHotelServiceImplTest {

	private SearchHotelServiceImpl searchHotel;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetHotelBriefInfoListBySearching() {
		String[] condition = {"不限", "不限", "不限", "不限", "不限", "不限", "不限", "不限", "否"};
		searchHotel = new MockSearchHotelServiceImpl(condition);
		ArrayList<BriefHotelInfoVO> briefHotelInfoVOs = searchHotel.getHotelBriefInfoListBySearching(condition);
		assertEquals(1, briefHotelInfoVOs.size());
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in hotelName!", "Jingling Hotel", briefHotelInfoVOs.get(0).hotelName);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in tradeArea!", "新街口", briefHotelInfoVOs.get(0).tradeArea);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in hotelAddress!", "江苏省南京市栖霞区仙林大道163号", briefHotelInfoVOs.get(0).hotelAddress);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in starLevel!", 5, briefHotelInfoVOs.get(0).starLevel);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in mark!", 5.0f, briefHotelInfoVOs.get(0).mark, 0);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in city!", "南京市", briefHotelInfoVOs.get(0).city);
	}

}
