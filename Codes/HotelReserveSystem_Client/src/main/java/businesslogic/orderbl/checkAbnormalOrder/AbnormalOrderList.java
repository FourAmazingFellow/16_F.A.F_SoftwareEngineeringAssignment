package businesslogic.orderbl.checkAbnormalOrder;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import businesslogic.utilitybl.POList2VOList;
import dataservice.orderDAO.OrderDAO;
import vo.BriefOrderInfoVO;
import vo.OrderVO;

public class AbnormalOrderList {
	private ArrayList<BriefOrderInfoVO> abnormalOrderList;
	private OrderDAO orderDaoService;
	private POList2VOList poTransformer;
	private OrderVO detailedAbnormalOrder;

	public AbnormalOrderList() {
		poTransformer = new POList2VOList();
	}

	public void setOrderDAO(OrderDAO order) {
		orderDaoService = order;
	}

	public ArrayList<BriefOrderInfoVO> getAbnormalOrderList(Date date) {
		try {
			abnormalOrderList = poTransformer.briefPo2voList(orderDaoService.getAllAbnormalList(date));
		} catch (RemoteException e) {
			// 异常捕捉代码
			e.printStackTrace();
		}
		return abnormalOrderList;
	}

	public OrderVO getDetailedOrder(String orderID) {
		try {
			detailedAbnormalOrder = poTransformer.orderPO2VO(orderDaoService.getDetailedOrder(orderID));
		} catch (RemoteException e) {
			// 异常捕捉代码
			e.printStackTrace();
		}

		// 检查该订单号对应的订单是不是异常订单 - Codes

		return detailedAbnormalOrder;
	}
}
