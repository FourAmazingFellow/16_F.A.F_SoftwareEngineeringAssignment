package businesslogic.hotelbl.searchHotel;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.hotelblservice.SearchHotelService;
import data_Stub.HotelDAOImpl_Stub;
import dataservice.hotelDAO.HotelDAO;
import po.BriefHotelInfoPO;
import vo.BriefHotelInfoVO;

public class SearchHotelServiceImpl implements SearchHotelService {

	private HotelDAO hotelDAO;
	private ArrayList<BriefHotelInfoPO> hotelList;
	
	public SearchHotelServiceImpl() {
		this.hotelDAO = new HotelDAOImpl_Stub("Jingling Hotel", "新街口", "江苏省南京市栖霞区仙林大道163号", 5, 5.0f, "南京市");
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
