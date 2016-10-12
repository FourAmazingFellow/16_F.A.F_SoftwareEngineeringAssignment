package dataservice.hotelDAO;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.HotelBriefInfoPO;
import po.HotelPO;

public interface HotelDAO {
	public HotelBriefInfoPO getHotelBriefInfo(String address) throws RemoteException;
	
	public ArrayList<HotelBriefInfoPO> getHotelBriefInfoListBySearching (String[] condition) throws RemoteException;
	
	public ArrayList<HotelBriefInfoPO> getHotelBriefInfoListByQuerying (String[] condition) throws RemoteException;
	
	public HotelPO getHotelDetails(String address) throws RemoteException;
	
	public void update(HotelPO po) throws RemoteException;
	
	public HotelPO find(String address) throws RemoteException;
	
	public void insert(HotelPO po) throws RemoteException;
	
	public void init() throws RemoteException;
	
	public void finish() throws RemoteException;

}
