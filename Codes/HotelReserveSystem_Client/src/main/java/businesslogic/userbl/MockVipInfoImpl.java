package businesslogic.userbl;

import java.sql.Date;

import po.UserType;
import vo.EnterpriseVipVO;
import vo.RegularVipVO;

public class MockVipInfoImpl extends VipInfoImpl{
    private RegularVipVO rVipInfoVO;
    private EnterpriseVipVO eVipInfoVO;
    private UserType userType = UserType.Client;
//    @SuppressWarnings("deprecation")
//    private UserDAO userDAO1 = new UserDAOImpl_Stub("原", "qwe123", "12345678900", new Date(1997, 10, 10));
//    private UserDAO userDAO2 = new UserDAOImpl_Stub("原", "qwe123", "12345678900", "如家","rujia");
    
    @SuppressWarnings("deprecation")
    @Override
    public RegularVipVO getRegularVipInfo(String userID) {
        //            this.rVipInfoVO = new VipInfoVO((VipInfoPO) userDAO1.getUserInfo(userID, userType));
          this.rVipInfoVO = new RegularVipVO("原", "qwe123", "12345678900", userType, 0, null, new Date(1997, 10, 10), 0);
        return rVipInfoVO;
    }

    @Override
    public EnterpriseVipVO getEnterpriseVipInfo(String userID) {
        //            this.eVipInfoVO = new VipInfoVO((VipInfoPO) userDAO2.getUserInfo(userID, userType));
        this.eVipInfoVO = new EnterpriseVipVO("原", "qwe123", "12345678900",userType, 0, null, "如家","rujia");
        return eVipInfoVO;
    }

}
