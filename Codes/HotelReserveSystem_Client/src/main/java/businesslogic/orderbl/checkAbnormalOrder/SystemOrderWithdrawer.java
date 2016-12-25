package businesslogic.orderbl.checkAbnormalOrder;

import java.rmi.RemoteException;
import java.util.Date;

import businesslogic.userbl.ClientCreditInfo;
import businesslogic.utilitybl.VO2PO;
import dataservice.orderDAO.OrderDAO;
import factory.FactoryService;
import factory.FactoryServiceImpl;
import po.ActionType;
import po.OrderPO;
import po.OrderState;
import vo.OrderVO;

public class SystemOrderWithdrawer {
	private OrderDAO orderDaoService;
	private ClientCreditInfo userCreditService;
	
	private FactoryService factory;

	public SystemOrderWithdrawer() {
		factory = new FactoryServiceImpl();
		orderDaoService = factory.getOrderDAO();
		userCreditService = factory.createClientCreditInfoService();
	}
	
	/**
	 * 撤销此异常订单并将其状态置为已撤销、记录撤销时间，恢复此客户信用值的全部或一半
	 * @param vo 要撤销的订单VO
	 * @param isRecoverHalfCredit
	 * @return 操作结果
	 * @see
	 */
	public boolean systemWithdrawOrder(OrderVO vo, boolean isRecoverHalfCredit) {
		// 撤销此异常订单并将其状态置为已撤销、记录撤销时间，恢复此客户信用值的全部或一半
		if(vo == null)
			return false;
		if(vo.orderState != OrderState.ABNORMAL_ORDER)
			return false;
		VO2PO transformer = new VO2PO();
		OrderPO po = transformer.orderVO2PO(vo);
		
		po.setOrderState(OrderState.WITHDREW_ORDER);
		po.setLastedOrderDoneTime(new Date());
		
		try {
			if(orderDaoService.updateOrder(po)){
				if(recoverCreditValue(vo.userID, vo.hotelAddress, isRecoverHalfCredit, vo.totalPrice, ActionType.ORDER_RECOVER))
					return true;
				else
					return false;
			}else
				return false;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	// 下面是该类的各种私有方法, 要用到orderDaoService, userCreditService, addSpareRoomService

	/**
	 * 
	 * @param userID 用户ID
	 * @param orderID 订单号
	 * @param isRecoverHalfCredit 要恢复的Record是否是一半
	 * @param price 订单价值（等价于信用值）
	 * @param actionType 操作类型
	 * @return 恢复结果
	 * @throws RemoteException 
	 * @see
	 */
	private boolean recoverCreditValue(String userID, String orderID, boolean isRecoverHalfCredit, int price, ActionType actionType) throws RemoteException {
		if (isRecoverHalfCredit) {
			if (userCreditService.changeCreditValue(userID, price / 2, orderID, actionType))
				return true;
			else
				return false;
		} else {
			if (userCreditService.changeCreditValue(userID, price, orderID, actionType))
				return true;
			else
				return false;
		}
	}
}
