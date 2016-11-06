package businesslogic.orderbl.createNewOrder;

import java.rmi.RemoteException;

import businesslogic.strategybl.StrategyInfoService;
import businesslogic.utilitybl.VO2PO;
import dataservice.orderDAO.OrderDAO;
import po.OrderPO;
import vo.OrderVO;

public class NewOrder {
	private OrderDAO orderDao;
	private StrategyInfoService strategyInfoService;
	private VO2PO voTransformer;

	public OrderVO initNewOrder(String userID, String address) {
		// orderVO的构造函数以后添加
		OrderVO newOrderVO = null;
		return newOrderVO;
	}

	public int getPrice(OrderVO vo) {
		int price = 0;
		// Codes 用到strategyInfoService,orderDao 并将VO中是否被打过折属性重置
		return price;
	}

	public boolean addNewOrder(OrderVO vo) {
		OrderPO newOrderPO = voTransformer.orderVO2PO(vo);
		boolean result = false;
		try {
			 result = orderDao.insert(newOrderPO);
		} catch (RemoteException e) {
			//异常捕捉代码
			e.printStackTrace();
		}
		return result;
	}
}
