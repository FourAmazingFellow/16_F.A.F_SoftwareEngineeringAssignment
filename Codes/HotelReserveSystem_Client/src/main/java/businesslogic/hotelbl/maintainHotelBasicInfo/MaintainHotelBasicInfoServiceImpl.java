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
	
	public MaintainHotelBasicInfoServiceImpl(){
		this.factory = new FactoryServiceImpl();
		this.setHotelDAO(factory.getHotelDAO());
	}
	
	@Override
	public HotelVO enrollHotelBasicInfo(String address) throws RemoteException {
		this.hotelAddress = address;
		this.hotelVO = new HotelVO(hotelDAO.getHotelDetails(this.hotelAddress));
		return hotelVO;
	}

	@Override
	public boolean confirmModify(HotelVO modified) throws RemoteException {
		hotelDAO.updateHotel(new HotelPO(modified));
		return true;
	}
	
}
