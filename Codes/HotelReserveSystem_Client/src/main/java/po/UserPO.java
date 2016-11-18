package po;
import vo.UserVO;

/**
 * 用户信息PO，负责持久化数据传输
 * @author sparkler
 * @version 1.0
 */
public class UserPO {
  
    private String userID;
    private String password;
    private String telNum;
    public Enum<UserType> userType;
    
    public UserPO(String userID, String password, String telNum, Enum<UserType> userType) {
        this.userID = userID;
        this.password = password;
        this.telNum = telNum;
        this.userType = userType;
    }
    

    public UserPO(UserVO user) {
    }


    public void setUserID(String userID) {
        this.userID = userID;
    }
    public String getUserID() {
        return userID;
    }
    public void setPasspord(String passpord) {
        this.password = passpord;
    }
    public String getPassword() {
        return password;
    }
    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }
    public String getTelNum() {
        return telNum;
    }
    public Enum<UserType> getUserType() {
        return userType;
    }
    public void setUserType(Enum<UserType> userType) {
        this.userType = userType;
    }

  
}
