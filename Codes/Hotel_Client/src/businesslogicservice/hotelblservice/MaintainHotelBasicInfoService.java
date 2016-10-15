package businesslogicservice.hotelblservice;

import vo.HotelVO;

/**
 * 
 * @author 原
 * @version 1.0
 * @see
 */
public interface MaintainHotelBasicInfoService {
	
	/**
	 * 获取酒店的基本信息
	 * @param address String型，从界面传递来的酒店地址
	 * @return 返回酒店的基本信息
	 * @see
	 */
	public HotelVO enrollHotelBasicInfo(String address);
	
	/**
	 * 修改酒店基本信息
	 * @param modified
	 * @return 修改成功返回true，修改失败返回false
	 * @see
	 */
	public boolean confirmModify(HotelVO modified);

}
