package org.FAF.businesslogic.hotelbl.searchHotel;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.hotelbl.searchHotel.SearchHotelServiceImpl;
import rmi.LinkToServer;
import vo.OrderedHotelInfoVO;

public class SearchHotelServiceImplTest {

	private SearchHotelServiceImpl searchHotel;
	
	private static LinkToServer linkToServer;
	
	@BeforeClass
	public static void set() {
		linkToServer = new LinkToServer();
		try {
			linkToServer.linkToServer();
		} catch (RemoteException e) {
			System.out.println("网络通信错误");
		}
	}
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetHotelBriefInfoListBySearching() {
		String[] condition = {"南京市", "栖霞区", "", "0", "394", "3", "6", "4.9", "5.0", "0", "1", "1", "2016-12-06", "2016-12-07"};
		try {
			searchHotel = new SearchHotelServiceImpl("原");
			ArrayList<OrderedHotelInfoVO> briefHotelInfoVOs = searchHotel.getHotelBriefInfoListBySearching(condition);
			assertEquals(1, briefHotelInfoVOs.size());
			assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in hotelName!", "Jingling Hotel", briefHotelInfoVOs.get(0).hotelName);
			assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in tradeArea!", "栖霞区", briefHotelInfoVOs.get(0).tradeArea);
			assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in hotelAddress!", "江苏省南京市栖霞区仙林大道163号", briefHotelInfoVOs.get(0).hotelAddress);
			assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in starLevel!", 5, briefHotelInfoVOs.get(0).starLevel);
			assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in mark!", 5.0f, briefHotelInfoVOs.get(0).mark, 0);
		} catch (RemoteException e) {
			e.printStackTrace();
			fail();
		}
		
	}

}
