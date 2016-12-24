package businesslogic.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.roombl.updateCheckOut.AvailableRoomService;
import dataservice.hotelDAO.HotelDAO;
import factory.FactoryService;
import factory.FactoryServiceImpl;
import po.BusinessDistrictPO;
import po.RoomType;
import vo.BriefHotelInfoVO;
import vo.HotelVO;

public class HotelInfoServiceImpl implements HotelInfoService, AvailableRoomService {

	private HotelDAO hotelDAO;
	
	private FactoryService factory;
	
	public void setHotelDAO(HotelDAO hotelDAO) {
		this.hotelDAO = hotelDAO;
	}
	
	public HotelInfoServiceImpl() {
		this.factory = new FactoryServiceImpl();
		this.setHotelDAO(factory.getHotelDAO());
	}
	
	@Override
	public BriefHotelInfoVO getHotelBriefInfo(String address) throws RemoteException {
		if(hotelDAO.getHotelBriefInfo(address) != null) {
			return new BriefHotelInfoVO(hotelDAO.getHotelBriefInfo(address));
		}
		else {
			return null;
		}
	}

	@Override
	public HotelVO getHotelDetails(String address) throws RemoteException {
		if(hotelDAO.getHotelDetails(address) != null) {
			return new HotelVO(hotelDAO.getHotelDetails(address));
		}
		else {
			return null;
		}
	}

    @Override
    public ArrayList<BusinessDistrictPO> getBusinessDistrictList(String city) throws RemoteException {
    	return hotelDAO.getBusinessDistrictList(city);

    }

	@Override
	public int getRoomPrice(String hotelAddress, RoomType roomType) throws RemoteException {
		return hotelDAO.getHotelDetails(hotelAddress).getRoomTypeAndPrice().get(roomType);

	}

}
