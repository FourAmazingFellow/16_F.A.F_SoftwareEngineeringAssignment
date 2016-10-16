package bl_Stub.orderblservice_Stub;

import java.util.ArrayList;

import businesslogicservice.orderblservice.BrowseHotelOrderService;
import po.OrderType;
import vo.BriefOrderInfoVO;
import vo.OrderVO;

public class BrowseHotelOrderServiceImpl_Stub implements BrowseHotelOrderService{

	@Override
	public ArrayList<BriefOrderInfoVO> getHotelOrderList(String address, Enum<OrderType> orderType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderVO getSingleOrder(String address, String orderID) {
		// TODO Auto-generated method stub
		return null;
	}

}
