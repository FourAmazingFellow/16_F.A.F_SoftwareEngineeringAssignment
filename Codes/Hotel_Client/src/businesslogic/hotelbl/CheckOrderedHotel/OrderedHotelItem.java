package businesslogic.hotelbl.checkOrderedHotel;

import java.rmi.RemoteException;

import dataservice.hotelDAO.HotelDAO;
import vo.BriefHotelInfoVO;

public class OrderedHotelItem {
	private HotelDAO hotelDAO;
	private String hotelAddress;
	
	public OrderedHotelItem(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}
	
	public BriefHotelInfoVO getbriefHotelInfo() {
		try {
			return new BriefHotelInfoVO(hotelDAO.getHotelBriefInfo(hotelAddress));
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
}
