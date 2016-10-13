package businesslogic.hotelbl;

import vo.HotelBriefInfoVO;
import vo.HotelVO;

public interface HotelInfoService {
	public HotelBriefInfoVO getHotelBriefInfo(String address);
	
	public HotelVO getHotelDetails(String address);

}
