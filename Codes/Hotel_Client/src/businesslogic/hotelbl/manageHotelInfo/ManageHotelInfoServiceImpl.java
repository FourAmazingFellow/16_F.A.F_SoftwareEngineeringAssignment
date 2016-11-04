package businesslogic.hotelbl.manageHotelInfo;

import java.rmi.RemoteException;

import businesslogic.userbl.UserInfo;
import businesslogicservice.hotelblservice.ManageHotelInfoService;
import dataservice.hotelDAO.HotelDAO;
import po.HotelPO;
import vo.HotelVO;
import vo.UserVO;

public class ManageHotelInfoServiceImpl implements ManageHotelInfoService {

	HotelDAO hotelDAO;
	UserInfo userService;
	
	
	@Override
	public boolean addHotel(HotelVO hotel) {
		try {
			hotelDAO.insert(new HotelPO(hotel));
			return true;
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean addHotelStaff(UserVO staff) {
		return userService.insert(staff);
	}
	
	
	

}
