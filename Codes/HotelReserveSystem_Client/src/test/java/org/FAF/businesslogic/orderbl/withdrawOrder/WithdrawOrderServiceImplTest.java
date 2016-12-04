package org.FAF.businesslogic.orderbl.withdrawOrder;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.orderbl.withdrawOrder.WithdrawOrderServiceImpl;
import po.OrderState;
import po.RoomType;
import rmi.LinkToServer;
import vo.OrderVO;

public class WithdrawOrderServiceImplTest {
	private static LinkToServer linkToServer;
	
	private WithdrawOrderServiceImpl withdrawOrderServiceImpl;
	
	@BeforeClass
	public static void set() {
		linkToServer = new LinkToServer();
		linkToServer.linkToServer();
	}
	
	@Before
	public void setup(){
		withdrawOrderServiceImpl = new WithdrawOrderServiceImpl();
	}

	@Test
	public void withdrawOrderTest_1(){
		@SuppressWarnings("deprecation")
		OrderVO vo = new OrderVO("原", "0000000000000002", "Jingling Hotel", "江苏省南京市栖霞区仙林大道163号", 
				new Date(116, 11, 20), new Date(116, 11, 21), RoomType.STANDARD_ROOM,
				1, 400, OrderState.DONE_ORDER, new Date(116, 11, 15, 18, 0), new Date(116, 11, 20, 22, 0), 2, 
				false, false, false);
		
		boolean result = withdrawOrderServiceImpl.withdrawOrder(vo, false);
		assertEquals(false, result);
	}
	
	//空指针测试
	@Test
	public void withdrawOrderTest_2() {
		boolean result = withdrawOrderServiceImpl.withdrawOrder(null, false);
		assertEquals(false, result);
	}
	
	//正常撤销测试
	@Test
	public void withdrawOrderTest_3() {
		@SuppressWarnings("deprecation")
		OrderVO vo = new OrderVO("原", "0000000000000006", "Jingling Hotel", "江苏省南京市栖霞区仙林大道163号", 
				new Date(116, 11, 5), new Date(116, 11, 6), RoomType.STANDARD_ROOM,
				1, 200, OrderState.NOT_DONE_ORDER, new Date(116, 11, 15, 18, 0), new Date(116, 11, 20, 22, 0), 2, 
				false, false, false);
		
		boolean result = withdrawOrderServiceImpl.withdrawOrder(vo, false);
		assertEquals(true, result);
	}
}
