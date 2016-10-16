package businesslogicservice.orderblservice;

import java.util.ArrayList;

import po.OrderType;
import vo.BriefOrderInfoVO;
import vo.OrderVO;

/**
 * 浏览酒店订单
 * @author Accident
 * @version 1.0
 * @see
 */
public interface BrowseHotelOrderService {
	
	/**
	 * 得到该酒店的所有订单OrderVO的ArrayList
	 * @param address String型 酒店地址
	 * @param orderType 订单类型
	 * @return 该酒店的所有订单OrderVO的ArrayList
	 * @see
	 */
	public ArrayList<BriefOrderInfoVO>  getHotelOrderList (String address, Enum<OrderType> orderType);

	/**
	 * 得到酒店订单详情
	 * @param address String型 酒店地址
	 * @param orderID String
	 * @return 检测订单号是否存在，如果存在，则返回对应订单的VO，否则返回null
	 * @see
	 */
	public OrderVO getSingleOrder(String address, String orderID);
}
