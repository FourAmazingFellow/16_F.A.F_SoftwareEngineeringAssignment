package businesslogic.orderbl.getOrderDone;

import vo.OrderVO;

public class MockOrderTerminator {
	private boolean doneResult;
	private boolean delayResult;
	
	public MockOrderTerminator(boolean doneResult, boolean delayResult){
		this.doneResult = doneResult;
		this.delayResult = delayResult;
	}
	
	public boolean getOrderDone(OrderVO vo) {
		return doneResult;
	}
	
	public boolean delayCheckIn(OrderVO vo){
		return delayResult;
	}
}
