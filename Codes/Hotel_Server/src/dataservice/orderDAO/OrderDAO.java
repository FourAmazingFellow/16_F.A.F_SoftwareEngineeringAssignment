package dataservice.orderDAO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import po.BriefOrderInfoPO;
import po.OrderPO;
import po.OrderType;

/**
 * 为业务逻辑层提供所需要的订单数据
 * @author Accident
 * @version 1.0
 * @see
 */
public interface OrderDAO {

	/**
	 * 得到客户所有订单VO（Hotel）
	 * @param ID long类型 用户ID
	 * @return 用户所有订单PO
	 * @throws RemoteException
	 * @see
	 */
	public ArrayList<OrderPO> getUserAllOrders(String userID) throws RemoteException;
	
	/**
	 * 得到客户可评价的订单PO列表（Hotel）
	 * @param ID long类型 用户ID
	 * @return 用户可评价的订单列表（OrderPO）
	 * @throws RemoteException
	 * @see
	 */
	public ArrayList<OrderPO> getCommentableOrders (String userID) throws RemoteException;
	
	/**
	 * 判断该客户是否预定过该酒店（Hotel）
	 * @param ID long类型 用户ID
	 * @param address String类型 酒店地址
	 * @return boolean 该客户是否预定过该酒店
	 * @throws RemoteException
	 * @see
	 */
	public boolean isReserved(String userID, String address) throws RemoteException;
	
	/**
	 * 得到该用户在该酒店的所有订单OrderPO的ArrayList
	 * @param ID long类型 用户ID
	 * @param address String类型 酒店地址
	 * @return 该用户在该酒店的所有订单OrderPO的ArrayList
	 * @throws RemoteException
	 * @see
	 */
	public ArrayList<OrderPO> getUserOrdersByHotel (String userID, String address) throws RemoteException;

	/**
	 * 得到客户订单列表（简要信息）
	 * @param ID long类型 用户ID
	 * @param orderType 枚举类型
	 * @return 客户订单列表（简要信息）
	 * @throws RemoteException
	 * @see
	 */
	public ArrayList<BriefOrderInfoPO> getUserOrderList(String userID, Enum<OrderType> orderType) throws RemoteException;
	
	/**
	 * 得到酒店所有订单列表（简要信息）
	 * @param address String类型 酒店地址
	 * @param orderType 枚举类型
	 * @return 酒店所有订单的列表（简要信息）
	 * @throws RemoteException
	 * @see
	 */
	public ArrayList<BriefOrderInfoPO> getHotelOrderList(String address, Enum<OrderType> orderType) throws RemoteException;
	
	/**
	 * 得到所有异常订单的列表
	 * @param date Date类型 要查询的日期
	 * @return 所查询日期当天所有异常订单的列表
	 * @throws RemoteException
	 * @see
	 */
	public ArrayList<BriefOrderInfoPO> getAllAbnormalList (Date date) throws RemoteException;
	
	/**
	 * 得到对应酒店该订单号对应的详情（检测该订单是否属于该酒店）(防止通过订单号直接搜索时出现信息泄漏)
	 * @param address String类型 酒店地址
	 * @param orderID String类型 订单号
	 * @return 该酒店中该订单号对应的详情
	 * @throws RemoteException
	 * @see
	 */
	public OrderPO getSingleOrder(String address, String orderID) throws RemoteException;
	
	/**
	 * 用户得到订单详情时所需调用的方法
	 * @param orderID String类型 订单号
	 * @return 该订单号对应的订单详情
	 * @throws RemoteException
	 * @see
	 */
	public OrderPO getDetailedOrder(String orderID) throws RemoteException;
	
	/**
	 * 在数据库中增加一个po记录
	 * @param po OrderPO类型 要插入的PO
	 * @throws RemoteException
	 * @see
	 */
	public boolean insert(OrderPO po) throws RemoteException;
	
	/**
	 * 在数据库中删除一个po
	 * @param po OrderPO类型 要插入的PO
	 * @throws RemoteException
	 * @see
	 */
	public boolean delete(OrderPO po) throws RemoteException;
	
	/**
	 * 在数据库中更新一个po
	 * @param po OrderPO类型 要插入的PO
	 * @throws RemoteException
	 * @see
	 */
	public boolean update(OrderPO po) throws RemoteException;
	
	/**
	 * 结束持久化数据库的使用
	 * @throws RemoteException
	 * @see
	 */
	public boolean finish() throws RemoteException;
}
