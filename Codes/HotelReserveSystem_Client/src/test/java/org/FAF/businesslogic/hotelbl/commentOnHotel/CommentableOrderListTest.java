package org.FAF.businesslogic.hotelbl.commentOnHotel;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import businesslogic.hotelbl.OrderInfo;
import businesslogic.hotelbl.commentOnHotel.CommentableOrderList;
import businesslogic.orderbl.OrderInfoImpl;
import vo.OrderVO;

public class CommentableOrderListTest {

	private CommentableOrderList commentableOrderList;
	private OrderInfo orderInfo;
	@Before
	public void setUp() throws Exception {
		orderInfo = new OrderInfoImpl();
	}

	@Test
	public void testGetCommentableOrderList() {
		commentableOrderList = new CommentableOrderList("原");
		commentableOrderList.setOrderInfo(orderInfo);
		ArrayList<OrderVO> orderVOs = commentableOrderList.getCommentableOrderList();
		fail("Not yet implemented");
	}

}
