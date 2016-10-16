package bl_Stub.userblservice_Stub;

import businesslogicservice.userblservice.UserInfoService;
import po.UserType;
import vo.UserVO;

/**
 * 
 * @author sparkler
 * @version 
 * @see
 */
public class UserInfoServiceImpl_Stub implements UserInfoService {

    public long userID;
    public String passpord;
    public long telNum;
    public String creditChangeRecord;
    public Enum<UserType> UserType;
    public int creditValue;
    public String enterpriseName;
    
    public UserInfoServiceImpl_Stub(long userID, String passpord, long telNum, String creditChangeRecord,
            Enum<po.UserType> userType, int creditValue, String enterpriseName) {
        super();
        this.userID = userID;
        this.passpord = passpord;
        this.telNum = telNum;
        this.creditChangeRecord = creditChangeRecord;
        UserType = userType;
        this.creditValue = creditValue;
        this.enterpriseName = enterpriseName;
    }
    
    @Override
    public UserVO getUserInfo(long ID, Enum<UserType> UserType) {
        
        return null;
    }

    @Override
    public boolean modifyUserInfo(UserVO user) {
        
        return false;
    }

}
