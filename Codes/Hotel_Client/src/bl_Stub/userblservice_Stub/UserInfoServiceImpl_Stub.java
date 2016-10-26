package bl_Stub.userblservice_Stub;

import businesslogicservice.userblservice.ModifyClientInfoService;
import po.UserType;
import vo.UserVO;

/**
 * 
 * @author sparkler
 * @version 
 * @see
 */
public class UserInfoServiceImpl_Stub implements ModifyClientInfoService {

    public long userID;
    public String passpord;
    public String telNum;
    public Enum<UserType> UserType;
    public int creditValue;
    public String enterpriseName;
    
    public UserInfoServiceImpl_Stub(long userID, String passpord, String telNum,
            Enum<po.UserType> userType, int creditValue, String enterpriseName) {
        super();
        this.userID = userID;
        this.passpord = passpord;
        this.telNum = telNum;
        UserType = userType;
        this.creditValue = creditValue;
        this.enterpriseName = enterpriseName;
    }
    
    @Override
    public UserVO getUserInfo(String userID, Enum<UserType> UserType) {
        return new UserVO(userID, passpord, telNum);
    }

    @Override
    public boolean modifyUserInfo(UserVO user) {
        return false;
    }

}
