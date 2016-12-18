package bl_Driver.orderblservice_Driver;

import java.rmi.RemoteException;

import businesslogicservice.orderblservice.WithdrawOrderService;
import vo.OrderVO;

public class WithdrawOrderServiceImpl_Driver {
	public void drive(WithdrawOrderService withdrawOrderService) throws RemoteException {
		OrderVO orderVO = null;
		if (withdrawOrderService.withdrawOrder(orderVO, true)) {
			System.out.println("撤销订单成功");
		} else {
			System.out.println("撤销订单失败");

		}
	}
}
