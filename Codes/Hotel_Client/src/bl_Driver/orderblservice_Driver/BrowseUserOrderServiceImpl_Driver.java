package bl_Driver.orderblservice_Driver;

import java.util.ArrayList;

import businesslogicservice.orderblservice.BrowseUserOrderService;
import po.OrderType;
import vo.BriefOrderInfoVO;
import vo.OrderVO;

public class BrowseUserOrderServiceImpl_Driver {
	public void drive(BrowseUserOrderService browseUserOrderService){
		ArrayList<BriefOrderInfoVO> a = browseUserOrderService.getUserOrderList(1, OrderType.ALL);
		BriefOrderInfoVO tested = a.get(0);
		if(a.isEmpty())
			System.out.println("该用户无订单");
		else{
			System.out.println("成功获取订单");
			
			OrderVO orderVO = browseUserOrderService.getDetailedOrder(tested.orderID);
			
			if(orderVO.isChildren)
				System.out.println("此订单有小孩入住");
			else if(!orderVO.isChildren)
				System.out.println("此订单无小孩入住");
			else
				System.out.println("展开订单详情失败");
		}
	}
}
