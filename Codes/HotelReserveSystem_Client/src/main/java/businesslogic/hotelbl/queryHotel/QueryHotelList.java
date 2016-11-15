package businesslogic.hotelbl.queryHotel;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import dataservice.hotelDAO.HotelDAO;
import po.BriefHotelInfoPO;
import po.BriefOrderInfoPO;

public class QueryHotelList {
	private HotelDAO hotelDAO;
	
	private Comparator<BriefHotelInfoPO> comparator = new Comparator<BriefHotelInfoPO>(){

		@Override
		public int compare(BriefHotelInfoPO o1, BriefHotelInfoPO o2) {
			return 0;
		}
		
	};
	
	public ArrayList<BriefHotelInfoPO> getHotelBriefInfoListByQuerying(String[] condition, ArrayList<BriefOrderInfoPO> orderedHotelList) {
		ArrayList<BriefHotelInfoPO> orderedHotelInfoVOs;
		try {
			orderedHotelInfoVOs = hotelDAO.getHotelBriefInfoListByQuerying(condition, orderedHotelList);
			Collections.sort(orderedHotelInfoVOs,comparator); 
			return orderedHotelInfoVOs;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
}
