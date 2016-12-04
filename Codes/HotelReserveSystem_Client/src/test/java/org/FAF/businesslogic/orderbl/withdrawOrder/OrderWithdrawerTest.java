package org.FAF.businesslogic.orderbl.withdrawOrder;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.orderbl.withdrawOrder.OrderWithdrawer;
import po.OrderState;
import po.RoomType;
import rmi.LinkToServer;
import vo.OrderVO;

public class OrderWithdrawerTest {
	private static LinkToServer linkToServer;
	
	private OrderWithdrawer orderWithdrawer;
	
	private boolean withdrawResult;
	
	@BeforeClass
	public static void set() {
		linkToServer = new LinkToServer();
		linkToServer.linkToServer();
	}
	
	@Before
	public void setup() {
		orderWithdrawer = new OrderWithdrawer();
		
		withdrawResult = true;
	}
	
	@Test
	public void withdrawOrderTest_1(){
		@SuppressWarnings("deprecation")
		OrderVO vo = new OrderVO("19970206", "0001000100010001", "汉庭酒店", "江苏省南京市栖霞区仙林大道163号", 
				new Date(116, 11, 20), new Date(116, 11, 21), RoomType.STANDARD_ROOM,
				1, 200, OrderState.NOT_DONE_ORDER, new Date(116, 11, 15, 18, 0), new Date(116, 11, 20, 22, 0), 2, 
				false, false, false);
		
		boolean result = orderWithdrawer.withdrawOrder(vo, false);
		assertEquals(withdrawResult, result);
	}
}
