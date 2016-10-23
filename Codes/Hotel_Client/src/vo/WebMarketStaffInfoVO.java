package vo;
/**
 * 
 * @author sparkler
 * @version 
 * @see
 */
public class WebMarketStaffInfoVO extends UserVO{

    public WebMarketStaffInfoVO(String userID, String passpord, long telNum, String creditChangeRecord,
            Enum<vo.UserType> userType) {
        super(userID, passpord, telNum);
    }

}
