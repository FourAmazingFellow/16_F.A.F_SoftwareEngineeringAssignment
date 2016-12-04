package org.FAF.businesslogic.orderbl.getOrderDone;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.orderbl.getOrderDone.OrderTerminator;
import po.OrderState;
import po.RoomType;
import rmi.LinkToServer;
import vo.OrderVO;

public class OrderTerminatorTest {
	private static LinkToServer linkToServer;
	
	private OrderTerminator orderTerminator;

	private boolean canGetOrderDone;
	private boolean canDelayCheckIn;
	
	@BeforeClass
	public static void set() {
		linkToServer = new LinkToServer();
		linkToServer.linkToServer();
	}
	
	@Before
	public void setup() {
		orderTerminator = new OrderTerminator();
		
		canGetOrderDone = true;
		canDelayCheckIn = true;
	}

	@Test
	public void getOrderDoneTest_1() {
		@SuppressWarnings("deprecation")
		OrderVO vo = new OrderVO("19970206", "0001000100010001", "汉庭酒店", "江苏省南京市栖霞区仙林大道163号", 
				new Date(116, 11, 20), new Date(116, 11, 21), RoomType.STANDARD_ROOM,
				1, 200, OrderState.NOT_DONE_ORDER, new Date(116, 11, 15, 18, 0), new Date(116, 11, 20, 22, 0), 2, 
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
				new Date(116, 11, 20), new Date(116, 11, 21), RoomType.STANDARD_ROOM,
				1, 200, OrderState.NOT_DONE_ORDER, new Date(116, 11, 15, 18, 0), new Date(116, 11, 20, 22, 0), 2, 
				false, false, false);
		boolean result = orderTerminator.delayCheckIn(vo);
		assertEquals(canDelayCheckIn, result);
	}
}
