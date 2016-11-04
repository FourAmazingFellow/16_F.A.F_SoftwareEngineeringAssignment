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
    public String passpord;
    public String telNum;
    public Enum<UserType> UserType;

    public UserInfoImpl_Stub(long userID, String passpord, String telNum, Enum<po.UserType> userType) {
        super();
        this.userID = userID;
        this.passpord = passpord;
        this.telNum = telNum;
        UserType = userType;
    }

    @Override
    public boolean insert(UserVO staff) {
        return false;
    }

    @Override
    public UserVO getUserInfo(String userID) {
        return new UserVO(userID, passpord, telNum, UserType);
    }
    
    
}
