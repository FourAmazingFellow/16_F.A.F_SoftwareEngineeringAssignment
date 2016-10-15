package businesslogicservice.userblservice;

import vo.UserVO;

/**
 * 
 * @author sparkler
 * @version 1.0
 * @see
 */
public interface ClientCreditService {

    /**
     * 
     * @param ID
     * @return
     * @see
     */
    public UserVO queryCredit(long ID);
    
    
    /**
     * 
     * @param ID
     * @param creditAdded
     * @return
     * @see
     */
    public UserVO addCreditValue(long ID,int creditAdded);
}
