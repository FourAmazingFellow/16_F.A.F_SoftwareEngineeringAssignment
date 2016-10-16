package bl_Stub.userblservice_Stub;

import java.sql.Date;

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

    public Date birth;
    public String enterpriseID;
    public String enterprisePasspord;
    
    public UserServiceImpl_Stub(long userID, String passpord, long telNum, 
            Enum<po.UserType> userType) {
        super();
        this.userID = userID;
        this.passpord = passpord;
        this.telNum = telNum;
        UserType = userType;
    }
    
    public UserServiceImpl_Stub(long userID, String passpord, long telNum,
            Enum<po.UserType> userType, Date birth, String enterpriseID, String enterprisePasspord) {
        super();
        this.userID = userID;
        this.passpord = passpord;
        this.telNum = telNum;
        UserType = userType;
        this.birth = birth;
        this.enterpriseID = enterpriseID;
        this.enterprisePasspord = enterprisePasspord;
    }
    
    @Override
    public boolean login(long ID, String password) {
        return false;
    }

    @Override
    public boolean signRegularVip(UserVO regularVip) {
        return false;
    }

    @Override
    public boolean signEnterpriseVip(UserVO EnterpriseVip) {
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
