package businesslogic.hotelbl.checkOrderedHotel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import po.OrderState;
import vo.OrderedHotelInfoVO;

public class MockOrderedHotelList extends OrderedHotelList {
	
	String userID;
	
	public MockOrderedHotelList(String userID) {
		super(userID);
		this.userID = userID;
	}

	@Override
	public ArrayList<OrderedHotelInfoVO> enrollHotelBreifInfoList() {
		ArrayList<OrderedHotelInfoVO>  orderedHotelInfoVOs = new ArrayList<>();
		Set<Enum<OrderState>> orderStates = new HashSet<>();
		orderStates.add(OrderState.DONE_ORDER);
		OrderedHotelInfoVO orderedHotelInfoVO = new OrderedHotelInfoVO("Jingling Hotel", "新街口", "江苏省南京市栖霞区仙林大道163号", 5, 5.0f, orderStates);
		orderedHotelInfoVOs.add(orderedHotelInfoVO);
		return orderedHotelInfoVOs;
	}
	
	
}
