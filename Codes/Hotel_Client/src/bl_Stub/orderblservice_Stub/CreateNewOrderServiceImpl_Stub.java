package bl_Stub.orderblservice_Stub;

import java.util.Date;

import businesslogicservice.orderblservice.CreateNewOrderService;
import businesslogicservice.orderblservice.ResultMessage;
import po.OrderState;
import po.RoomType;
import vo.BriefOrderInfoVO;
import vo.OrderVO;

public class CreateNewOrderServiceImpl_Stub implements CreateNewOrderService {
	BriefOrderInfoVO testBriefOrderInfoVO;
	OrderVO testOrderVO;
	ResultMessage resultMessage;
	
	public CreateNewOrderServiceImpl_Stub(long userID, String orID, String hN, String hA, Date bD, Date fD, RoomType rT, int n, int tP,
			Date oPT, Date lODT, int nOP, boolean isChild, boolean isOnSale, OrderState orderS,
			boolean isCom, ResultMessage reM, ResultMessage resultMessage) {
		testBriefOrderInfoVO = new BriefOrderInfoVO(userID, orID, hN, hA, bD, fD, rT, n, tP);
		testOrderVO = new OrderVO(userID, orID, hN, hA, bD, fD, rT, n, tP ,oPT, lODT, nOP, isChild, isOnSale, orderS, isCom);
		this.resultMessage = resultMessage;
	}
	
	@Override
	public OrderVO initNewOrder(String userID, String address) {
		// TODO Auto-generated method stub
		System.out.println("初始化订单");
		return testOrderVO;
	}

	@Override
	public int getPrice(OrderVO vo) {
		// TODO Auto-generated method stub
		System.out.println("得到订单价格");
		return vo.totalPrice;
	}

	@Override
	public ResultMessage checkNewOrder(OrderVO vo) {
		// TODO Auto-generated method stub
		System.out.println("初始化订单");
		return resultMessage;
	}

	@Override
	public boolean addNewOrder(OrderVO vo) {
		// TODO Auto-generated method stub
		System.out.println("添加订单");
		return false;
	}

}
