package org.FAF.businesslogic.orderbl.createNewOrder;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.Date;

import businesslogic.orderbl.createNewOrder.Checker;
import businesslogicservice.orderblservice.ResultMessage;
import po.RoomType;
import rmi.LinkToServer;
import vo.OrderVO;

public class CheckerTest {
	private static LinkToServer linkToServer;
	
	private Checker checker;
	private OrderVO orderToBeChecked;
	private boolean canUserCreateNewOrder;
	private ResultMessage resultMessage;
	
	@BeforeClass
	public static void set() {
		linkToServer = new LinkToServer();
		try {
			linkToServer.linkToServer();
		} catch (RemoteException e) {
			System.out.println("网络通信错误");
		}
	}
	
	@SuppressWarnings("deprecation")
	@Before
	public void setup() {
		checker = new Checker();
			
		canUserCreateNewOrder = true;
		resultMessage = ResultMessage.SUCCEED;
		orderToBeChecked = new OrderVO("原", "0000000000000001", "Jingling Hotel", "江苏省南京市栖霞区仙林大道163号", 
				new Date(116, 11, 20), new Date(116, 11, 21), RoomType.STANDARD_ROOM,
				1, 200, null, new Date(116, 11, 15, 18, 0), new Date(116, 11, 20, 22, 0), 2, 
				false, false, false);
	}

	@Test
	public void canUserCreateNewOrderTest_1() {
		boolean result;
		try {
			result = checker.canUserCreateNewOrder("原");
			assertEquals(canUserCreateNewOrder, result);
		} catch (RemoteException e) {
			e.printStackTrace();
			fail();
		}
	}

	//异常情况下的Test
	@Test
	public void checkNewOrderTest_1() {
		ResultMessage result = checker.checkNewOrder(orderToBeChecked);
		assertEquals(resultMessage, result);
	}
}
