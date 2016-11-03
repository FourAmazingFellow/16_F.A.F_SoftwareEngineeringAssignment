package businesslogic.hotelbl;

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
	 * @see
	 */
	public ArrayList<OrderVO> getAllOrders(String userID);
	
	/**
	 * 返回某酒店是否被某用户预定过
	 * @param ID long型 用户ID
	 * @param address String型 酒店地址
	 * @return 该酒店是否被该用户预定过
	 * @see
	 */
	public boolean isReserved(String userID, String address);

	/**
	 * 得到某用户所有可评价订单的列表
	 * @param ID long型 用户ID
	 * @return 该用户所有可评价的订单OrderVO的ArrayList
	 * @see
	 */
	public ArrayList<OrderVO> getCommentableOrderList (String userID);

	/**
	 * 得到某用户在某酒店所有订单的列表
	 * @param ID long型 用户ID
	 * @param address String型 酒店地址
	 * @return 该用户在该酒店的所有订单OrderVO的ArrayList
	 * @see
	 */
	public ArrayList<OrderVO> getOrderList(String userID, String address);

	/**
	 * 得到某用户的所有已执行、已撤销和异常订单
	 * @param userID String型 用户ID
	 * @return 该用户的所有已执行、已撤销和异常订单列表
	 * @see
	 */
	public ArrayList<BriefOrderInfoVO> getReservedOrderList(String userID);
	
}
