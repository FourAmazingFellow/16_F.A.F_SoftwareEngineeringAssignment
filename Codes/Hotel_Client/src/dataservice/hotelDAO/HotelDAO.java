package dataservice.hotelDAO;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.HotelBriefInfoPO;
import po.HotelPO;

/**
 * 为业务逻辑层提供所需要的酒店数据
 * @author 原
 * @version 1.0
 * @see
 */
public interface HotelDAO {
	
	/**
	 * 获取酒店的基本信息
	 * @param address String型，业务逻辑层传递来的酒店地址
	 * @return 返回酒店的基本信息 
	 * @throws RemoteException
	 * @see
	 */
	public HotelBriefInfoPO getHotelBriefInfo(String address) throws RemoteException;
	
	/**
	 * 通过搜索获取酒店基本信息列表
	 * @param condition String[]型，业务逻辑层传递来的搜索条件
	 * @return 返回酒店基本信息列表
	 * @throws RemoteException
	 * @see
	 */
	public ArrayList<HotelBriefInfoPO> getHotelBriefInfoListBySearching (String[] condition) throws RemoteException;
	
	/**
	 * 通过查看获取酒店基本信息列表
	 * @param condition String[]型，业务逻辑层传递来的查看条件
	 * @return 返回酒店基本信息列表
	 * @throws RemoteException
	 * @see
	 */
	public ArrayList<HotelBriefInfoPO> getHotelBriefInfoListByQuerying (String[] condition) throws RemoteException;
	
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
	public void update(HotelPO po) throws RemoteException;
	
	/**
	 * 增加新的酒店
	 * @param po HotelPO型，业务逻辑层传递来的酒店信息
	 * @throws RemoteException
	 * @see
	 */
	public void insert(HotelPO po) throws RemoteException;
	
	/**
	 * 初始化持久化数据存储
	 * @throws RemoteException
	 * @see
	 */
	public void init() throws RemoteException;
	
	
	/**
	 * 结束持久化数据存储的使用
	 * @throws RemoteException
	 * @see
	 */
	public void finish() throws RemoteException;

}
