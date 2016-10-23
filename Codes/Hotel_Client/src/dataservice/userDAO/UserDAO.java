package dataservice.userDAO;

import java.rmi.RemoteException;
import po.UserPO;
import po.UserType;
/**
 * 为业务逻辑层提供所需要的用户数据
 * @author sparkler
 * @version 
 * @see
 */
public interface UserDAO {
    
    /**
     * 查询用户信息
     * @param ID long型，业务逻辑层传递来的用户账号
     * @param UserType Enum<UserType>型，业务逻辑层传递来的用户类型
     * @return 返回用户信息
     * @throws RemoteException
     * @see
     */
    public UserPO getUserInfo(String userID, UserType userType) throws RemoteException;
    
    /**
    * 查询信用记录
     * @param ID long型，业务逻辑层传递过来的用户标识
     * @return 返回用户的信用记录
     * @throws RemoteException
     * @see
     */
    public UserPO queryCredit(String userID) throws RemoteException;
    
    /**
      * 获取客户的信用值
     * @param ID long型，业务逻辑层传递过来的用户标识
     * @return 返回客户当前信用值
     * @throws RemoteException
     * @see
     */
    public int getCreditValue(String userID) throws RemoteException;
    
    /**
     * 用户注册新账号或网站管理人员增加账号
     * @param po UserPO型，界面传递过来的用户信息
     * @throws RemoteException
     * @see
     */
    public void insert(UserPO po) throws RemoteException;
    
    /**
   * 用户注销账号或网站管理人员删除账号
     * @param po UserPO型，业务逻辑层传递过来的用户信息
     * @throws RemoteException
     * @see
     */
    public void delete(UserPO po) throws RemoteException;
    
    /**
     * 更新用户信息
     * @param po UserPO型，业务逻辑层传递过来的用户信息
     * @throws RemoteException
     * @see
     */
    public void update(UserPO po) throws RemoteException;
    
    /**
     * 结束持久化数据存储的使用
     * @throws RemoteException
     * @see
     */
    public void finish() throws RemoteException;
}
