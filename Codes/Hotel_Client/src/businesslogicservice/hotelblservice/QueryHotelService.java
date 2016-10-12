package businesslogicservice.hotelblservice;

import java.util.ArrayList;

import vo.HotelBriefInfoVO;
import vo.HotelVO;
import vo.OrderVO;

public interface QueryHotelService {
	public ArrayList<HotelBriefInfoVO> getHotelBriefInfoListByQuerying (String[] condition);
	
	public HotelVO getHotelDetails(String address);
	
	public ArrayList<OrderVO> getOrders(String address, long ID);

}
