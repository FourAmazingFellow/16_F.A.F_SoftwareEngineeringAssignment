package data.hoteldata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.hotelDAO.HotelDAO;
import po.BriefHotelInfoPO;
import po.BriefOrderInfoPO;
import po.HotelPO;

public class HotelDAOImpl implements HotelDAO {

	@Override
	public BriefHotelInfoPO getHotelBriefInfo(String address) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<BriefHotelInfoPO> getHotelBriefInfoListBySearching(String[] condition) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<BriefHotelInfoPO> getHotelBriefInfoListByQuerying(String[] condition,
			ArrayList<BriefOrderInfoPO> orderedHotelList) throws RemoteException {
		return null;
	}

	@Override
	public HotelPO getHotelDetails(String address) throws RemoteException {
		return null;
	}

	@Override
	public void update(HotelPO po) throws RemoteException {

	}

	@Override
	public void insert(HotelPO po) throws RemoteException {

	}

	@Override
	public void init() throws RemoteException {

	}

	@Override
	public void finish() throws RemoteException {

	}

}
