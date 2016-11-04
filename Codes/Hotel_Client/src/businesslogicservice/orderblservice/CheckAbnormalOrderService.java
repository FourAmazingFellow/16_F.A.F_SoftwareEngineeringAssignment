package businesslogicservice.orderblservice;

import java.util.ArrayList;
import java.util.Date;

import vo.BriefOrderInfoVO;
import vo.OrderVO;

/**
 * 管理异常订单执行情况
 * @author Accident
 * @version 1.0
 * @see
 */
public interface CheckAbnormalOrderService {
	
	/**
	 * 得到异常订单列表
	 * @param date Date型 所要查询的日期
	 * @return 所查询日期当天所有异常订单列表
	 * @see
	 */
	public ArrayList<BriefOrderInfoVO> getAbnormalOrderList (Date date);
	
	/**
	 * 得到订单详细信息
	 * @param orderID 订单号
	 * @return 该订单号对应的OrderVO
	 * @see
	 */
	public OrderVO getDetailedOrder(String orderID);
	
	/**
	 * 网站营销人员撤销订单（系统撤销此异常订单并将其状态置为已撤销、记录撤销时间，并提示选择恢复此客户信用值的全部或一半）
	 * @param vo 要撤销的OrderVO
	 * @return 撤销操作是否成功
	 * @see
	 */
	public boolean systemWithdrawOrder(OrderVO vo, boolean isRecoverHalf); 

}
