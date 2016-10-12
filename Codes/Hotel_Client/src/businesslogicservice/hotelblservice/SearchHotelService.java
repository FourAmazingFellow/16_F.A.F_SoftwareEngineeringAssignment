package businesslogicservice.hotelblservice;

import java.util.ArrayList;

import vo.HotelBriefInfoVO;

public interface SearchHotelService {
	public ArrayList<HotelBriefInfoVO> getHotelBriefInfoListBySearching (String[] condition);

}
