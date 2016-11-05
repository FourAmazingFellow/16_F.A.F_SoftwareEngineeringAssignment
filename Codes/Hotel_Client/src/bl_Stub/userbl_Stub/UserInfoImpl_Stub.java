package bl_Stub.userbl_Stub;

import businesslogic.userbl.UserInfo;
import po.UserType;
import vo.UserVO;

/**
 * 
 * @author sparkler
 * @version 
 * @see
 */
public class UserInfoImpl_Stub implements UserInfo {
    public long userID;
    public String password;
    public String telNum;
    public Enum<UserType> UserType;

    public UserInfoImpl_Stub(long userID, String password, String telNum, Enum<po.UserType> userType) {
        super();
        this.userID = userID;
        this.password = password;
        this.telNum = telNum;
        UserType = userType;
    }

    @Override
    public boolean insert(UserVO staff) {
        return false;
    }

    @Override
    public UserVO getUserInfo(String userID) {
        return new UserVO(userID, password, telNum, UserType);
    }

    @Override
    public String getPassword(String userID) {
        return password;
    }
    
    
}
