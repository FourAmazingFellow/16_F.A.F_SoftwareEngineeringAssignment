package businesslogic.hotelbl.maintainHotelBasicInfo;

import java.rmi.RemoteException;

import businesslogicservice.hotelblservice.MaintainHotelBasicInfoService;
import dataservice.hotelDAO.HotelDAO;
import po.HotelPO;
import vo.HotelVO;

public class MaintainHotelBasicInfoServiceImpl implements MaintainHotelBasicInfoService{

	HotelDAO hotelDAO;
	HotelVO hotelVO;
	String hotelAddress;
	
	public MaintainHotelBasicInfoServiceImpl(String hotelAddress) {
		this.hotelAddress = hotelAddress;
		try {
			this.hotelVO = new HotelVO(hotelDAO.getHotelDetails(hotelAddress));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public HotelVO enrollHotelBasicInfo(String address) {
		return hotelVO;
	}

	@Override
	public boolean confirmModify(HotelVO modified) {
		try {
			hotelDAO.update(new HotelPO(modified));
			return true;
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
