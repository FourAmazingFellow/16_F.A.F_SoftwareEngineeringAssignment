package businesslogicservice.userblservice;

import vo.UserVO;


public interface LoginAndSignUpService {

	/**
     * 用户登录
     * @param ID long型，界面传递过来的用户标识
     * @param password String型，界面传递过来的用户密码
     * @return 登陆成功则返回true，登陆失败则返回false
     * @see
     */
    public boolean login(String userID, String password);
    
    
    /**
     * 用户注册新账号
     * @param user UserVO型，界面传递过来的用户信息
     * @return 注册成功则返回true，注册失败则返回false
     * @see
     */
    public boolean add(UserVO user);
}
