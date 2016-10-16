package bl_Stub.orderblservice_Stub;

import java.util.ArrayList;

import businesslogicservice.orderblservice.BrowseUserOrderService;
import po.OrderType;
import vo.BriefOrderInfoVO;
import vo.OrderVO;

public class BrowseUserOrderServiceImpl_Stub implements BrowseUserOrderService {

	@Override
	public ArrayList<BriefOrderInfoVO> getUserOrderList(long ID, Enum<OrderType> orderType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderVO getDetailedOrder(String orderID) {
		// TODO Auto-generated method stub
		return null;
	}

}
