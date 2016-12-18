package businesslogic.orderbl.browseUserOrder;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.utilitybl.POList2VOList;
import dataservice.orderDAO.OrderDAO;
import po.OrderType;
import rmi.RemoteHelper;
import vo.BriefOrderInfoVO;
import vo.OrderVO;

public class UserOrderList {
	private OrderDAO orderDaoService;
	private POList2VOList poTransformer;
	private ArrayList<BriefOrderInfoVO> briefUserOrderlist;
	private OrderVO detailedOrder;
	
	public UserOrderList(){
		orderDaoService = RemoteHelper.getInstance().getOrderDAO();
		poTransformer = new POList2VOList();
		briefUserOrderlist = new ArrayList<BriefOrderInfoVO>();
	}
	
	/**
	 * 得到客户简要订单列表
	 * @param userID
	 * @param orderType
	 * @return 客户简要订单列表
	 * @throws RemoteException 
	 * @see
	 */
	public ArrayList<BriefOrderInfoVO> getUserOrderList(String userID, Enum<OrderType> orderType) throws RemoteException {
		briefUserOrderlist = poTransformer.briefPo2voList(orderDaoService.getUserOrderList(userID, orderType));
		return briefUserOrderlist;
	}
	
	public OrderVO getDetailedOrder(String orderID) throws RemoteException {
		detailedOrder = poTransformer.orderPO2VO(orderDaoService.getDetailedOrder(orderID));
		return detailedOrder;
	}
}
