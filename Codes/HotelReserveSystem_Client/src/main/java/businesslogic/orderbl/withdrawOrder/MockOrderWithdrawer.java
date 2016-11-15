package businesslogic.orderbl.withdrawOrder;

import vo.OrderVO;

public class MockOrderWithdrawer {
	private boolean withdrawResult;
	
	public MockOrderWithdrawer(boolean withdrawResult){
		this.withdrawResult = withdrawResult;
	}
	
	public boolean withdrawOrder(OrderVO vo, boolean isTooLate) {
		return withdrawResult;
	}
}
