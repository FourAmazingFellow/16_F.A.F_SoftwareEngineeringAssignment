package bl_Driver.orderblservice_Driver;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.orderblservice.BrowseHotelOrderService;
import po.OrderType;
import vo.BriefOrderInfoVO;
import vo.OrderVO;

public class BrowseHotelOrderServiceImpl_Driver {
	public void drive(BrowseHotelOrderService browseHotelOrderService) throws RemoteException{
		ArrayList<BriefOrderInfoVO> a = browseHotelOrderService.getHotelOrderList("江苏省南京市栖霞区仙林大道163号", OrderType.ALL);
		BriefOrderInfoVO tested = a.get(0);
		if(a.isEmpty())
			System.out.println("该酒店无订单");
		else{
			System.out.println(tested.hotelName + "'s Hotel is Checked.");
		}
		
		OrderVO orderVO = browseHotelOrderService.getSingleOrder(tested.hotelAddress, tested.orderID);
		
		if(orderVO.isChildren)
			System.out.println("此订单有小孩入住");
		else if(!orderVO.isChildren)
			System.out.println("此订单无小孩入住");
		else
			System.out.println("查看订单失败");
	}
}