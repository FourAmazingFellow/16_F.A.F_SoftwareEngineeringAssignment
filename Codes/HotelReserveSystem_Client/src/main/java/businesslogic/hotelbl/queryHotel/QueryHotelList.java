package businesslogic.hotelbl.queryHotel;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.hotelDAO.HotelDAO;
import factory.FactoryService;
import factory.FactoryServiceImpl;
import po.BriefHotelInfoPO;
import po.BriefOrderInfoPO;

public class QueryHotelList {
	private HotelDAO hotelDAO;
	
	private FactoryService factory;
	
	public QueryHotelList() {
		this.factory = new FactoryServiceImpl();
		this.hotelDAO = factory.getHotelDAO();
	}
	
	public ArrayList<BriefHotelInfoPO> getHotelBriefInfoListByQuerying(String[] condition, ArrayList<BriefOrderInfoPO> orderedHotelList) throws RemoteException {
		ArrayList<BriefHotelInfoPO> orderedHotelInfoPOs = hotelDAO.getHotelBriefInfoListByQuerying(condition, orderedHotelList);
		return orderedHotelInfoPOs;
	}
	
	
	
}
