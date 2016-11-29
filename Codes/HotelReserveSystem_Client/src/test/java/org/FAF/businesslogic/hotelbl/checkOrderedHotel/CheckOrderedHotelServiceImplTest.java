package org.FAF.businesslogic.hotelbl.checkOrderedHotel;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import businesslogic.hotelbl.checkOrderedHotel.CheckOrderedHotelServiceImpl;
import po.OrderState;
import vo.OrderedHotelInfoVO;

public class CheckOrderedHotelServiceImplTest {

	private CheckOrderedHotelServiceImpl checkOrderedHotel;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testEnrollHotelBreifInfoList1() {
		checkOrderedHotel = new CheckOrderedHotelServiceImpl();
		ArrayList<OrderedHotelInfoVO> orderedHotelInfoVOs = checkOrderedHotel.enrollHotelBreifInfoList("原");
		assertEquals(1, orderedHotelInfoVOs.size());
		assertEquals("Jingling Hotel", orderedHotelInfoVOs.get(0).hotelName);
		assertEquals("新街口", orderedHotelInfoVOs.get(0).tradeArea);
		assertEquals("江苏省南京市栖霞区仙林大道163号", orderedHotelInfoVOs.get(0).hotelAddress);
		assertEquals(5, orderedHotelInfoVOs.get(0).starLevel);
		assertEquals(5.0f, orderedHotelInfoVOs.get(0).mark, 0);
		assertEquals(1, orderedHotelInfoVOs.get(0).hotelState.size());
		assertEquals(true, orderedHotelInfoVOs.get(0).hotelState.contains(OrderState.DONE_ORDER));
	}
	
//	@Test
//	public void testEnrollHotelBreifInfoList2() {
//		checkOrderedHotel = new CheckOrderedHotelServiceImpl();
//		ArrayList<OrderedHotelInfoVO> orderedHotelInfoVOs = checkOrderedHotel.enrollHotelBreifInfoList("Accident");
//		assertEquals(null, orderedHotelInfoVOs);
//	}

}
