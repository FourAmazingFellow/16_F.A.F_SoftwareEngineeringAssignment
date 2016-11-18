package org.FAF.businesslogic.orderbl.createNewOrder;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.Date;

import businesslogic.orderbl.createNewOrder.Checker;
import businesslogic.roombl.MockRoomInfoServiceImpl;
import businesslogic.roombl.RoomInfoService;
import businesslogic.userbl.ClientCreditInfo;
import businesslogic.userbl.MockClientCreditInfoImpl;
import businesslogicservice.orderblservice.ResultMessage;
import po.RoomType;
import vo.OrderVO;

public class CheckerTest {
	private Checker checker;
	private ClientCreditInfo mockClientCreditGetter;
	private RoomInfoService mockOrderChecker;
	private OrderVO orderToBeChecked;
	private boolean canUserCreateNewOrder;
	private ResultMessage resultMessage;

	@SuppressWarnings("deprecation")
	@Before
	public void setup() {
		checker = new Checker();
		mockClientCreditGetter = new MockClientCreditInfoImpl();
		mockOrderChecker = new MockRoomInfoServiceImpl();
		checker.setCreditHelper(mockClientCreditGetter);
		checker.setRoomHelper(mockOrderChecker);
		canUserCreateNewOrder = true;
		resultMessage = ResultMessage.SUCCEED;
		orderToBeChecked = new OrderVO("19970206", "0001000100010001", "汉庭酒店", "江苏省南京市栖霞区仙林大道163号", 
				new Date(2016, 12, 20), new Date(2016, 12, 21), RoomType.STANDARD_ROOM,
				1, 200, null, new Date(2016, 12, 15, 18, 0), new Date(2016, 12, 20, 22, 0), 2, 
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
