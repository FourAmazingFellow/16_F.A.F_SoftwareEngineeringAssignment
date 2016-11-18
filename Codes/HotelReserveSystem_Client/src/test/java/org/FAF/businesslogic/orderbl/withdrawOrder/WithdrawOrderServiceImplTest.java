package org.FAF.businesslogic.orderbl.withdrawOrder;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import businesslogic.orderbl.withdrawOrder.MockOrderWithdrawer;
import businesslogic.orderbl.withdrawOrder.OrderWithdrawer;
import businesslogic.orderbl.withdrawOrder.WithdrawOrderServiceImpl;
import po.OrderState;
import po.RoomType;
import vo.OrderVO;

public class WithdrawOrderServiceImplTest {
	private WithdrawOrderServiceImpl withdrawOrderServiceImpl;
	private OrderWithdrawer mockOrderWithdrawer;
	
	private boolean withDrawResult;
	
	@Before
	public void setup(){
		mockOrderWithdrawer = new MockOrderWithdrawer(true);
		withdrawOrderServiceImpl = new WithdrawOrderServiceImpl();
		withdrawOrderServiceImpl.set(mockOrderWithdrawer);
		withDrawResult = true;
	}
	
	@Test
	public void withdrawOrderTest_1(){
		@SuppressWarnings("deprecation")
		OrderVO vo = new OrderVO("19970206", "0001000100010001", "汉庭酒店", "江苏省南京市栖霞区仙林大道163号", 
				new Date(2016, 12, 20), new Date(2016, 12, 21), RoomType.STANDARD_ROOM,
				1, 200, OrderState.NOT_DONE_ORDER, new Date(2016, 12, 15, 18, 0), new Date(2016, 12, 20, 22, 0), 2, 
				false, false, false);
		
		boolean result = withdrawOrderServiceImpl.withdrawOrder(vo, false);
		assertEquals(withDrawResult, result);
	}
}
