package org.FAF.businesslogic.orderbl.withdrawOrder;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
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
		try {
			linkToServer.linkToServer();
		} catch (RemoteException e) {
			System.out.println("网络通信错误");
		}
	}
	
	@Before
	public void setup() {
		orderWithdrawer = new OrderWithdrawer();
		
		withdrawResult = true;
	}
	
	@Test
	public void withdrawOrderTest_1(){
		@SuppressWarnings("deprecation")
		OrderVO vo = new OrderVO("原", "0000000000000006", "Jingling Hotel", "江苏省南京市栖霞区仙林大道163号", 
				new Date(116, 11, 5), new Date(116, 11, 6), RoomType.STANDARD_ROOM,
				1, 200, OrderState.NOT_DONE_ORDER, new Date(116, 11, 15, 18, 0), new Date(116, 11, 20, 22, 0), 2, 
				false, false, false);
		
		boolean result;
		try {
			result = orderWithdrawer.withdrawOrder(vo, false);
			assertEquals(withdrawResult, result);
		} catch (RemoteException e) {
			e.printStackTrace();
			fail();
		}
	}
}
