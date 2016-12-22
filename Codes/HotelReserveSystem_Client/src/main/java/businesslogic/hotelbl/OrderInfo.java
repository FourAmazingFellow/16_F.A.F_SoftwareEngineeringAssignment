package businesslogic.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.BriefOrderInfoVO;
import vo.OrderVO;

/**
 * 给Hotel调用的Order接口
 * @author 原
 * @version 1.2
 * @see
 */
public interface OrderInfo {
	
	/**
	 * 得到某用户所有订单的列表
	 * @param ID long型 用户ID
	 * @return 该用户所有订单的OrderVO的组成的ArrayList
	 * @throws RemoteException 
	 * @see
	 */
	public ArrayList<OrderVO> getAllOrders(String userID) throws RemoteException;
	
	/**
	 * 返回某酒店是否被某用户预定过
	 * @param ID long型 用户ID
	 * @param address String型 酒店地址
	 * @return 该酒店是否被该用户预定过
	 * @throws RemoteException 
	 * @see
	 */
	public boolean isReserved(String userID, String address) throws RemoteException;

	/**
	 * 得到某用户所有可评价订单的列表
	 * @param ID long型 用户ID
	 * @return 该用户所有可评价的订单OrderVO的ArrayList
	 * @throws RemoteException 
	 * @see
	 */
	public ArrayList<OrderVO> getCommentableOrderList (String userID) throws RemoteException;

	/**
	 * 得到某用户在某酒店所有订单的列表
	 * @param ID long型 用户ID
	 * @param address String型 酒店地址
	 * @return 该用户在该酒店的所有订单OrderVO的ArrayList
	 * @throws RemoteException 
	 * @see
	 */
	public ArrayList<OrderVO> getOrderList(String userID, String address) throws RemoteException;

	/**
	 * 得到某用户的所有已执行、已撤销和异常订单
	 * @param userID String型 用户ID
	 * @return 该用户的所有已执行、已撤销和异常订单列表
	 * @throws RemoteException 
	 * @see
	 */
	public ArrayList<BriefOrderInfoVO> getReservedOrderList(String userID) throws RemoteException;
	
	/**
	 * 将对应的订单置为已评价订单
	 * @param orderID
	 * @return 若置成功则返回true，反之则返回false
	 * @throws RemoteException
	 * @see
	 */
	public boolean setOrderCommented(String orderID) throws RemoteException;
	
}
