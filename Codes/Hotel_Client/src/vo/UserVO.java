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
    public Enum<UserType> UserType;
 
    public UserVO(long userID, String passpord, long telNum, Enum<vo.UserType> userType) {
        super();
        this.userID = userID;
        this.passpord = passpord;
        this.telNum = telNum;
        UserType = userType;
    }
}
