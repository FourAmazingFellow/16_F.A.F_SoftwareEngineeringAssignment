package businesslogic.hotelbl.queryHotel;

import java.util.ArrayList;

import po.BriefHotelInfoPO;
import po.BriefOrderInfoPO;

public class MockQueryHotelList extends QueryHotelList {

	@Override
	public ArrayList<BriefHotelInfoPO> getHotelBriefInfoListByQuerying(String[] condition,
			ArrayList<BriefOrderInfoPO> orderedHotelList) {
		ArrayList<BriefHotelInfoPO> hotelList = new ArrayList<>();
		BriefHotelInfoPO hotel = new BriefHotelInfoPO(orderedHotelList.get(0).getHotelName(), "新街口", orderedHotelList.get(0).getHotelAddress(), 5, 5.0f, "南京市");
		hotelList.add(hotel);
		return hotelList;
	}
	
	
}
