package businesslogicservice.hotelblservice;

import vo.HotelVO;
import vo.UserVO;

public interface ManageHotelInfoService {
	public boolean addHotel(HotelVO hotel);
	
	public boolean addHotelStaff(UserVO staff);

}
