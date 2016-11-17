package businesslogic.hotelbl.commentOnHotel;

import java.util.ArrayList;

import businesslogicservice.hotelblservice.CommentOnHotelService;
import dataservice.hotelDAO.HotelDAO;
import vo.OrderVO;

public class CommentOnHotelServiceImpl implements CommentOnHotelService{

	private CommentableOrderList commentableOrderList;
	private HotelDAO hotelDAO;
	
	@Override
	public ArrayList<OrderVO> getCommentableOrderList(String userID) {
		commentableOrderList = new CommentableOrderList(userID);
		return commentableOrderList.getCommentableOrderList();
	}

	@Override
	public boolean confirmComment(String username, float mark, String comment, String hotelAddress) {
		
		return true;
	}
	
}
