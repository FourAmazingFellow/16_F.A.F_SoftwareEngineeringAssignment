package businesslogicservice.userblservice;

import vo.UserVO;

/**
 * 
 * @author sparkler
 * @version 1.0
 * @see
 */
public interface UserInfoService {

    /**
     * 查询用户信息
     * @param ID long型，界面传递过来的用户标识
     * @return 返回用户信息
     * @see
     */
    public UserVO getUserInfo(long ID);
    
    /**
     * 修改用户信息
     * @param user UserVO型，界面传递过来的用户信息
     * @return 修改成功则返回true，修改失败则返回false
     * @see
     */
    public boolean modifyUserInfo(UserVO user);
}
