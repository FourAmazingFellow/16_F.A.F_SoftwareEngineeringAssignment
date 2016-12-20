package businesslogic.orderbl.getOrderDone;

import java.rmi.RemoteException; 

import businesslogic.userbl.ClientCreditInfo;
import businesslogic.utilitybl.VO2PO;
import dataservice.orderDAO.OrderDAO;
import factory.FactoryService;
import factory.FactoryServiceImpl;
import po.ActionType;
import po.OrderPO;
import po.OrderState;
import vo.OrderVO;

public class OrderTerminator {
	private OrderDAO orderDaoService;
	private ClientCreditInfo userCreditService;
	
	private FactoryService factory;
	
	public OrderTerminator(){
		factory = new FactoryServiceImpl();
		orderDaoService = factory.getOrderDAO();
		userCreditService = factory.createClientCreditInfoService();
	}
	
	public boolean getOrderDone(OrderVO vo) throws RemoteException {
		// TODO Codes 将该订单改为已执行状态，然后为该客户增加与订单价值等额的信用值
		if(vo == null)
			return false;
		VO2PO transformer = new VO2PO();
		OrderPO po = transformer.orderVO2PO(vo);
		po.setOrderState(OrderState.DONE_ORDER);
		
		if(orderDaoService.updateOrder(po) && recoverCreditValue(vo.userID, vo.orderID, vo.totalPrice, ActionType.ORDER_DONE))
			return true;
		else
			return false;
	}
	
	public boolean delayCheckIn(OrderVO vo){
		// TODO Codes 将该订单置为已执行订单，恢复扣除的信用值
		if(vo == null)
			return false;
		VO2PO transformer = new VO2PO();
		OrderPO po = transformer.orderVO2PO(vo);
		po.setOrderState(OrderState.DONE_ORDER);
		try {
			if(orderDaoService.updateOrder(po) && recoverCreditValue(vo.userID, vo.orderID, vo.totalPrice, ActionType.ORDER_DONE))
				return true;
			else
				return false;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 
	 * @param userID 用户ID
	 * @param orderID 订单号
	 * @param price 订单价值（等价于信用值）
	 * @param actionType 操作类型
	 * @return 恢复结果
	 * @throws RemoteException 
	 * @see
	 */
	private boolean recoverCreditValue(String userID, String orderID, int price, ActionType actionType) throws RemoteException {
		if (userCreditService.changeCreditValue(userID, price, orderID, actionType))
			return true;
		else
			return false;
	}
}
