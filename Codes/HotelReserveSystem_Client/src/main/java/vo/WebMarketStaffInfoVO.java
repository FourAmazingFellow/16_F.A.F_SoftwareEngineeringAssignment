package vo;

import po.UserType;

/**
 * 
 * @author sparkler
 * @version 
 * @see
 */
public class WebMarketStaffInfoVO extends UserVO{

    public WebMarketStaffInfoVO(String userID, String password, String telNum, UserType client) {
        super(userID, password, telNum, client);
    }

}
