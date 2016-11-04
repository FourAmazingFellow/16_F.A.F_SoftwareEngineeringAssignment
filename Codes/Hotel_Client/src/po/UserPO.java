package po;

import vo.ClientInfoVO;

/**
 * 用户信息PO，负责持久化数据传输
 * @author sparkler
 * @version 1.0
 */
public class UserPO {
  
    private String userID;
    private String passpord;
    private String telNum;
    public Enum<UserType> userType;
    
    public UserPO(String userID, String passpord, String telNum, Enum<UserType> userType) {
        this.userID = userID;
        this.passpord = passpord;
        this.telNum = telNum;
        this.userType = userType;
    }
    

    public UserPO(ClientInfoVO clientInfoVO) {
    }


    public void setUserID(String userID) {
        this.userID = userID;
    }
    public String getUserID() {
        return userID;
    }
    public void setPasspord(String passpord) {
        this.passpord = passpord;
    }
    public String getPasspord() {
        return passpord;
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
