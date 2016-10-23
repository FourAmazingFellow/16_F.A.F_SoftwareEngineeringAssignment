package businesslogicservice.userblservice;

import vo.UserVO;

/**
 * 
 * @author sparkler
 * @version
 * @see
 */
public interface UserService {

    /**
     * 用户登录
     * @param ID long型，界面传递过来的用户标识
     * @param password String型，界面传递过来的用户密码
     * @return 登陆成功则返回true，登陆失败则返回false
     * @see
     */
    public boolean login(String userID, String password);
    
    /**
     * 注册普通会员
     * @param regularVip UserVO型，界面传递过来的普通会员信息
     * @return 注册成功则返回true，注册失败则返回false
     * @see
     */
    public boolean signRegularVip(UserVO regularVip);
    
    /**
     * 注册企业会员
     * @param EnterpriseVip UserVO型，界面传递过来的企业会员信息
     * @return 注册成功则返回true，注册失败则返回false
     * @see
     */
    public boolean signEnterpriseVip(UserVO EnterpriseVip);
    
    /**
     * 用户注册新账号或网站管理人员增加账号
     * @param user UserVO型，界面传递过来的用户信息
     * @return 注册成功则返回true，注册失败则返回false
     * @see
     */
    public boolean add(UserVO user);
    
    /**
     * 用户注销账号或网站管理人员删除账号
     * @param user UserVO型，界面传递过来的用户信息
     * @return 删除成功则返回true，删除失败则返回false
     * @see
     */
    public boolean del(UserVO user);
}
