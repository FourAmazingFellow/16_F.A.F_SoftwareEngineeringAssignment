package businesslogicservice.userblservice;

import vo.UserType;
import vo.UserVO;
import vo.WebMarketStaffInfoVO;

/**
 * 
 * @author sparkler
 * @version
 * @see
 */
public interface ManageUserInfoService extends ModifyClientInfoService{
	/**
     * 网站管理人员增加网站营销人员
     * @param webMarketStaff WebMarketStaffInfoVO型，界面传递过来的网站营销人员信息
     * @return 添加成功则返回true，添加失败则返回false
     * @see
     */
    public boolean add(WebMarketStaffInfoVO webMarketStaff);

    public UserVO getUserInfo(String userID, UserType client);
}
