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
     * 
     * @param ID
     * @param password
     * @return
     * @see
     */
    public boolean login(long ID, String password);
    
    /**
     * 
     * @param regularVip
     * @return
     * @see
     */
    public boolean signRegularVip(UserVO regularVip);
    
    /**
     * 
     * @param EnterpriseVip
     * @return
     * @see
     */
    public boolean signEnterpriseVip(UserVO EnterpriseVip);
    
    /**
     * 
     * @param user
     * @return
     * @see
     */
    public boolean add(UserVO user);
    
    /**
     * 
     * @param user
     * @return
     * @see
     */
    public boolean del(UserVO user);
}
