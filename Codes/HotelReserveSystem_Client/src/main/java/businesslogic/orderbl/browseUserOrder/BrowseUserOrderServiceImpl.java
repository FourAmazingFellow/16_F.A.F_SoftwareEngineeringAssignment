package businesslogic.orderbl.browseUserOrder;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.orderblservice.BrowseUserOrderService;
import po.OrderType;
import vo.BriefOrderInfoVO;
import vo.OrderVO;

public class BrowseUserOrderServiceImpl implements BrowseUserOrderService {
	private UserOrderList userListHelper;
	
	public BrowseUserOrderServiceImpl() {
		userListHelper = new UserOrderList();
	}
	
	@Override
	public ArrayList<BriefOrderInfoVO> getUserOrderList(String userID, Enum<OrderType> orderType) throws RemoteException {
		ArrayList<BriefOrderInfoVO> userOrderList = userListHelper.getUserOrderList(userID, orderType);
		return userOrderList;
	}

	@Override
	public OrderVO getDetailedOrder(String orderID) throws RemoteException {
		OrderVO detailedOrder = userListHelper.getDetailedOrder(orderID);
		return detailedOrder;
	}
}
