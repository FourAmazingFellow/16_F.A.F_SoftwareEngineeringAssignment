package dataservice.userDAO;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.ClientInfoPO;
import po.HotelStaffInfoPO;
import po.UserPO;
import po.UserType;
/**
 * 为业务逻辑层提供所需要的用户数据
 * @author sparkler
 * @version 
 * @see
 */
public interface UserDAO extends Remote {
    
    /**
     * 查询用户信息
     * @param ID long型，业务逻辑层传递来的用户账号
     * @param UserType Enum<UserType>型，业务逻辑层传递来的用户类型
     * @return 返回用户信息
     * @throws RemoteException
     * @see
     */
    public UserPO getUserInfo(String userID, UserType UserType) throws RemoteException;
    
    /**
    * 查询信用记录
     * @param ID long型，业务逻辑层传递过来的用户标识
     * @return 返回用户的信用记录
     * @throws RemoteException
     * @see
     */
    public ClientInfoPO queryCreditRecord(String userID) throws RemoteException;
    
    /**
      * 获取客户的信用值
     * @param ID long型，业务逻辑层传递过来的用户标识
     * @return 返回客户当前信用值
     * @throws RemoteException
     * @see
     */
    public int getCreditValue(String userID) throws RemoteException;
    
    /**
     * 用户（网站管理人员或网站管理人员）注册新账号或网站管理人员添加网站营销人员
     * @param po UserPO型，界面传递过来的用户信息
     * @throws RemoteException
     * @see
     */
    public void insertUser(UserPO userPO) throws RemoteException;
    
    /**
     * 客户注册新账号
     * @param po UserPO型，界面传递过来的用户信息
     * @throws RemoteException
     * @see
     */
    public void insertClient(ClientInfoPO clientInfoPO) throws RemoteException;
    
    /**
     * 用户（酒店工作人员）注册新账号或网站管理人员添加酒店工作人员
     * @param po UserPO型，界面传递过来的用户信息
     * @throws RemoteException
     * @see
     */
    public void insertHotelStaff(HotelStaffInfoPO hotelStaffInfoPO) throws RemoteException;
    
    /**
   * 用户注销账号或网站管理人员删除账号
     * @param po UserPO型，业务逻辑层传递过来的用户信息
     * @throws RemoteException
     * @see
     */
    public void deleteUser(UserPO po) throws RemoteException;
    
    /**
     * 更新用户信息
     * @param po UserPO型，业务逻辑层传递过来的用户信息
     * @throws RemoteException
     * @see
     */
    public void updateUser(UserPO po) throws RemoteException;
}