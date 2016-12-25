package vo;

import po.UserType;

/**
 * 网站营销人员的值对象
 * @author sparkler
 * @version 
 * @see
 */
public class WebMarketStaffInfoVO extends UserVO{

    public WebMarketStaffInfoVO(String userID, String password, String telNum, UserType client) {
        super(userID, password, telNum, client);
    }

}
