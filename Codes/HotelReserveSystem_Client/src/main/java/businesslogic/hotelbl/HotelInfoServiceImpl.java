package businesslogic.hotelbl;

import java.rmi.RemoteException;

import dataservice.hotelDAO.HotelDAO;
import rmi.RemoteHelper;
import vo.BriefHotelInfoVO;
import vo.HotelVO;

public class HotelInfoServiceImpl implements HotelInfoService {

	private HotelDAO hotelDAO;
	
	public void setHotelDAO(HotelDAO hotelDAO) {
		this.hotelDAO = hotelDAO;
	}
	
	public HotelInfoServiceImpl() {
		this.setHotelDAO(RemoteHelper.getInstance().getHotelDAO());
	}
	
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
