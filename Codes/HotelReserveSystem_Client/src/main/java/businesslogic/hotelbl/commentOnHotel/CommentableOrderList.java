package businesslogic.hotelbl.commentOnHotel;

import java.util.ArrayList;

import businesslogic.hotelbl.OrderInfo;
import businesslogic.orderbl.MockOrderInfoImpl;
import vo.OrderVO;

public class CommentableOrderList {
	private OrderInfo orderInfo;
	private String userID;
	
	public void setOrderInfo(OrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}
	
	public CommentableOrderList(String userID) {
		this.userID = userID;
		this.setOrderInfo(new MockOrderInfoImpl());
	}
	
	public ArrayList<OrderVO> getCommentableOrderList() {
		return orderInfo.getCommentableOrderList(userID);
	}
}
