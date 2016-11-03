package businesslogic.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.orderDAO.OrderDAO;
import po.BriefOrderInfoPO;
import po.OrderType;

public class HotelOrderList {
	OrderDAO orderDaoService;
	ArrayList<BriefOrderInfoPO> briefOrderlist;
	
	/**
	 * 
	 * @param address
	 * @param orderType
	 * @return
	 * @see
	 */
	public ArrayList<BriefOrderInfoPO> getHotelOrderList(String address, Enum<OrderType> orderType) {
		try {
			briefOrderlist = orderDaoService.getHotelOrderList(address, orderType);
		} catch (RemoteException e) {
			//异常捕捉
			e.printStackTrace();
		}
		return briefOrderlist;
	}
}
