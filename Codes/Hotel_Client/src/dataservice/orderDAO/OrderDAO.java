package dataservice.orderDAO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import po.BriefOrderInfoPO;
import po.OrderPO;
import po.OrderType;

/**
 * 
 * @author Accident
 * @version
 * @see
 */
public interface OrderDAO {
	/**
	 * 
	 * @param ID
	 * @return
	 * @throws RemoteException
	 * @see
	 */
	public ArrayList<OrderPO> getAllOrders(long ID) throws RemoteException;
	/**
	 * 
	 * @param ID
	 * @return
	 * @throws RemoteException
	 * @see
	 */
	public ArrayList<OrderPO> getCommentableOrders (long ID) throws RemoteException;
	/**
	 * 
	 * @param ID
	 * @param address
	 * @return
	 * @throws RemoteException
	 * @see
	 */
	public boolean isReserved(long ID, String address) throws RemoteException;
	/**
	 * 
	 * @param ID
	 * @param orderType
	 * @return
	 * @throws RemoteException
	 * @see
	 */
	public ArrayList<BriefOrderInfoPO> getUserOrderList(long ID, Enum<OrderType> orderType) throws RemoteException;
	/**
	 * 
	 * @param address
	 * @param orderType
	 * @return
	 * @throws RemoteException
	 * @see
	 */
	public ArrayList<BriefOrderInfoPO> getHotelOrderList(String address, Enum<OrderType> orderType) throws RemoteException;
	/**
	 * 
	 * @param date
	 * @return
	 * @throws RemoteException
	 * @see
	 */
	public ArrayList<BriefOrderInfoPO> getAllAbnormalList (Date date) throws RemoteException;
	/**
	 * 
	 * @param address
	 * @param orderID
	 * @return
	 * @throws RemoteException
	 * @see
	 */
	public OrderPO getSingleOrder(String address, String orderID) throws RemoteException;
	/**
	 * 
	 * @param po
	 * @throws RemoteException
	 * @see
	 */
	public void insert(OrderPO po) throws RemoteException;
	/**
	 * 
	 * @param po
	 * @throws RemoteException
	 * @see
	 */
	public void delete(OrderPO po) throws RemoteException;
	/**
	 * 
	 * @param po
	 * @throws RemoteException
	 * @see
	 */
	public void update(OrderPO po) throws RemoteException;
	
	/**
	 * 
	 * @throws RemoteException
	 * @see
	 */
	public void finish() throws RemoteException;

}
