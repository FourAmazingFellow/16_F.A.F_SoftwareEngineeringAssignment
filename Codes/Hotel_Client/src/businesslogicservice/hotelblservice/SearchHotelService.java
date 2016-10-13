package businesslogicservice.hotelblservice;

import java.util.ArrayList;

import vo.HotelBriefInfoVO;

/**
 * 
 * @author 原
 * @version
 */
public interface SearchHotelService {
	
	/**
	 * 
	 * @param condition
	 * @return
	 * @see
	 */
	public ArrayList<HotelBriefInfoVO> getHotelBriefInfoListBySearching (String[] condition);

}
