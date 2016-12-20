package businesslogic.hotelbl.maintainHotelBasicInfo;

import java.rmi.RemoteException;

import businesslogicservice.hotelblservice.MaintainHotelBasicInfoService;
import dataservice.hotelDAO.HotelDAO;
import factory.FactoryService;
import factory.FactoryServiceImpl;
import po.HotelPO;
import vo.HotelVO;

public class MaintainHotelBasicInfoServiceImpl implements MaintainHotelBasicInfoService{

	private HotelDAO hotelDAO;
	private HotelVO hotelVO;
	private String hotelAddress;
	
	private FactoryService factory;
	
	public void setHotelDAO(HotelDAO hotelDAO) {
		this.hotelDAO = hotelDAO;
	}
	
	public MaintainHotelBasicInfoServiceImpl(String hotelAddress) throws RemoteException {
		this.hotelAddress = hotelAddress;
		this.factory = new FactoryServiceImpl();
		this.setHotelDAO(factory.getHotelDAO());
		this.hotelVO = new HotelVO(hotelDAO.getHotelDetails(this.hotelAddress));
	}
	
	@Override
	public HotelVO enrollHotelBasicInfo(String address) {
		return hotelVO;
	}

	@Override
	public boolean confirmModify(HotelVO modified) throws RemoteException {
		hotelDAO.updateHotel(new HotelPO(modified));
		return true;
	}
	
}
