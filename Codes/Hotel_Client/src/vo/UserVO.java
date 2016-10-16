package vo;

/**
 * 
 * @author sparkler
 * @version 1.0
 */
public class UserVO {
  
    public long userID;
    public String passpord;
    public long telNum;
    public String creditChangeRecord;
    public Enum<UserType> UserType;
 
    public UserVO(long userID, String passpord, long telNum, String creditChangeRecord, Enum<vo.UserType> userType) {
        super();
        this.userID = userID;
        this.passpord = passpord;
        this.telNum = telNum;
        this.creditChangeRecord = creditChangeRecord;
        UserType = userType;
    }
}
