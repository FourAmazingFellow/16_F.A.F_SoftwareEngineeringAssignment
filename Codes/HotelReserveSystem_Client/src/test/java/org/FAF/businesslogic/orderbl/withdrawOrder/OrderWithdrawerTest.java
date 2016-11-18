package org.FAF.businesslogic.orderbl.withdrawOrder;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import businesslogic.orderbl.withdrawOrder.OrderWithdrawer;
import businesslogic.roombl.MockRoomInfoServiceImpl;
import businesslogic.roombl.RoomInfoService;
import businesslogic.userbl.ClientCreditInfo;
import businesslogic.userbl.MockClientCreditInfoImpl;
import data_Stub.OrderDAOImpl_Stub;
import dataservice.orderDAO.OrderDAO;
import po.OrderState;
import po.RoomType;
import vo.OrderVO;

public class OrderWithdrawerTest {
	private OrderWithdrawer orderWithdrawer;
	private OrderDAO mockOrderDaoService;
	private ClientCreditInfo mockUserCreditService;
	private RoomInfoService mockAddSpareRoomService;
	
	private boolean withdrawResult;
	
	@SuppressWarnings("deprecation")
	@Before
	public void setup() {
		mockOrderDaoService = new OrderDAOImpl_Stub("19970206", "0001000100010001", "汉庭酒店", "江苏省南京市栖霞区仙林大道163号", 
				new Date(2016, 12, 20), new Date(2016, 12, 21), RoomType.STANDARD_ROOM,
				1, 200, OrderState.NOT_DONE_ORDER, new Date(2016, 12, 15, 18, 0), new Date(2016, 12, 20, 22, 0), 2, 
				false, false, false, false);
		mockUserCreditService = new MockClientCreditInfoImpl();
		mockAddSpareRoomService = new MockRoomInfoServiceImpl();
		orderWithdrawer = new OrderWithdrawer();
		orderWithdrawer.set(mockOrderDaoService, mockUserCreditService, mockAddSpareRoomService);
		
		withdrawResult = true;
	}
	
	@Test
	public void withdrawOrderTest_1(){
		@SuppressWarnings("deprecation")
		OrderVO vo = new OrderVO("19970206", "0001000100010001", "汉庭酒店", "江苏省南京市栖霞区仙林大道163号", 
				new Date(2016, 12, 20), new Date(2016, 12, 21), RoomType.STANDARD_ROOM,
				1, 200, OrderState.NOT_DONE_ORDER, new Date(2016, 12, 15, 18, 0), new Date(2016, 12, 20, 22, 0), 2, 
				false, false, false);
		
		boolean result = orderWithdrawer.withdrawOrder(vo, false);
		assertEquals(withdrawResult, result);
	}
}
