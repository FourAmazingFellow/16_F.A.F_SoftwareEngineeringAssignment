package bl_Driver.hotelblservice_Driver;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.hotelblservice.CheckOrderedHotelService;
import vo.OrderedHotelInfoVO;

public class CheckOrderedHotelService_Driver {
	public void drive(CheckOrderedHotelService checkOrderedHotelService) throws RemoteException {
		ArrayList<OrderedHotelInfoVO> orderedHotelInfoVOList = checkOrderedHotelService.enrollHotelBreifInfoList("原");
		if(orderedHotelInfoVOList.isEmpty())
			System.out.println("No such hotels!\n");
		else
			System.out.println("There are " + orderedHotelInfoVOList.size() + " such hotels!\n");
	}
}
