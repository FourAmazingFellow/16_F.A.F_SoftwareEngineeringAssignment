package bl_Driver.orderblservice_Driver;

import java.util.ArrayList;

import businesslogicservice.orderblservice.GetOrderDoneService;
import vo.BriefOrderInfoVO;
import vo.OrderVO;

public class GetOrderDoneServiceImpl_Driver {
	public void drive(GetOrderDoneService getOrderDoneService){
		ArrayList<BriefOrderInfoVO> a = getOrderDoneService.getHotelNotDoneOrderList("江苏省南京市栖霞区仙林大道163号");
		BriefOrderInfoVO order_1 = a.get(0);
		BriefOrderInfoVO order_2 = a.get(1);
		if(a.isEmpty())
			System.out.println("该酒店无订单");
		else{
			System.out.println(order_1.hotelName + "'s Hotel is Checked.");
			System.out.println("酒店工作人员请求查看订单详情");
			
			OrderVO orderVO_1 = getOrderDoneService.getSingleOrder(order_1.hotelAddress, order_1.orderID);
			OrderVO orderVO_2 = getOrderDoneService.getSingleOrder(order_2.hotelAddress, order_2.orderID);
			
			System.out.println("展开订单详情成功");
			System.out.println("酒店工作人员请求执行订单");
			
			if(getOrderDoneService.getOrderDone(orderVO_1)){
				System.out.println("线下付款，为客户增加与订单金额等值的信用值，订单执行");
			}else{
				System.out.println("订单执行失败，请检查网络，稍后再试");
			}
			
			System.out.println("酒店工作人员请求延迟入住");
			if(getOrderDoneService.delayCheckIn(orderVO_2)){
				System.out.println("2号订单已被延迟入住二小时");
			}else{
				System.out.println("延迟失败失败，请检查网络，稍后再试");
			}
			
		}
	}
}
