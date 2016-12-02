package dataservice.userDAO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.ClientInfoPO;
import po.CreditRecordPO;
import po.EnterpriseVipPO;
import po.HotelStaffInfoPO;
import po.RegularVipPO;
import po.UserPO;
/**
 * 为业务逻辑层提供所需要的用户数据
 * @author sparkler
 * @version 
 * @see
 */
public interface UserDAO extends Remote {
    
    /**
     * 查询用户（网站管理人员、网站营销人员）信息
     * @param ID long型，业务逻辑层传递来的用户账号
     * @param userType UserType型，业务逻辑层传递来的用户类型
     * @return 返回用户信息
     * @throws RemoteException
     * @see
     */
    public UserPO getUserInfo(String userID) throws RemoteException;
    
    /**
     * 查询客户信息
     * @param userID String型，业务逻辑层传递来的客户账号
     * @return 返回客户信息
     * @throws RemoteException
     * @see
     */
    public ClientInfoPO getClientInfo(String userID) throws RemoteException;
    
    /**
     * 查询酒店工作人员信息
     * @param userID String型，业务逻辑层传递来的酒店工作人员账号
     * @return 返回酒店工作人员信息
     * @throws RemoteException
     * @see
     */
    public HotelStaffInfoPO getHotelStaffInfo(String userID) throws RemoteException;
    
    /**
    * 查询信用记录
     * @param ID long型，业务逻辑层传递过来的用户标识
     * @return 返回用户的信用记录
     * @throws RemoteException
     * @see
     */
    public ArrayList<CreditRecordPO> queryCreditRecord(String userID) throws RemoteException;
    
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
     * 更新用户（网站管理人员、网站营销人员、酒店工作人员）信息
     * @param userPO UserPO型，业务逻辑层传递过来的用户信息
     * @throws RemoteException
     * @see
     */
    public void updateUser(UserPO userPO, String oldUserID) throws RemoteException;
    
    /**
     * 更新客户信息
     * @param clientInfoPO ClientInfoPO型，业务逻辑层传递过来的客户信息
     * @throws RemoteException
     * @see
     */
    public void updateClient(ClientInfoPO clientInfoPO, String oldUserID) throws RemoteException;
    
    /**
     * 注册普通会员
     * @param regularVipPO RegularVipPO型，业务逻辑层传递过来的普通会员信息
     * @throws RemoteException
     * @see
     */
    public void signRegularVip(RegularVipPO regularVipPO) throws RemoteException;
    
    /**
     * 注册企业会员
     * @param enterpriseVipPO EnterpriseVipPO型，业务逻辑层传递过来的企业会员信息
     * @throws RemoteException
     * @see
     */
    public void signEnterpriseVip(EnterpriseVipPO enterpriseVipPO) throws RemoteException;
    
    /**
     * 得到普通会员信息
     * @param userID String型，业务逻辑层传递过来的用户标识
     * @return 返回普通会员信息
     * @see
     */
    public RegularVipPO getRegularVipInfo(String userID) throws RemoteException;
    
    /**
     * 得到企业会员信息
     * @param userID String型，业务逻辑层传递过来的用户标识
     * @return 返回企业会员信息
     * @see
     */
    public EnterpriseVipPO getEnterpriseVipInfo(String userID) throws RemoteException;
    
    /**
     * 更新普通会员信息
     * @param regularVipPO RegularVipPO型，业务逻辑层传递过来的普通会员信息
     * @param userID String型，业务逻辑层传递过来的普通会员账号
     * @see
     */
    public void updateRegularVipInfo(RegularVipPO regularVipPO) throws RemoteException;

}