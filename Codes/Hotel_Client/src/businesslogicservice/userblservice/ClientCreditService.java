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
     * 查询信用记录
     * @param ID long型，界面传递过来的用户标识
     * @return 返回用户的信用记录
     * @see
     */
    public UserVO queryCredit(long ID);
    
    
    /**
     * 增加用户的信用值（信用充值）
     * @param ID long型，界面传递过来的用户标识
     * @param creditAdded int型，界面传递过来的增加的信用值
     * @return 增加信用值成功则返回true，失败则返回false
     * @see
     */
    public boolean addCreditValue(long ID,int creditAdded);
}
