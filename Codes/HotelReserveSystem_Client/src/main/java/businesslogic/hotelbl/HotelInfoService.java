package businesslogic.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.BusinessDistrictPO;
import po.RoomType;
import vo.BriefHotelInfoVO;
import vo.HotelVO;

/**
 * 为同层调用提供酒店信息
 * @author 原
 * @version 1.0
 * @see
 */
public interface HotelInfoService {
	
	/**
	 * 获取该酒店简要信息
	 * @param address String型， 同层调用传来的酒店地址
	 * @return 返回该酒店简要信息
	 * @see
	 */
	public BriefHotelInfoVO getHotelBriefInfo(String address) throws RemoteException;
	
	/**
	 * 获取该酒店详细信息
	 * @param address String型，同层调用传来的酒店地址
	 * @return 返回该酒店详细信息
	 * @see
	 */
	public HotelVO getHotelDetails(String address) throws RemoteException;
	
	/**
	 * 获得商圈列表
	 * @param city String型，同层调用传来的城市名
	 * @return 返回该城市的所有商圈列表
	 * @throws RemoteException
	 * @see
	 */
	public ArrayList<BusinessDistrictPO> getBusinessDistrictList(String city) throws RemoteException;
	
	/**
	 * 获得某个酒店的某个房型的原始价格
	 * @param hotelAddress  同层调用传来的酒店名称
	 * @param roomType 同层调用传来的房间类型
	 * @return 若不存在该房型，则返回-1，若存在，则返回对应的价格
	 * @see
	 */
	public int getRoomPrice(String hotelAddress, RoomType roomType) throws RemoteException;

}
