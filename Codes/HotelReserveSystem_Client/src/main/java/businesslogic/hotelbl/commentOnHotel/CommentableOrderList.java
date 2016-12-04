package businesslogic.hotelbl.commentOnHotel;

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
	
	public ArrayList<OrderVO> getCommentableOrderList() {
		return orderInfo.getCommentableOrderList(userID);
	}
}
