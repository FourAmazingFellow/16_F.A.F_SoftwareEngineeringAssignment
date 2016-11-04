package businesslogic.orderbl.browseHotelOrder;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.orderblservice.BrowseHotelOrderService;
import po.OrderType;
import vo.BriefOrderInfoVO;
import vo.OrderVO;

public class BrowseHotelOrderServiceImpl implements BrowseHotelOrderService {
	private HotelOrderList hotelListHelper;
	
	public ArrayList<BriefOrderInfoVO> getHotelOrderList(String address, Enum<OrderType> orderType) {
		ArrayList<BriefOrderInfoVO> hotelOrderList = hotelListHelper.getHotelOrderList(address, orderType);
		
		return hotelOrderList;
	}
	
	public OrderVO getSingleOrder(String address, String orderID) throws RemoteException {
		OrderVO detailedOrder = hotelListHelper.getSingleOrder(address, orderID);
		
		return detailedOrder;
	}

}
