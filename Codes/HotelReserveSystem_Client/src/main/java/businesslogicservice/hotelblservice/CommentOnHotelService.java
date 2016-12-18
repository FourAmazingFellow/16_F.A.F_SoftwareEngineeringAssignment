package businesslogicservice.hotelblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.OrderVO;

/**
 * 为界面提供评价酒店的方法
 * @author 原
 * @version 1.0
 * @see
 */
public interface CommentOnHotelService {
	
	/**
	 * 获取用户可以评价的酒店对应的已执行订单列表
	 * @param userID String型，界面传递过来的用户标识
	 * @return 返回用户可以评价的酒店对应的已执行订单列表
	 * @throws RemoteException 
	 * @see
	 */
	public ArrayList<OrderVO> getCommentableOrderList(String userID) throws RemoteException;
	
	
	/**
	 * 确认评价酒店
	 * @param username String型，界面传递来的客户名称
	 * @param mark int型，界面传递来的客户对酒店的评分
	 * @param comment String型，界面传递来的客户对酒店的评价
	 * @param hotelAddress String型，界面传递来的所评价的酒店地址
	 * @return 评价成功返回true，评价失败返回false
	 * @throws RemoteException 
	 * @see
	 */
	public boolean confirmComment(String username, float mark, String comment, String hotelAddress) throws RemoteException;

}
