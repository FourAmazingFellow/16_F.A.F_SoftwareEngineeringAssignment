package bl_Driver.hotelblservice_Driver;

import java.util.ArrayList;

import businesslogicservice.hotelblservice.CheckOrderedHotelService;
import vo.BriefHotelInfoVO;

public class CheckOrderedHotelService_Driver {
	public void drive(CheckOrderedHotelService checkOrderedHotelService) {
		ArrayList<BriefHotelInfoVO> briefHotelInfoVOList = checkOrderedHotelService.enrollHotelBreifInfoList("原");
		if(briefHotelInfoVOList.isEmpty())
			System.out.println("No such hotels!\n");
		else
			System.out.println("There are " + briefHotelInfoVOList.size() + " such hotels!\n");
	}
}
