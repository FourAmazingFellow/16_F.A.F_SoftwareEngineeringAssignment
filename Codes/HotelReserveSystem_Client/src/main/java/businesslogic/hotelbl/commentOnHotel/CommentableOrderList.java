package businesslogic.hotelbl.commentOnHotel;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.hotelbl.OrderInfo;
import factory.FactoryService;
import factory.FactoryServiceImpl;
import vo.OrderVO;

public class CommentableOrderList {
	private OrderInfo orderInfo;
	private String userID;
	private FactoryService factory;

	public CommentableOrderList(String userID) {
		this.userID = userID;
		this.factory = new FactoryServiceImpl();
		this.orderInfo = factory.createOrderInfo();
	}

	/**
	 * 调用OrderInfo的方法获得该用户可以评价的订单列表
	 * @return 该用户可以评价的订单列表
	 * @throws RemoteException
	 * @see OrderInfo
	 */
	public ArrayList<OrderVO> getCommentableOrderList() throws RemoteException {
		return orderInfo.getCommentableOrderList(userID);
	}
}
