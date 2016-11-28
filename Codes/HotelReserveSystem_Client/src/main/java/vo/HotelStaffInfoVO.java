package vo;

import po.UserType;

/**
 * 
 * @author sparkler
 * @version 
 * @see
 */
public class HotelStaffInfoVO extends UserVO{
    public String hotelAddress;

    public HotelStaffInfoVO(String userID, String password, String telNum, UserType userType, String enterpriseName) {
        super(userID, password, telNum, userType);
        this.hotelAddress = enterpriseName;
    }
    
  
}
