package businesslogic.hotelbl;

import vo.HotelBriefInfoVO;
import vo.HotelVO;

/**
 * 
 * @author 原
 * @version
 */
public interface HotelInfoService {
	
	/**
	 * 
	 * @param address
	 * @return
	 * @see
	 */
	public HotelBriefInfoVO getHotelBriefInfo(String address);
	
	/**
	 * 
	 * @param address
	 * @return
	 * @see
	 */
	public HotelVO getHotelDetails(String address);

}
