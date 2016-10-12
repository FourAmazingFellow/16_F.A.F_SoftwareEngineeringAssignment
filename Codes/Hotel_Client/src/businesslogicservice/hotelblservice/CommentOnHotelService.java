package businesslogicservice.hotelblservice;

import java.util.ArrayList;

import vo.OrderVO;

public interface CommentOnHotelService {
	public ArrayList<OrderVO> getCommentableOrderList(long ID);
	
	public boolean confirmComment(int mark, String comment);

}
