package bl_Stub.hotelblservice_Stub;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import businesslogicservice.hotelblservice.CheckOrderedHotelService;
import po.OrderState;
import vo.OrderedHotelInfoVO;

public class CheckOrderedHotelServiceImpl_Stub implements CheckOrderedHotelService{
	public String hotelName;
	public String tradeArea;
	public String hotelAddress;
	public int starLevel;
	public float mark;
	
	public CheckOrderedHotelServiceImpl_Stub(String hotelName, String tradeArea, String hotelAddress, int starLevel,
			float mark) {
		this.hotelName = hotelName;
		this.tradeArea = tradeArea;
		this.hotelAddress = hotelAddress;
		this.starLevel = starLevel;
		this.mark = mark;
	}
	
	@Override
	public ArrayList<OrderedHotelInfoVO> enrollHotelBreifInfoList(String ID) {
		ArrayList<OrderedHotelInfoVO> orderedHotelInfoVOList = new ArrayList<>();
		Set<Enum<OrderState>> orderStates = new HashSet<>();
		orderStates.add(OrderState.DONE_ORDER);
		orderedHotelInfoVOList.add(new OrderedHotelInfoVO(hotelName, tradeArea, hotelAddress, starLevel, mark, orderStates, 100));
		return orderedHotelInfoVOList;
	}

}
