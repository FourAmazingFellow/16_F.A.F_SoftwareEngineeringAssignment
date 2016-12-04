package org.FAF.businesslogic.hotelbl.checkOrderedHotel;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.hotelbl.checkOrderedHotel.OrderedHotelList;
import po.OrderState;
import rmi.LinkToServer;
import vo.OrderedHotelInfoVO;

public class OrderedHotelListTest {

	private static LinkToServer linkToServer;
	
	private OrderedHotelList orderedHotelList;
	
	@BeforeClass
	public static void set() {
		linkToServer = new LinkToServer();
		linkToServer.linkToServer();
	}
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testEnrollHotelBreifInfoList() {
		this.orderedHotelList = new OrderedHotelList("原");
		ArrayList<OrderedHotelInfoVO> orderedHotelInfoVOs = orderedHotelList.enrollHotelBreifInfoList();
		assertEquals(1, orderedHotelInfoVOs.size());
		assertEquals("Jingling Hotel", orderedHotelInfoVOs.get(0).hotelName);
		assertEquals("栖霞区", orderedHotelInfoVOs.get(0).tradeArea);
		assertEquals("江苏省南京市栖霞区仙林大道163号", orderedHotelInfoVOs.get(0).hotelAddress);
		assertEquals(5, orderedHotelInfoVOs.get(0).starLevel);
		assertEquals(4.8f, orderedHotelInfoVOs.get(0).mark, 0);
		assertEquals(1, orderedHotelInfoVOs.get(0).hotelState.size());
		assertEquals(true, orderedHotelInfoVOs.get(0).hotelState.contains(OrderState.DONE_ORDER));
	}

}
