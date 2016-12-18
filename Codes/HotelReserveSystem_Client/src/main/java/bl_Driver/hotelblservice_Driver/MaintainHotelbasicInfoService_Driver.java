package bl_Driver.hotelblservice_Driver;

import java.rmi.RemoteException;

import businesslogicservice.hotelblservice.MaintainHotelBasicInfoService;
import vo.HotelVO;

public class MaintainHotelbasicInfoService_Driver {
	public void drive(MaintainHotelBasicInfoService maintainHotelBasicInfoService) throws RemoteException {
		HotelVO hotel = maintainHotelBasicInfoService.enrollHotelBasicInfo("江苏省南京市栖霞区仙林大道163号");
		System.out.println(hotel.hotelName + "的基本信息已经显示！\n");
		
		hotel.hotelName = "Jingling Hotel";
		boolean result = maintainHotelBasicInfoService.confirmModify(hotel);
		if(result)
			System.out.println("Modify Succeed!\n");
		else
			System.out.println("Modify Failed!\n");
	}
}
