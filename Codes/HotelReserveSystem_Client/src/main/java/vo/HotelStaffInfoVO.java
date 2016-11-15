package vo;

import po.UserType;

/**
 * 
 * @author sparkler
 * @version 
 * @see
 */
public class HotelStaffInfoVO extends UserVO{
    private String enterpriseName;
    
    public HotelStaffInfoVO(String userID, String passpord, String telNum, Enum<UserType> userType,
            String enterpriseName) {
        super(userID, passpord, telNum, userType);
        this.enterpriseName = enterpriseName;
    }
    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }
    public String getEnterpriseName() {
        return enterpriseName;
    }
}
