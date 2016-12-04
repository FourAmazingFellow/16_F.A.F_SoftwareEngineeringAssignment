package businesslogic.hotelbl.checkOrderedHotel;

import java.rmi.RemoteException;

import dataservice.hotelDAO.HotelDAO;
import rmi.RemoteHelper;
import vo.BriefHotelInfoVO;

public class OrderedHotelItem {
	private HotelDAO hotelDAO;
	private String hotelAddress;
	
	public void setHotelDAO(HotelDAO hotelDAO) {
		this.hotelDAO = hotelDAO;
	}
	
	public OrderedHotelItem(String hotelAddress) {
		this.hotelAddress = hotelAddress;
		this.setHotelDAO(RemoteHelper.getInstance().getHotelDAO());
	}
	
	public BriefHotelInfoVO getBriefHotelInfo() {
		try {
			if(hotelDAO.getHotelBriefInfo(hotelAddress) != null) {
				return new BriefHotelInfoVO(hotelDAO.getHotelBriefInfo(hotelAddress));
			}
			else
				return null;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
}
