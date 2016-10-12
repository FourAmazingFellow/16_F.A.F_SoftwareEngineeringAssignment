package businesslogicservice.hotelblservice;

import vo.HotelVO;

public interface MaintainHotelBasicInfoService {
	public HotelVO enrollHotelBasicInfo(String address);
	
	public boolean confirmModify(HotelVO modified);

}
