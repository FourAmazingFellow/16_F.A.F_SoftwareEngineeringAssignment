package businesslogic.hotelbl.searchHotel;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.hotelblservice.SearchHotelService;
import dataservice.hotelDAO.HotelDAO;
import po.BriefHotelInfoPO;
import vo.BriefHotelInfoVO;

public class SearchHotelServiceImpl implements SearchHotelService {

	HotelDAO hotelDAO;
	ArrayList<BriefHotelInfoPO> hotelList;
	String[] conditions;
	
	public SearchHotelServiceImpl(String[] condition) {
		this.conditions = condition;
		try {
			this.hotelList = hotelDAO.getHotelBriefInfoListBySearching(this.conditions);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public ArrayList<BriefHotelInfoVO> getHotelBriefInfoListBySearching(String[] condition) {
		ArrayList<BriefHotelInfoVO> hotelInfoVOs = new ArrayList<>();
		for(BriefHotelInfoPO hotelInfoPO : hotelList) {
			hotelInfoVOs.add(new BriefHotelInfoVO(hotelInfoPO));
		}
		return hotelInfoVOs;
	}

}
