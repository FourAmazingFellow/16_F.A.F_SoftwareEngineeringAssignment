package businesslogicservice.hotelblservice;

import java.util.ArrayList;

import vo.HotelBriefInfoVO;

/**
 * 
 * @author 原
 * @version 1.0
 * @see
 */
public interface SearchHotelService {
	
	/**
	 * 搜索符合输入条件的酒店
	 * @param condition String型，界面传递来的搜索条件
	 * @return 返回所有满足条件的酒店简要信息列表
	 * @see
	 */
	public ArrayList<HotelBriefInfoVO> getHotelBriefInfoListBySearching (String[] condition);

}
