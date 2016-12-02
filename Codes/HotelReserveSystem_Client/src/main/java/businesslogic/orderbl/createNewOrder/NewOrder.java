package businesslogic.orderbl.createNewOrder;

import java.rmi.RemoteException;
import java.util.Date;

import businesslogic.strategybl.StrategyInfoService;
import businesslogic.utilitybl.VO2PO;
import dataservice.orderDAO.OrderDAO;
import po.OrderPO;
import po.OrderState;
import vo.OrderVO;

public class NewOrder {
	private OrderDAO orderDao;
	private StrategyInfoService strategyInfoService;
	private VO2PO voTransformer;

	public void setOrderDAO(OrderDAO orderDAO, StrategyInfoService s){
		this.orderDao = orderDAO;
		this.strategyInfoService = s;
		this.voTransformer = new VO2PO();
	}
	
	public OrderVO initNewOrder(String userID, String hotelName, String hotelAddress) {
		OrderVO newOrderVO = new OrderVO(userID, null, hotelName, hotelAddress, 
				null, null, null,
				-1, -1, OrderState.NOT_DONE_ORDER, null, null, -1, 
				false, false, false);
		return newOrderVO;
	}
	
	public int getPrice(OrderVO vo) {
		// Codes 用到strategyInfoService,orderDao 并将VO中是否被打过折属性重置
		double discount = -1;
		discount = strategyInfoService.getBestDiscount(vo)/100;
		
		return (int)(vo.totalPrice * discount);
	}

	public boolean addNewOrder(OrderVO vo) {
		OrderPO newOrderPO = voTransformer.orderVO2PO(vo);
		newOrderPO.setOrderProducedTime(new Date());
		try {
			 if(orderDao.insertOrder(newOrderPO))
				 return true;
			 else {
				return false;
			}
		} catch (RemoteException e) {
			//异常捕捉代码
			e.printStackTrace();
			return false;
		}
	}
}
