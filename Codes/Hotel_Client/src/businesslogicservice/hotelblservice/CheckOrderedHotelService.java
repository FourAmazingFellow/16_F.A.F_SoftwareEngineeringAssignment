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
	 * 获取当前用户所有预订过的酒店简要信息列表
	 * @param ID long型，界面传递过来的用户标识
	 * @return 返回当前用户所有预订过的酒店简要信息列表
	 * @see
	 */
	public ArrayList<HotelBriefInfoVO> enrollHotelBreifInfoList (long ID);

}
