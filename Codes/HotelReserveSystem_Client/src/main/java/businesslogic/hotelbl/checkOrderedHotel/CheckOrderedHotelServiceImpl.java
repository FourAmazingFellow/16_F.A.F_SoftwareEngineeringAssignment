package businesslogic.hotelbl.checkOrderedHotel;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.hotelblservice.CheckOrderedHotelService;
import vo.OrderedHotelInfoVO;

public class CheckOrderedHotelServiceImpl implements CheckOrderedHotelService {

	private OrderedHotelList orderedHotelList;

	@Override
	public ArrayList<OrderedHotelInfoVO> enrollHotelBreifInfoList(String userID) throws RemoteException {
		orderedHotelList = new OrderedHotelList(userID);
		return orderedHotelList.enrollHotelBreifInfoList();
	}

}
