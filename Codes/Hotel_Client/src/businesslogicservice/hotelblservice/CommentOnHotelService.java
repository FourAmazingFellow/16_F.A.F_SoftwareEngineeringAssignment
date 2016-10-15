package businesslogicservice.hotelblservice;

import java.util.ArrayList;

import vo.OrderVO;

/**
 * 
 * @author 原
 * @version 1.0
 * @see
 */
public interface CommentOnHotelService {
	
	/**
	 * 获取用户可以评价的酒店对应的已执行订单列表
	 * @param ID long型，界面传递过来的用户标识
	 * @return 返回用户可以评价的酒店对应的已执行订单列表
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
	/**
	 * 确认评价酒店
	 * @param username String型，界面传递来的客户名称
	 * @param mark int型，界面传递来的客户对酒店的评分
	 * @param comment String型，界面传递来的客户对酒店的评价
	 * @return 评价成功返回true，评价失败返回false
	 * @see
	 */
	public boolean confirmComment(String username, int mark, String comment);

}
