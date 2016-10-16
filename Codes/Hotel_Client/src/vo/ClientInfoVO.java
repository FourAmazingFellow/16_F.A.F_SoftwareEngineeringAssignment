package vo;

/**
 * 
 * @author sparkler
 * @version 
 * @see
 */
public class ClientInfoVO extends UserVO{

    public int creditValue;
    public String[] creditRecord;

    public ClientInfoVO(long userID, String passpord, long telNum, String creditChangeRecord,
            Enum<vo.UserType> userType, int creditValue, String[] creditRecord) {
        super(userID, passpord, telNum, userType);
        this.creditValue = creditValue;
        this.creditRecord = creditRecord;
    }
    
}
