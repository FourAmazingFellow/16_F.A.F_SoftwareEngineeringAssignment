package po;

/**
 * 用户信息PO，负责持久化数据传输
 * @author sparkler
 * @version 1.0
 */
public class UserPO {
  


    private long userID;
    private String passpord;
    private long telNum;
    private Enum<UserType> UserType;
    
    public UserPO(long userID, String passpord, long telNum, Enum<po.UserType> userType) {
        super();
        this.userID = userID;
        this.passpord = passpord;
        this.telNum = telNum;
      
        UserType = userType;
    }
    
    public void setUserID(long userID) {
        this.userID = userID;
    }
    public long getUserID() {
        return userID;
    }
    public void setPasspord(String passpord) {
        this.passpord = passpord;
    }
    public String getPasspord() {
        return passpord;
    }
    public void setTelNum(long telNum) {
        this.telNum = telNum;
    }
    public long getTelNum() {
        return telNum;
    }
    public Enum<UserType> getUserType() {
        return UserType;
    }

    public void setUserType(Enum<UserType> userType) {
        UserType = userType;
    }
  
}
