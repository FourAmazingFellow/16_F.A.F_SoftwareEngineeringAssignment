package bl_Driver.orderblservice_Driver;

import java.util.ArrayList;

import businesslogicservice.orderblservice.WithdrawOrderService;
import po.OrderType;
import vo.BriefOrderInfoVO;
import vo.OrderVO;

public class WithdrawOrderServiceImpl_Driver {
	public void drive(WithdrawOrderService withdrawOrderService) {
		ArrayList<BriefOrderInfoVO> a = withdrawOrderService.getUserOrderList("原", OrderType.ALL);
		BriefOrderInfoVO tested = a.get(0);
		if (a.isEmpty())
			System.out.println("该用户无订单");
		else {
			System.out.println("成功获取订单");

			OrderVO orderVO = withdrawOrderService.getDetailedOrder(tested.orderID);

			System.out.println("若撤销订单需要扣除信用值，确认继续吗？");

			if (withdrawOrderService.withdrawOrder(orderVO, true)) {
				System.out.println("撤销订单成功");
			} else {
				System.out.println("撤销订单失败");

			}
		}
	}
}
