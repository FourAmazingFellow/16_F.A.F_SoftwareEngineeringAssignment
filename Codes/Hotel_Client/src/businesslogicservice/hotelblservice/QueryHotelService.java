package businesslogicservice.hotelblservice;

import java.util.ArrayList;

import vo.HotelBriefInfoVO;
import vo.HotelVO;
import vo.OrderVO;

/**
 * 
 * @author 原
 * @version 1.0
 * @see
 */
public interface QueryHotelService {
	
	/**
	 * 
	 * @param condition
	 * @return
	 * @see
	 */
	public ArrayList<HotelBriefInfoVO> getHotelBriefInfoListByQuerying (String[] condition);
	
	/**
	 * 
	 * @param address
	 * @return
	 * @see
	 */
	public HotelVO getHotelDetails(String address);
	
	/**
	 * 
	 * @param address
	 * @param ID
	 * @return
	 * @see
	 */
	public ArrayList<OrderVO> getOrders(String address, long ID);

}
