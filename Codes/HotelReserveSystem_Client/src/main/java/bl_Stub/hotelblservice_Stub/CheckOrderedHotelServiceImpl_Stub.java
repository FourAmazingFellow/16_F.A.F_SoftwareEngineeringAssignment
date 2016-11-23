package bl_Stub.hotelblservice_Stub;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import businesslogicservice.hotelblservice.CheckOrderedHotelService;
import po.OrderState;
import vo.OrderedHotelInfoVO;

public class CheckOrderedHotelServiceImpl_Stub implements CheckOrderedHotelService{
	public String hotelName;
	public String businessDistrict;
	public String hotelAddress;
	public int starLevel;
	public float mark;
	
	public CheckOrderedHotelServiceImpl_Stub(String hotelName, String businessDistrict, String hotelAddress, int starLevel,
			float mark) {
		this.hotelName = hotelName;
		this.businessDistrict = businessDistrict;
		this.hotelAddress = hotelAddress;
		this.starLevel = starLevel;
		this.mark = mark;
	}
	
	@Override
	public ArrayList<OrderedHotelInfoVO> enrollHotelBreifInfoList(String ID) {
		ArrayList<OrderedHotelInfoVO> orderedHotelInfoVOList = new ArrayList<>();
		Set<Enum<OrderState>> orderStates = new HashSet<>();
		orderStates.add(OrderState.DONE_ORDER);
		orderedHotelInfoVOList.add(new OrderedHotelInfoVO(hotelName, businessDistrict, hotelAddress, starLevel, mark, orderStates));
		return orderedHotelInfoVOList;
	}

}
