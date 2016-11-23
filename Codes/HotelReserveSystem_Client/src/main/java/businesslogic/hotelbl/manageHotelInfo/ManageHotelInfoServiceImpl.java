package businesslogic.hotelbl.manageHotelInfo;

import java.rmi.RemoteException;

import businesslogic.userbl.UserInfo;
import businesslogicservice.hotelblservice.ManageHotelInfoService;
import dataservice.hotelDAO.HotelDAO;
import po.HotelPO;
import rmi.RemoteHelper;
import vo.HotelVO;
import vo.UserVO;

public class ManageHotelInfoServiceImpl implements ManageHotelInfoService {

	private HotelDAO hotelDAO;
	private UserInfo userService;
	
	public void setHotelDAO(HotelDAO hotelDAO) {
		this.hotelDAO = hotelDAO;
	}
	
	public void setUserService(UserInfo userService) {
		this.userService = userService;
	}
	
	public ManageHotelInfoServiceImpl() {
		this.setHotelDAO(RemoteHelper.getInstance().getHotelDAO());
	}
	
	@Override
	public boolean addHotel(HotelVO hotel) {
		try {
			hotelDAO.insertHotel(new HotelPO(hotel));
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
