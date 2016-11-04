package businesslogic.orderbl.withdrawOrder;

import businesslogicservice.orderblservice.WithdrawOrderService;
import vo.OrderVO;

public class WithdrawOrderServiceImpl implements WithdrawOrderService {
	OrderWithdrawer OrderWithdrawer;
	
	@Override
	public boolean withdrawOrder(OrderVO vo, boolean isTooLate) {
		
		return OrderWithdrawer.withdrawOrder(vo, isTooLate);
	}

}
