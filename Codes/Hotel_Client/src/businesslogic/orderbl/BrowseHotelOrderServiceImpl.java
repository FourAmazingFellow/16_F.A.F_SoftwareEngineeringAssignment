package businesslogic.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.utilitybl.POList2VOList;
import businesslogicservice.orderblservice.BrowseHotelOrderService;
import dataservice.orderDAO.OrderDAO;
import po.OrderType;
import vo.BriefOrderInfoVO;
import vo.OrderVO;

public class BrowseHotelOrderServiceImpl implements BrowseHotelOrderService {
	private HotelOrderList listHelper;
	private POList2VOList poTransformer;
	private OrderDAO orderDaoService;
	
	
	public ArrayList<BriefOrderInfoVO> getHotelOrderList(String address, Enum<OrderType> orderType) {
		ArrayList<BriefOrderInfoVO> hotelOrderList = poTransformer.briefPo2voList( listHelper.getHotelOrderList(address, orderType) );
		
		return hotelOrderList;
	}
	
	public OrderVO getSingleOrder(String address, String orderID) throws RemoteException {
		OrderVO detailedOrder = poTransformer.orderPO2VO(orderDaoService.getSingleOrder(address, orderID));
		
		return detailedOrder;
	}

}
