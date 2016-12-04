package businesslogic.orderbl.createNewOrder;

import java.rmi.RemoteException;
import java.util.Date;

import businesslogic.strategybl.StrategyInfoService;
import businesslogic.utilitybl.VO2PO;
import dataservice.orderDAO.OrderDAO;
import factory.FactoryService;
import factory.FactoryServiceImpl;
import po.OrderPO;
import po.OrderState;
import rmi.RemoteHelper;
import vo.OrderVO;

public class NewOrder {
	private OrderDAO orderDao;
	private StrategyInfoService strategyInfoService;
	private VO2PO voTransformer;

	private FactoryService factory;
	
	public NewOrder() {
		factory = new FactoryServiceImpl();
		orderDao = RemoteHelper.getInstance().getOrderDAO();
		strategyInfoService = factory.createStrategyInfoService();
		voTransformer = new VO2PO();	
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
		discount = strategyInfoService.getBestDiscount(vo);
		
//		if(Math.abs(discount - 1) > 0.01) 界面层可能用到的代码
		
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
