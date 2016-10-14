package businesslogicservice.hotelblservice;

import vo.HotelVO;

/**
 * 
 * @author 原
 * @version
 * @see
 */
public interface MaintainHotelBasicInfoService {
	
	/**
	 * 
	 * @param address
	 * @return
	 * @see
	 */
	public HotelVO enrollHotelBasicInfo(String address);
	
	/**
	 * 
	 * @param modified
	 * @return
	 * @see
	 */
	public boolean confirmModify(HotelVO modified);

}
