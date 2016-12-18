package businesslogicservice.hotelblservice;

import java.rmi.RemoteException;

import vo.HotelStaffInfoVO;
import vo.HotelVO;

/**
 * 为界面提供管理酒店信息的方法
 * @author 原
 * @version 1.0
 * @see
 */
public interface ManageHotelInfoService {

	
	public HotelVO getHotelInfo(String hotelAddress) throws RemoteException;
	/**
	 * 添加酒店
	 * @param hotel HotelVO型，界面传递来的酒店信息
	 * @return 添加酒店成功返回true，添加酒店失败返回false
	 * @throws RemoteException 
	 * @see 
	 */
	public boolean addHotel(HotelVO hotel) throws RemoteException;
	
	/**
	 * 添加酒店工作人员
	 * @param staff UserVO型，界面传递来的员工信息
	 * @return 添加酒店工作人员成功返回true，添加酒店工作人员失败返回false
	 * @see
	 */
	public boolean addHotelStaff(HotelStaffInfoVO staff);

}
