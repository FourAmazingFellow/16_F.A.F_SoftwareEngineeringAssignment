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

    public ClientInfoVO(String userID, String passpord, long telNum, String[] creditRecord, int creditValue) {
        super(userID, passpord, telNum);
        this.creditValue = creditValue;
        this.creditRecord = creditRecord;
    }
    
}
