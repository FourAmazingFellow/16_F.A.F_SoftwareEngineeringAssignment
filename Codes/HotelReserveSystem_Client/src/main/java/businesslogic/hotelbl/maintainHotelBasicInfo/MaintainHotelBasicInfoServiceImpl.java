package businesslogic.hotelbl.maintainHotelBasicInfo;

import java.rmi.RemoteException;

import businesslogicservice.hotelblservice.MaintainHotelBasicInfoService;
import dataservice.hotelDAO.HotelDAO;
import po.HotelPO;
import rmi.RemoteHelper;
import vo.HotelVO;

public class MaintainHotelBasicInfoServiceImpl implements MaintainHotelBasicInfoService{

	private HotelDAO hotelDAO;
	private HotelVO hotelVO;
	private String hotelAddress;
	
	public void setHotelDAO(HotelDAO hotelDAO) {
		this.hotelDAO = hotelDAO;
	}
	
	public MaintainHotelBasicInfoServiceImpl(String hotelAddress) {
		this.hotelAddress = hotelAddress;
		this.setHotelDAO(RemoteHelper.getInstance().getHotelDAO());
		try {
			this.hotelVO = new HotelVO(hotelDAO.getHotelDetails(this.hotelAddress));
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
			hotelDAO.updateHotel(new HotelPO(modified));
			return true;
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
