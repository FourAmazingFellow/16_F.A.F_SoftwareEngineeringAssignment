package businesslogic.hotelbl;

import vo.HotelBriefInfoVO;
import vo.HotelVO;

/**
 * 
 * @author 原
 * @version 1.0
 * @see
 */
public interface HotelInfoService {
	
	/**
	 * 
	 * @param address String型， 同层调用传来的酒店地址
	 * @return 返回酒店简要信息的值对象
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
