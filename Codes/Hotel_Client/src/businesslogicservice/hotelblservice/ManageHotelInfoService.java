package businesslogicservice.hotelblservice;

import vo.HotelVO;
import vo.UserVO;

/**
 * 
 * @author 原
 * @version
 */
public interface ManageHotelInfoService {
	
	/**
	 * 
	 * @param hotel
	 * @return
	 * @see
	 */
	public boolean addHotel(HotelVO hotel);
	
	/**
	 * 
	 * @param staff
	 * @return
	 * @see
	 */
	public boolean addHotelStaff(UserVO staff);

}
