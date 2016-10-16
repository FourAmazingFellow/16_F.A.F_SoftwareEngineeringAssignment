package vo;

/**
 * 
 * @author sparkler
 * @version 
 * @see
 */
public class ClientInfoVO extends UserVO{

    public int creditValue;
    
    public ClientInfoVO(long userID, String passpord, long telNum, String creditChangeRecord,
            Enum<vo.UserType> userType, int creditValue) {
        super(userID, passpord, telNum, creditChangeRecord, userType);
        this.creditValue = creditValue;
    }
}
