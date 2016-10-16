package businesslogicservice.orderblservice;

import vo.OrderVO;

/**
 * 生成订单服务
 * @author Accident
 * @version 1.0
 * @see
 */
public interface CreateNewOrderService {
	/**
	 * 初始化新订单
	 * @param ID long型 客户ID
	 * @param address String型 酒店地址
	 * @return 被初始化的OrderVO
	 * @see
	 */
	public OrderVO initNewOrder(long ID, String address);
	
	/**
	 * 获取订单总价
	 * @param vo 订单VO
	 * @return 订单总价
	 * @see
	 */
	public int getPrice(OrderVO vo); 
	
	/**
	 * 检查订单可否被满足
	 * @param vo 订单VO
	 * @return ResultMessage
	 * @see
	 */
	public ResultMessage checkNewOrder(OrderVO vo);
	
	/**
	 * 添加新的订单
	 * @param vo 订单VO
	 * @return boolean
	 * @see
	 */
	public boolean addNewOrder(OrderVO vo);
}
