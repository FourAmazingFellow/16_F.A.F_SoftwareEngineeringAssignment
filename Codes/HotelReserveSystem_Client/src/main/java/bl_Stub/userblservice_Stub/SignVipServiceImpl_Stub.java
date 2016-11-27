package bl_Stub.userblservice_Stub;

import java.util.Date;

import businesslogicservice.userblservice.SignVipService;
import vo.EnterpriseVipVO;
import vo.RegularVipVO;

/**
 * 
 * @author 原
 * @version
 * @see
 */
public class SignVipServiceImpl_Stub implements SignVipService {

    public Date birth;
    public String enterpriseID;
    public String enterprisepassword;
    
    public SignVipServiceImpl_Stub(Date birth) {
        super();
        this.birth = birth;
    }

    public SignVipServiceImpl_Stub(String enterpriseID, String enterprisepassword) {
        super();
        this.enterpriseID = enterpriseID;
        this.enterprisepassword = enterprisepassword;
    }

    @Override
    public boolean signRegularVip(RegularVipVO regularVip) {
        return false;
    }

    @Override
    public boolean signEnterpriseVip(EnterpriseVipVO EnterpriseVip) {
        return false;
    }
}
