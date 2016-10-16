package bl_Stub.orderblservice_Stub;

import java.util.ArrayList;

import businesslogicservice.orderblservice.GetOrderDoneService;
import po.OrderState;
import po.OrderType;
import vo.BriefOrderInfoVO;
import vo.OrderVO;

public class GetOrderDoneServiceImpl_Stub implements GetOrderDoneService {

	@Override
	public ArrayList<BriefOrderInfoVO> getHotelOrderList(String address, Enum<OrderType> orderType) {
		// TODO Auto-generated method stub
		System.out.println("得到酒店所有订单列表");
		return null;
	}

	@Override
	public OrderVO getSingleOrder(String address, String orderID) {
		// TODO Auto-generated method stub
		System.out.println("得到F.A.F酒店的对应订单");
		return null;
	}

	@Override
	public boolean setOrderState(Enum<OrderState> orderstate, OrderVO vo) {
		// TODO Auto-generated method stub
		System.out.println("更改订单状态");
		return false;
	}

	@Override
	public boolean getOrderDone(OrderVO vo) {
		// TODO Auto-generated method stub
		System.out.println("执行订单");
		return false;
	}

	@Override
	public boolean delayCheckIn(OrderVO vo, int hours) {
		// TODO Auto-generated method stub
		System.out.println("延迟入住");
		return false;
	}

}
