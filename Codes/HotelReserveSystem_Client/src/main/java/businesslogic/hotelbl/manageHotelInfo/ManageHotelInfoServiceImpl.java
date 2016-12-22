package businesslogic.hotelbl.manageHotelInfo;

import java.rmi.RemoteException;

import businesslogic.userbl.UserInfo;
import businesslogicservice.hotelblservice.ManageHotelInfoService;
import dataservice.hotelDAO.HotelDAO;
import factory.FactoryService;
import factory.FactoryServiceImpl;
import po.HotelPO;
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
		this.factory = new FactoryServiceImpl();
		this.setHotelDAO(factory.getHotelDAO());
		this.userService = factory.createUserInfo();
	}
	
	@Override
	public boolean addHotel(HotelVO hotel) throws RemoteException {
		hotelDAO.insertHotel(new HotelPO(hotel));
		return true;
	}
	
	@Override
	public boolean addHotelStaff(HotelStaffInfoVO staff) throws RemoteException {
		return userService.insert(staff);
	}


	@Override
	public HotelVO getHotelInfo(String hotelAddress) throws RemoteException {
		HotelVO hotelVO = null;
		HotelPO hotelPO = hotelDAO.getHotelDetails(hotelAddress);
		if(hotelPO != null)
			hotelVO = new HotelVO(hotelPO);
		else
			hotelVO = null;
		return hotelVO;
	}
	
	
	

}
