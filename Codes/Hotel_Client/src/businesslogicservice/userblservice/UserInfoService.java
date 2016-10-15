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
     * 
     * @param ID
     * @return
     * @see
     */
    public UserVO getUserInfo(long ID);
    
    /**
     * 
     * @param user
     * @return
     * @see
     */
    public boolean modifyUserInfo(UserVO user);
}
