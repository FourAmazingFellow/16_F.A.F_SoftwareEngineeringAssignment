package businesslogic.hotelbl.checkOrderedHotel;

import java.util.ArrayList;

import businesslogicservice.hotelblservice.CheckOrderedHotelService;
import vo.OrderedHotelInfoVO;

public class CheckOrderedHotelServiceImpl implements CheckOrderedHotelService {

	private OrderedHotelList orderedHotelList;
	
	@Override
	public ArrayList<OrderedHotelInfoVO> enrollHotelBreifInfoList(String userID) {
		orderedHotelList = new MockOrderedHotelList(userID);
		return orderedHotelList.enrollHotelBreifInfoList();
	}

}

