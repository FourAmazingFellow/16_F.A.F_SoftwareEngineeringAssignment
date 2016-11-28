package businesslogicservice.userblservice;

import vo.HotelStaffInfoVO;
import vo.UserVO;

/**
 * 
 * @author sparkler
 * @version
 * @see
 */
public interface ManageUserInfoService {
    /**
     * 网站管理人员增加网站营销人员
     * @param webMarketStaff WebMarketStaffInfoVO型，界面传递过来的网站营销人员信息
     * @return 添加成功则返回true，添加失败则返回false
     * @see
     */
    public boolean add(UserVO user);

    /**
     * 网站管理人员获取酒店工作人员信息
     * @param userID String型，界面层传递过来的酒店工作人员账号
     * @return 返回酒店工作人员信息
     * @see
     */
    public HotelStaffInfoVO getHotelStaffInfo(String userID);

    /**
     * 网站管理人员获取用户（web工作人员）信息
     * @param userID String型，界面传递过来的用户账号
     * @return 返回用户信息
     * @see
     */
    public UserVO getUserInfo(String userID);

    /**
     * 网站管理人员修改用户信息
     * @param userVO UserVO型，界面传递过来的修改过的用户信息
     * @param userID String型，界面传递过来的用户的原来的账号
     * @return 修改成功则返回true，否则返回false
     * @see
     */
    public boolean modifyUserInfo(UserVO userVO, String userID);

}
