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
			if(hotelDAO.getHotelBriefInfo(address) != null) {
				return new BriefHotelInfoVO(hotelDAO.getHotelBriefInfo(address));
			}
			else {
				return null;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public HotelVO getHotelDetails(String address) {
		try {
			if(hotelDAO.getHotelDetails(address) != null) {
				return new HotelVO(hotelDAO.getHotelDetails(address));
			}
			else {
				return null;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	

}
