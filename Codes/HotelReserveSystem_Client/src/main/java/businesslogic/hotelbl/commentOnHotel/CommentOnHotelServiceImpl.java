package businesslogic.hotelbl.commentOnHotel;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.hotelbl.OrderInfo;
import businesslogicservice.hotelblservice.CommentOnHotelService;
import dataservice.hotelDAO.HotelDAO;
import factory.FactoryService;
import factory.FactoryServiceImpl;
import po.HotelPO;
import vo.OrderVO;

public class CommentOnHotelServiceImpl implements CommentOnHotelService {

	private CommentableOrderList commentableOrderList;
	private HotelDAO hotelDAO;
	private OrderInfo orderInfo;
	private FactoryService factory;

	public CommentOnHotelServiceImpl() {
		this.factory = new FactoryServiceImpl();
		this.hotelDAO = factory.getHotelDAO();
		this.orderInfo = factory.createOrderInfo();
	}

	@Override
	public ArrayList<OrderVO> getCommentableOrderList(String userID) throws RemoteException {
		commentableOrderList = new CommentableOrderList(userID);
		return commentableOrderList.getCommentableOrderList();
	}

	@Override
	public boolean confirmComment(String username, float mark, String comment, String hotelAddress, String orderID)
			throws RemoteException {
		HotelPO hotelPO = hotelDAO.getHotelDetails(hotelAddress);
		
		//根据原来酒店已有的评分以及评分的人数，结合这一次的评分，计算出酒店现在的评分
		int numsOfBeforeComments = hotelPO.getComments().size();
		float nowMark = (numsOfBeforeComments * hotelPO.getMark() + mark) / (numsOfBeforeComments + 1);
		hotelPO.setMark(nowMark);
		
		//将这一次的评论添加进酒店的评论中
		hotelPO.getComments().put(username, comment);
		
		//更新修改过后的酒店信息
		hotelDAO.updateHotel(hotelPO);
		
		//将该订单置为已评价的状态
		return orderInfo.setOrderCommented(orderID);
	}

}
