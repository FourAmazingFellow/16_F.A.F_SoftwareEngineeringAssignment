package businesslogic.hotelbl.searchHotel;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.hotelblservice.SearchHotelService;
import dataservice.hotelDAO.HotelDAO;
import po.BriefHotelInfoPO;
import rmi.RemoteHelper;
import vo.BriefHotelInfoVO;

public class SearchHotelServiceImpl implements SearchHotelService {

	private HotelDAO hotelDAO;
	private ArrayList<BriefHotelInfoPO> hotelList;
	protected String userID;
	
	public SearchHotelServiceImpl(String userID) {
		this.hotelDAO = RemoteHelper.getInstance().getHotelDAO();
		this.userID = userID;
	}
	
	@Override
	public ArrayList<BriefHotelInfoVO> getHotelBriefInfoListBySearching(String[] condition) {
		try {
			this.hotelList = hotelDAO.getHotelBriefInfoListBySearching(condition);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		ArrayList<BriefHotelInfoVO> hotelInfoVOs = new ArrayList<>();
		for(BriefHotelInfoPO hotelInfoPO : hotelList) {
			hotelInfoVOs.add(new BriefHotelInfoVO(hotelInfoPO));
		}
		return hotelInfoVOs;
	}

}
