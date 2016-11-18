package org.FAF.businesslogic.orderbl.checkAbnormalOrder;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import businesslogic.orderbl.checkAbnormalOrder.SystemOrderWithdrawer;

public class SystemOrderWithdrawerTest {
	private SystemOrderWithdrawer systemOrderWithdrawer;
	private boolean result;
	
	@Before
	public void setUp(){
		result = true;
		systemOrderWithdrawer = new SystemOrderWithdrawer();
	}
	
	@Test
	public void systemWithdrawOrderTest_1(){
		boolean actual = systemOrderWithdrawer.systemWithdrawOrder(null, false);
		assertEquals(result, actual);;
		
	}
}
