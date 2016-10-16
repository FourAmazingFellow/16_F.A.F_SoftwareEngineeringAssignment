package businesslogicservice.orderblservice;

import java.util.ArrayList;

import po.OrderType;
import vo.BriefOrderInfoVO;
import vo.OrderVO;

/**
 * 撤销订单服务
 * @author Accident
 * @version 1.0
 * @see
 */
public interface WithdrawOrderService {
	
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
	
	/**
	 * 判断该订单是否可以被撤销
	 * @param vo 订单VO
	 * @return 该订单当前是否可以被撤销
	 * @see
	 */
	public boolean isWithdrawable(OrderVO vo); 

	/**
	 * 判断此次撤销操作是否需要扣除信用值
	 * @param vo 订单VO
	 * @return 此次撤销操作是否需要扣除信用值
	 * @see
	 */
	public boolean isTooLate(OrderVO vo); 

	/**
	 * 撤销订单（（扣除信用值），系统将订单置为撤销状态，记录撤销时间，更新空房列表）
	 * @param vo 订单VO
	 * @return boolean 
	 * @see
	 */
	public boolean withdrawOrder(OrderVO vo); 
}
