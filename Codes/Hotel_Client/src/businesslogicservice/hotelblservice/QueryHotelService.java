package businesslogicservice.hotelblservice;

import java.util.ArrayList;

import vo.BriefHotelInfoVO;
import vo.HotelVO;
import vo.OrderVO;

/**
 * 为界面提供查看酒店信息所需要的方法
 * @author 原
 * @version 1.0
 * @see
 */
public interface QueryHotelService {
	
	/**
	 * 查找符合输入条件的酒店
	 * @param condition String[]型，界面传递来的查看条件
	 * @return 返回符合输入条件的所有酒店的简要信息列表
	 * @see
	 */
	public ArrayList<BriefHotelInfoVO> getHotelBriefInfoListByQuerying (String[] condition);
	
	/**
	 * 获取酒店详细信息
	 * @param address String型，界面传递来的酒店地址
	 * @return 返回酒店详细信息
	 * @see
	 */
	public HotelVO getHotelDetails(String address);
	
	/**
	 * 获取用户在该酒店的所有订单
	 * @param address String型，界面传递来的酒店地址
	 * @param ID long型，界面传递来的用户标识
	 * @return 返回用户在该酒店的所有订单的列表
	 * @see
	 */
	public ArrayList<OrderVO> getOrders(String address, long ID);

}
