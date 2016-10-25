package vo;

/**
 * 
 * @author sparkler
 * @version 1.0
 */
public class UserVO {
  
    public String userID;
    public String passpord;
    public String telNum;
    public Enum<UserType> UserType;
 
    public UserVO(String userID, String passpord, String telNum) {
        super();
        this.userID = userID;
        this.passpord = passpord;
        this.telNum = telNum;
    }
}
