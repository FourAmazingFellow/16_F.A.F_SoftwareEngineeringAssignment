package businesslogic.orderbl.createNewOrder;

import java.rmi.RemoteException;
import java.util.Date;

import businesslogic.strategybl.StrategyInfoService;
import businesslogic.utilitybl.VO2PO;
import dataservice.orderDAO.OrderDAO;
import po.OrderPO;
import po.OrderState;
import po.RoomType;
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
	
	public OrderVO initNewOrder(String userID, String address) {
		// orderVO的构造函数以后添加,现在为暂时的Mock
		@SuppressWarnings("deprecation")
		OrderVO newOrderVO = new OrderVO(userID, "0001000100010001", "汉庭酒店", address, 
				new Date(2016, 12, 20), new Date(2016, 12, 21), RoomType.STANDARD_ROOM,
				1, 200, OrderState.NOT_DONE_ORDER, new Date(2016, 12, 15, 18, 0), new Date(2016, 12, 20, 22, 0), 2, 
				false, false, false);
		return newOrderVO;
	}
	
	public int getPrice(OrderVO vo) {
		int price = 200;
		// Codes 用到strategyInfoService,orderDao 并将VO中是否被打过折属性重置
		return price;
	}

	public boolean addNewOrder(OrderVO vo) {
//		OrderPO newOrderPO = voTransformer.orderVO2PO(vo);
		boolean result = true;
//		try {
//			 result = orderDao.insert(newOrderPO);
//		} catch (RemoteException e) {
//			//异常捕捉代码
//			e.printStackTrace();
//		}
		return result;
	}
}
