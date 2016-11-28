package dataservice.hotelDAO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.BriefHotelInfoPO;
import po.BriefOrderInfoPO;
import po.BusinessDistrictPO;
import po.HotelPO;

/**
 * 为业务逻辑层提供所需要的酒店数据
 * @author 原
 * @version 1.0
 * @see
 */
public interface HotelDAO extends Remote {
	
	/**
	 * 获取酒店的基本信息
	 * @param address String型，业务逻辑层传递来的酒店地址
	 * @return 返回酒店的基本信息 
	 * @throws RemoteException
	 * @see
	 */
	public BriefHotelInfoPO getHotelBriefInfo(String address) throws RemoteException;
	
	/**
	 * 通过搜索获取酒店基本信息列表
	 * @param condition String[]型，业务逻辑层传递来的搜索条件
	 * @return 返回酒店基本信息列表
	 * @throws RemoteException
	 * @see
	 */
	public ArrayList<BriefHotelInfoPO> getHotelBriefInfoListBySearching (String[] condition) throws RemoteException;
	
	/**
	 * 通过查看获取酒店基本信息列表
	 * @param condition String[]型，业务逻辑层传递来的查看条件
	 * @return 返回酒店基本信息列表
	 * @throws RemoteException
	 * @see
	 */
	public ArrayList<BriefHotelInfoPO> getHotelBriefInfoListByQuerying (String[] condition, ArrayList<BriefOrderInfoPO> orderedHotelList) throws RemoteException;
	
	/**
	 * 获取酒店详情
	 * @param address String型，业务逻辑层传递来的酒店地址
	 * @return 返回酒店详情
	 * @throws RemoteException
	 * @see
	 */
	public HotelPO getHotelDetails(String address) throws RemoteException;
	
	/**
	 * 更新酒店信息
	 * @param po HotelPO型，业务逻辑层传递来的酒店信息
	 * @throws RemoteException
	 * @see
	 */
	public void updateHotel(HotelPO po) throws RemoteException;
	
	/**
	 * 增加新的酒店
	 * @param po HotelPO型，业务逻辑层传递来的酒店信息
	 * @throws RemoteException
	 * @see
	 */
	public void insertHotel(HotelPO po) throws RemoteException;

	/**
	 * 获取所有的商圈的列表
	 * @return所有的商圈的列表
	 * @throws RemoteException
	 * @see
	 */
	public ArrayList<BusinessDistrictPO> getBusinessDistrctList(String city) throws RemoteException;
}
