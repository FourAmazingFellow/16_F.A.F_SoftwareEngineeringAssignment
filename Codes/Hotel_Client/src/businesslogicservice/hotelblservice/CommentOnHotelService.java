package businesslogicservice.hotelblservice;

import java.util.ArrayList;

import vo.OrderVO;

/**
 * 
 * @author 原
 * @version
 */
public interface CommentOnHotelService {
	
	/**
	 * 
	 * @param ID
	 * @return
	 * @see
	 */
	public ArrayList<OrderVO> getCommentableOrderList(long ID);
	
	/**
	 * 
	 * @param mark
	 * @param comment
	 * @return
	 * @see
	 */
	public boolean confirmComment(int mark, String comment);

}
