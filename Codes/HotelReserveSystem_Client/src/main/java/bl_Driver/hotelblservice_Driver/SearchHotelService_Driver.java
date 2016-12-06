package bl_Driver.hotelblservice_Driver;

import java.util.ArrayList;

import businesslogicservice.hotelblservice.SearchHotelService;
import vo.OrderedHotelInfoVO;

public class SearchHotelService_Driver {
	public void driver(SearchHotelService searchHotelService) {
		String[] condition = {"不限", "不限", "不限", "不限", "不限", "不限", "不限", "不限", "否"};
		ArrayList<OrderedHotelInfoVO> briefHotelInfoVOList = searchHotelService.getHotelBriefInfoListBySearching(condition);
		if(briefHotelInfoVOList.isEmpty())
			System.out.println("无满足此条件的酒店！\n");
		else
			System.out.println(briefHotelInfoVOList.size() + "个满足条件的酒店");
	}
}
