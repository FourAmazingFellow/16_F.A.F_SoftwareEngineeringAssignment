package dataservice.hotelDAO;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.HotelBriefInfoPO;
import po.HotelPO;

/**
 * 
 * @author 原
 * @version
 * @see
 */
public interface HotelDAO {
	
	/**
	 * 
	 * @param address
	 * @return
	 * @throws RemoteException
	 * @see
	 */
	public HotelBriefInfoPO getHotelBriefInfo(String address) throws RemoteException;
	
	/**
	 * 
	 * @param condition
	 * @return
	 * @throws RemoteException
	 * @see
	 */
	public ArrayList<HotelBriefInfoPO> getHotelBriefInfoListBySearching (String[] condition) throws RemoteException;
	
	/**
	 * 
	 * @param condition
	 * @return
	 * @throws RemoteException
	 * @see
	 */
	public ArrayList<HotelBriefInfoPO> getHotelBriefInfoListByQuerying (String[] condition) throws RemoteException;
	
	/**
	 * 
	 * @param address
	 * @return
	 * @throws RemoteException
	 * @see
	 */
	public HotelPO getHotelDetails(String address) throws RemoteException;
	
	/**
	 * 
	 * @param po
	 * @throws RemoteException
	 * @see
	 */
	public void update(HotelPO po) throws RemoteException;
	
	/**
	 * 
	 * @param address
	 * @return
	 * @throws RemoteException
	 * @see
	 */
	public HotelPO find(String address) throws RemoteException;
	
	/**
	 * 
	 * @param po
	 * @throws RemoteException
	 * @see
	 */
	public void insert(HotelPO po) throws RemoteException;
	
	/**
	 * 
	 * @throws RemoteException
	 * @see
	 */
	public void init() throws RemoteException;
	
	
	/**
	 * 
	 * @throws RemoteException
	 * @see
	 */
	public void finish() throws RemoteException;

}
