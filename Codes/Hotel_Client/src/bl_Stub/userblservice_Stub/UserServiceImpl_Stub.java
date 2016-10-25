package bl_Stub.userblservice_Stub;

import businesslogicservice.userblservice.UserService;
import po.UserType;
import vo.UserVO;

/**
 * 
 * @author sparkler
 * @version 
 * @see
 */
public class UserServiceImpl_Stub implements UserService {

    public long userID;
    public String passpord;
    public long telNum;
    public Enum<UserType> UserType;

    
    public UserServiceImpl_Stub(long userID, String passpord, long telNum, 
            Enum<po.UserType> userType) {
        super();
        this.userID = userID;
        this.passpord = passpord;
        this.telNum = telNum;
        UserType = userType;
    }
    
    
    @Override
    public boolean login(String userID, String password) {
        return false;
    }

    @Override
    public boolean add(UserVO user) {
        return false;
    }

    @Override
    public boolean del(UserVO user) {
        return false;
    }

}
