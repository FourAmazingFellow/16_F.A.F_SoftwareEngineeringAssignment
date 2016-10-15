package businesslogicservice.hotelblservice;

import java.util.ArrayList;

import vo.HotelBriefInfoVO;

/**
 * 
 * @author 原
 * @version 1.0
 * @see
 */
public interface CheckOrderedHotelService {
	
	/**
	 * 
	 * @param ID
	 * @return
	 * @see
	 */
	public ArrayList<HotelBriefInfoVO> enrollHotelBreifInfoList (long ID);

}
