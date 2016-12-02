package org.FAF.businesslogic.orderbl.createNewOrder;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.Date;

import businesslogic.orderbl.createNewOrder.Checker;
import businesslogic.roombl.RoomInfoService;
import businesslogic.roombl.RoomInfoServiceImpl;
import businesslogic.userbl.ClientCreditInfo;
import businesslogic.userbl.ClientCreditInfoImpl;
import businesslogicservice.orderblservice.ResultMessage;
import po.RoomType;
import rmi.LinkToServer;
import vo.OrderVO;

public class CheckerTest {
	private static LinkToServer linkToServer;
	
	private Checker checker;
	private ClientCreditInfo clientCreditGetter;
	private RoomInfoService orderChecker;
	private OrderVO orderToBeChecked;
	private boolean canUserCreateNewOrder;
	private ResultMessage resultMessage;
	
	@BeforeClass
	public static void set() {
		linkToServer = new LinkToServer();
		linkToServer.linkToServer();
	}
	
	@SuppressWarnings("deprecation")
	@Before
	public void setup() {
		checker = new Checker();
		
		clientCreditGetter = new ClientCreditInfoImpl();
		orderChecker = new RoomInfoServiceImpl();
		
		checker.setCreditHelper(clientCreditGetter);
		checker.setRoomHelper(orderChecker);
		
		canUserCreateNewOrder = true;
		resultMessage = ResultMessage.SUCCEED;
		orderToBeChecked = new OrderVO("19970206", "0001000100010001", "汉庭酒店", "江苏省南京市栖霞区仙林大道163号", 
				new Date(116, 11, 20), new Date(116, 11, 21), RoomType.STANDARD_ROOM,
				1, 200, null, new Date(116, 11, 15, 18, 0), new Date(116, 11, 20, 22, 0), 2, 
				false, false, false);
	}

	@Test
	public void canUserCreateNewOrderTest_1() {
		boolean result = checker.canUserCreateNewOrder("19970206");
		assertEquals(canUserCreateNewOrder, result);
	}

	@Test
	public void checkNewOrderTest_1() {
		ResultMessage result = checker.checkNewOrder(orderToBeChecked);
		assertEquals(resultMessage, result);
	}
}
