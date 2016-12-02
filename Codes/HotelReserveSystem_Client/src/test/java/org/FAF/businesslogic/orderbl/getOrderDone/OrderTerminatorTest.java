package org.FAF.businesslogic.orderbl.getOrderDone;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import businesslogic.orderbl.getOrderDone.OrderTerminator;
import businesslogic.userbl.ClientCreditInfo;
import businesslogic.userbl.MockClientCreditInfoImpl;
import data_Stub.OrderDAOImpl_Stub;
import dataservice.orderDAO.OrderDAO;
import po.OrderState;
import po.RoomType;
import vo.OrderVO;

public class OrderTerminatorTest {
	private OrderTerminator orderTerminator;
	private OrderDAO mockOrderDaoService;
	private ClientCreditInfo mockUserCreditService;

	private boolean canGetOrderDone;
	private boolean canDelayCheckIn;
	
	@SuppressWarnings("deprecation")
	@Before
	public void setup() {
		mockOrderDaoService = new OrderDAOImpl_Stub("19970206", "0001000100010001", "汉庭酒店", "江苏省南京市栖霞区仙林大道163号", 
				new Date(2016, 12, 20), new Date(2016, 12, 21), RoomType.STANDARD_ROOM,
				1, 200, OrderState.NOT_DONE_ORDER, new Date(2016, 12, 15, 18, 0), new Date(2016, 12, 20, 22, 0), 2, 
				false, false, false, false);
		mockUserCreditService = new MockClientCreditInfoImpl();
		orderTerminator = new OrderTerminator();
		orderTerminator.set(mockOrderDaoService, mockUserCreditService);
		
		canGetOrderDone = true;
		canDelayCheckIn = true;
	}

	@Test
	public void getOrderDoneTest_1() {
		@SuppressWarnings("deprecation")
		OrderVO vo = new OrderVO("19970206", "0001000100010001", "汉庭酒店", "江苏省南京市栖霞区仙林大道163号", 
				new Date(2016, 12, 20), new Date(2016, 12, 21), RoomType.STANDARD_ROOM,
				1, 200, OrderState.NOT_DONE_ORDER, new Date(2016, 12, 15, 18, 0), new Date(2016, 12, 20, 22, 0), 2, 
				false, false, false);
		boolean result = orderTerminator.getOrderDone(vo);
		assertEquals(canGetOrderDone, result);
	}
	
	//空指针测试
	@Test
	public void getOrderDoneTest_2() {
		OrderVO vo = null;
		boolean result = orderTerminator.getOrderDone(vo);
		assertEquals(false, result);
	}
	@Test
	public void delayCheckInTest_1(){
		@SuppressWarnings("deprecation")
		OrderVO vo = new OrderVO("19970206", "0001000100010001", "汉庭酒店", "江苏省南京市栖霞区仙林大道163号", 
				new Date(2016, 12, 20), new Date(2016, 12, 21), RoomType.STANDARD_ROOM,
				1, 200, OrderState.NOT_DONE_ORDER, new Date(2016, 12, 15, 18, 0), new Date(2016, 12, 20, 22, 0), 2, 
				false, false, false);
		boolean result = orderTerminator.delayCheckIn(vo);
		assertEquals(canDelayCheckIn, result);
	}
}
