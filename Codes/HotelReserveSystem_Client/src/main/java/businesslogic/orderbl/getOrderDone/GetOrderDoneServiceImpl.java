package businesslogic.orderbl.getOrderDone;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.orderbl.browseHotelOrder.HotelOrderList;
import businesslogicservice.orderblservice.GetOrderDoneService;
import po.OrderType;
import vo.BriefOrderInfoVO;
import vo.OrderVO;

public class GetOrderDoneServiceImpl implements GetOrderDoneService {
	private HotelOrderList hotelOrderBrowser;
	private OrderTerminator orderTerminator;

	public GetOrderDoneServiceImpl() {
		hotelOrderBrowser = new HotelOrderList();
		orderTerminator = new OrderTerminator();
	}
	
	@Override
	public ArrayList<BriefOrderInfoVO> getHotelNotDoneOrderList(String address) throws RemoteException {
		ArrayList<BriefOrderInfoVO> notDoneOrderList = hotelOrderBrowser.getHotelOrderList(address,
				OrderType.NOT_DONE_ORDER);

		return notDoneOrderList;
	}

	@Override
	public OrderVO getSingleOrder(String address, String orderID) {
		OrderVO detailedOrder = hotelOrderBrowser.getSingleOrder(address, orderID);

		return detailedOrder;
	}

	@Override
	public boolean getOrderDone(OrderVO vo) throws RemoteException {
		return orderTerminator.getOrderDone(vo);
	}

	@Override
	public boolean delayCheckIn(OrderVO vo) {

		return orderTerminator.delayCheckIn(vo);
	}

}
