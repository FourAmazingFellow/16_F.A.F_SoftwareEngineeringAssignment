package org.FAF.businesslogic.orderbl.withdrawOrder;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.orderbl.withdrawOrder.OrderWithdrawer;
import businesslogic.orderbl.withdrawOrder.WithdrawOrderServiceImpl;
import po.OrderState;
import po.RoomType;
import rmi.LinkToServer;
import vo.OrderVO;

public class WithdrawOrderServiceImplTest {
	private static LinkToServer linkToServer;
	
	private WithdrawOrderServiceImpl withdrawOrderServiceImpl;
	private OrderWithdrawer orderWithdrawer;
	
	private boolean withDrawResult;
	
	@BeforeClass
	public static void set() {
		linkToServer = new LinkToServer();
		linkToServer.linkToServer();
	}
	
	@Before
	public void setup(){
		withDrawResult = true;
		
		orderWithdrawer = new OrderWithdrawer();
		withdrawOrderServiceImpl = new WithdrawOrderServiceImpl();
		withdrawOrderServiceImpl.set(orderWithdrawer);
	}
	
	@Test
	public void withdrawOrderTest_1(){
		@SuppressWarnings("deprecation")
		OrderVO vo = new OrderVO("19970206", "0001000100010001", "汉庭酒店", "江苏省南京市栖霞区仙林大道163号", 
				new Date(116, 11, 20), new Date(116, 11, 21), RoomType.STANDARD_ROOM,
				1, 200, OrderState.NOT_DONE_ORDER, new Date(116, 11, 15, 18, 0), new Date(116, 11, 20, 22, 0), 2, 
				false, false, false);
		
		boolean result = withdrawOrderServiceImpl.withdrawOrder(vo, false);
		assertEquals(withDrawResult, result);
	}
}
