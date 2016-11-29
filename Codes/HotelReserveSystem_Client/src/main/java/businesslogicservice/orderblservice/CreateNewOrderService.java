package businesslogicservice.orderblservice;


import java.util.Date;

import po.RoomType;
import vo.BriefHotelInfoVO;
import vo.OrderVO;

/**
 * 为生成订单界面提供所需要的所有服务
 * @author Accident
 * @version 1.0
 * @see
 */
public interface CreateNewOrderService {
	
	/**
	 * 获取该酒店简要信息 (调用HotelInfoService)
	 * @param address String型， 同层调用传来的酒店地址
	 * @return 返回该酒店简要信息
	 * @see
	 */
	public BriefHotelInfoVO getHotelBriefInfo(String address);
	
	/**
	 * 初始化新订单(需要查询信用值是否>0)
	 * @param userID String型 客户ID
	 * @param address String型 酒店地址
	 * @return 被初始化的OrderVO 若用户信用值<0,则返回null
	 * @see
	 */
	public OrderVO initNewOrder(String userID, String address);
	
	/**
	 * 得到所有房型的RoomVO (调用RoomInfoService)
	 * @param address String型 酒店地址
	 * @param roomType RoomType枚举类型
	 * @return 所有房型的RoomVO的ArrayList
	 * @see
	 */
	 public int getAvailableRoomNum(String address, Enum<RoomType> roomType, Date day);
	
	/**
	 * 获取订单总价
	 * @param vo 订单VO
	 * @return 订单总价
	 * @see
	 */
	public int getPrice(OrderVO vo); 
	
	/**
	 * 检查订单可否被满足,及是否所需拥有全部信息
	 * @param vo 订单VO
	 * @return ResultMessage
	 * @see
	 */
	public ResultMessage checkNewOrder(OrderVO vo);
	
	/**
	 * 添加新的订单
	 * @param vo 订单VO
	 * @return boolean 是否生成成功
	 * @see
	 */
	public boolean addNewOrder(OrderVO vo);
}
