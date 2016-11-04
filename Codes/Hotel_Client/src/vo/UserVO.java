package vo;

import po.UserPO;
import po.UserType;
/**
 * 
 * @author sparkler
 * @version 1.0
 */
public class UserVO {
  
    public String userID;
    public String passpord;
    public String telNum;
    public Enum<UserType> userType;
 
    public UserVO(String userID, String passpord, String telNum, Enum<UserType> userType) {
        this.userID = userID;
        this.passpord = passpord;
        this.telNum = telNum;
        this.userType = userType;
    }
    public UserVO(UserPO userPO){
        this.userID = userPO.getUserID();
        this.passpord = userPO.getPasspord();
        this.telNum = userPO.getTelNum();
        this.userType = userPO.getUserType();
    }
}
