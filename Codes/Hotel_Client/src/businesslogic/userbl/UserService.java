package businesslogic.userbl;

import vo.UserVO;

/**
 * 
 * @author sparkler
 * @version 
 * @see
 */
public interface UserService {

    /**
     * 酒店管理人员添加酒店工作人员
     * @param staff UserVO型，界面传递过来的酒店工作人员信息
     * @return 添加成功则返回true，添加失败则返回false
     * @see
     */
    public boolean insert(UserVO staff);
    
}
