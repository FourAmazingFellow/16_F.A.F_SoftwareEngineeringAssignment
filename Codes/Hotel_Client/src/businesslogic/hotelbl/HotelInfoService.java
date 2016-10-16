package businesslogic.hotelbl;

import vo.HotelBriefInfoVO;
import vo.HotelVO;

/**
 * 为同层调用提供酒店信息
 * @author 原
 * @version 1.0
 * @see
 */
public interface HotelInfoService {
	
	/**
	 * 获取该酒店简要信息
	 * @param address String型， 同层调用传来的酒店地址
	 * @return 返回该酒店简要信息
	 * @see
	 */
	public HotelBriefInfoVO getHotelBriefInfo(String address);
	
	/**
	 * 获取该酒店详细信息
	 * @param address String型，同层调用传来的酒店地址
	 * @return 返回该酒店详细信息
	 * @see
	 */
	public HotelVO getHotelDetails(String address);

}