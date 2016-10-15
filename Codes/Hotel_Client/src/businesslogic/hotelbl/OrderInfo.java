package businesslogic.hotelbl;

import java.util.ArrayList;

import vo.OrderVO;

/**
 * 
 * @author Accident
 * @version 1.0
 * @see
 */
public interface OrderInfo {
	
	/**
	 * 得到某用户所有订单的列表
	 * @param ID long型 用户ID
	 * @return 该用户所有订单的OrderVO的组成的ArrayList
	 * @see
	 */
	public ArrayList<OrderVO> getAllOrders(long ID);
	
	/**
	 * 返回某酒店是否被某用户预定过
	 * @param ID long型 用户ID
	 * @param address String型 酒店地址
	 * @return 该酒店是否被该用户预定过
	 * @see
	 */
	public boolean isReserved(long ID, String address);

	/**
	 * 得到某用户所有可评价订单的列表
	 * @param ID long型 用户ID
	 * @return 该用户所有可评价的订单OrderVO的ArrayList
	 * @see
	 */
	public ArrayList<OrderVO> getCommentableOrderList (long ID);

	/**
	 * 得到某用户在某酒店所有订单的列表
	 * @param ID long型 用户ID
	 * @param address String型 酒店地址
	 * @return 得到该用户在该酒店的所有订单OrderVO的ArrayList
	 * @see
	 */
	public ArrayList<OrderVO> getOrderList(long ID, String address);

}
