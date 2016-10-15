package businesslogic.userbl;

import vo.UserVO;

/**
 * 
 * @author sparkler
 * @version 
 * @see
 */
public interface UserInfoService {

    /**
     * 
     * @param ID
     * @return
     * @see
     */
    public UserVO getGegularVipInfo(long ID);
    
    /**
     * 
     * @param ID
     * @return
     * @see
     */
    public UserVO getEnterpriseInfo(long ID);
}
