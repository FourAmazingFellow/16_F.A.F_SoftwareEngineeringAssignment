package businesslogicservice.orderblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;
import vo.BriefOrderInfoVO;
import vo.OrderVO;

/**
 * 订单执行服务
 * @author Accident
 * @version 1.0
 * @see
 */
public interface GetOrderDoneService {
	
	/**
	 * 得到该酒店的未执行订单OrderVO的ArrayList
	 * @param address String型 酒店地址
	 * @param orderType 订单类型(为ResultMessage.NOT_DONE_ORDER)
	 * @return 该酒店的所有订单OrderVO的ArrayList
	 * @throws RemoteException 
	 * @see
	 */
	public ArrayList<BriefOrderInfoVO> getHotelNotDoneOrderList(String address) throws RemoteException;

	/**
	 * 得到酒店订单详情
	 * @param address String型 酒店地址
	 * @param orderID String
	 * @return 检测订单号是否存在，如果存在，则返回对应订单的VO，否则返回null
	 * @see
	 */
	public OrderVO getSingleOrder(String address, String orderID);
	
	/**
	 * 执行订单（更新当前订单状态为已执行订单，并为客户增加与订单金额等值的信用值）
	 * @param vo OrderVO
	 * @return 是否成功
	 * @throws RemoteException 
	 * @see
	 */
	public boolean getOrderDone(OrderVO vo) throws RemoteException;

	/**
	 * 延迟入住
	 * @param vo OrderVO
	 * @return 是否延迟成功
	 * @see
	 */
	public boolean delayCheckIn(OrderVO vo);
}
