package businesslogic.hotelbl.manageHotelInfo;

import java.rmi.RemoteException;

import businesslogic.userbl.UserInfo;
import businesslogicservice.hotelblservice.ManageHotelInfoService;
import dataservice.hotelDAO.HotelDAO;
import factory.FactoryService;
import factory.FactoryServiceImpl;
import po.HotelPO;
import rmi.RemoteHelper;
import vo.HotelStaffInfoVO;
import vo.HotelVO;

public class ManageHotelInfoServiceImpl implements ManageHotelInfoService {

	private HotelDAO hotelDAO;
	private UserInfo userService;
	
	private FactoryService factory;
	
	public void setHotelDAO(HotelDAO hotelDAO) {
		this.hotelDAO = hotelDAO;
	}
	
	
	public ManageHotelInfoServiceImpl() {
		this.setHotelDAO(RemoteHelper.getInstance().getHotelDAO());
		this.factory = new FactoryServiceImpl();
		this.userService = factory.createUserInfo();
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
	public boolean addHotelStaff(HotelStaffInfoVO staff) {
		return userService.insert(staff);
	}


	@Override
	public HotelVO getHotelInfo(String hotelAddress) {
		try {
			return new HotelVO(hotelDAO.getHotelDetails(hotelAddress));
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	

}
