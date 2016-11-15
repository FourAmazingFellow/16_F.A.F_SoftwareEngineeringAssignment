package businesslogic.hotelbl.searchHotel;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data_Stub.HotelDAOImpl_Stub;
import dataservice.hotelDAO.HotelDAO;
import po.BriefHotelInfoPO;
import vo.BriefHotelInfoVO;

public class MockSearchHotelServiceImpl extends SearchHotelServiceImpl {
	
	private HotelDAO hotelDAO;
	private ArrayList<BriefHotelInfoPO> hotelList;
	private String[] conditions;
	
	public MockSearchHotelServiceImpl(String[] condition) {
		super(condition);
		this.conditions = condition;
		this.hotelDAO = new HotelDAOImpl_Stub("金陵大酒店", "新街口", "江苏省南京市栖霞区仙林大道163号", 5, 5.0f);
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