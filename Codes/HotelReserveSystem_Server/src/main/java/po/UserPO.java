package po;

import java.io.Serializable;

/**
 * 用户信息PO，负责持久化数据传输
 * @author sparkler
 * @version 1.0
 */
public class UserPO implements Serializable {
  
    /**
	 * 
	 */
	private static final long serialVersionUID = -7056482237634796341L;
	
	
	private String userID;
    private String password;
    private String telNum;
    private UserType userType;
    
    public UserPO() {
    	
    }
    
    public UserPO(String userID, String password, String telNum, UserType userType) {
        this.userID = userID;
        this.password = password;
        this.telNum = telNum;
        this.userType = userType;
    }
    
    public void setUserID(String userID) {
        this.userID = userID;
    }
    public String getUserID() {
        return userID;
    }
    public void setpassword(String password) {
        this.password = password;
    }
    public String getpassword() {
        return password;
    }
    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }
    public String getTelNum() {
        return telNum;
    }
    public UserType getUserType() {
        return userType;
    }
    public void setUserType(UserType userType) {
        this.userType = userType;
    }

  
}
