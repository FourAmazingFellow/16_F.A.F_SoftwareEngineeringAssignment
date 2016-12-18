package bl_Driver.orderblservice_Driver;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import businesslogicservice.orderblservice.CheckAbnormalOrderService;
import vo.BriefOrderInfoVO;
import vo.OrderVO;

public class CheckAbnormalOrderServiceImpl_Driver {
	public void drive(CheckAbnormalOrderService checkAbnormalOrderService) throws RemoteException{
		@SuppressWarnings("deprecation")
		ArrayList<BriefOrderInfoVO> a = checkAbnormalOrderService.getAbnormalOrderList(new Date(2016, 10, 16));
		BriefOrderInfoVO tested = a.get(0);
		if(a.isEmpty())
			System.out.println("无异常订单");
		else{
			System.out.println("成功获取异常订单列表");
			
			OrderVO orderVO = checkAbnormalOrderService.getDetailedOrder(tested.orderID);
			
			System.out.println("The latest CheckInTime is " + orderVO.lastedOrderDoneTime.toString());
			
			System.out.println("网站营销人员选择撤销订单");
			
			if(checkAbnormalOrderService.systemWithdrawOrder(orderVO, true)){
				System.out.println("网站营销人员撤销订单成功");
			}else{
				System.out.println("网站营销人员撤销订单失败");
			}
		}
	}
}
