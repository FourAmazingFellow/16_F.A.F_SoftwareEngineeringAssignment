package businesslogic.hotelbl;

import java.rmi.RemoteException;

import dataservice.hotelDAO.HotelDAO;
import vo.BriefHotelInfoVO;
import vo.HotelVO;

public class HotelInfoServiceImpl implements HotelInfoService {

	private HotelDAO hotelDAO;
	
	@Override
	public BriefHotelInfoVO getHotelBriefInfo(String address) {
		try {
			return new BriefHotelInfoVO(hotelDAO.getHotelBriefInfo(address));
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public HotelVO getHotelDetails(String address) {
		try {
			return new HotelVO(hotelDAO.getHotelDetails(address));
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	

}
