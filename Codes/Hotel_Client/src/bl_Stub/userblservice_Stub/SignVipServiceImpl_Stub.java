package bl_Stub.userblservice_Stub;

import java.sql.Date;

import businesslogicservice.userblservice.SignVipService;
import vo.UserVO;

public class SignVipServiceImpl_Stub implements SignVipService {

    public Date birth;
    public String enterpriseID;
    public String enterprisePasspord;
    
    public SignVipServiceImpl_Stub(Date birth) {
        super();
        this.birth = birth;
    }

    public SignVipServiceImpl_Stub(String enterpriseID, String enterprisePasspord) {
        super();
        this.enterpriseID = enterpriseID;
        this.enterprisePasspord = enterprisePasspord;
    }
    @Override
    public boolean signRegularVip(UserVO regularVip) {
        return false;
    }

    @Override
    public boolean signEnterpriseVip(UserVO EnterpriseVip) {
        return false;
    }

}
