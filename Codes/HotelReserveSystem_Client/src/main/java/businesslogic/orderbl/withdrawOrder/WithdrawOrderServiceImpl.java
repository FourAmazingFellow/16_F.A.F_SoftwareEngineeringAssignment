package businesslogic.orderbl.withdrawOrder;

import businesslogicservice.orderblservice.WithdrawOrderService;
import vo.OrderVO;

public class WithdrawOrderServiceImpl implements WithdrawOrderService {
	private OrderWithdrawer orderWithdrawer;
	
	public WithdrawOrderServiceImpl() {
		orderWithdrawer = new OrderWithdrawer();
	}
	
	@Override
	public boolean withdrawOrder(OrderVO vo, boolean isTooLate) {
		return orderWithdrawer.withdrawOrder(vo, isTooLate);
	}

}
