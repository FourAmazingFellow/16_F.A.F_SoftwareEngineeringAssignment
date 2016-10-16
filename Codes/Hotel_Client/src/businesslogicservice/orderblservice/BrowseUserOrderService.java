package businesslogicservice.orderblservice;

import java.util.ArrayList;

import po.OrderType;
import vo.BriefOrderInfoVO;
import vo.OrderVO;

/**
 * 查看订单服务
 * @author Accident
 * @version 1.0
 * @see
 */
public interface BrowseUserOrderService {
	
	/**
	 * 得到用户所有订单
	 * @param ID long型 客户ID
	 * @param orderType 订单类型
	 * @return 按orderType的值进行查找并按生成时间顺序排列的订单列表
	 * @see
	 */
	public ArrayList<BriefOrderInfoVO> getUserOrderList (long ID, Enum<OrderType> orderType);
	
	/**
	 * 得到订单详细信息
	 * @param orderID 订单号
	 * @return 该订单号对应的OrderVO
	 * @see
	 */
	public OrderVO getDetailedOrder(String orderID);
}
