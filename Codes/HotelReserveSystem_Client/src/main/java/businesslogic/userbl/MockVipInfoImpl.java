package businesslogic.userbl;

import java.sql.Date;

import po.UserType;
import vo.VipInfoVO;

public class MockVipInfoImpl extends VipInfoImpl{
    private VipInfoVO rVipInfoVO;
    private VipInfoVO eVipInfoVO;
    private UserType userType = UserType.Client;
//    @SuppressWarnings("deprecation")
//    private UserDAO userDAO1 = new UserDAOImpl_Stub("原", "qwe123", "12345678900", new Date(1997, 10, 10));
//    private UserDAO userDAO2 = new UserDAOImpl_Stub("原", "qwe123", "12345678900", "如家","rujia");
    
    @SuppressWarnings("deprecation")
    @Override
    public VipInfoVO getRegularVipInfo(String userID) {
        //            this.rVipInfoVO = new VipInfoVO((VipInfoPO) userDAO1.getUserInfo(userID, userType));
          this.rVipInfoVO = new VipInfoVO("原", "qwe123", "12345678900", userType, new Date(1997, 10, 10));
        return rVipInfoVO;
    }

    @Override
    public VipInfoVO getEnterpriseVipInfo(String userID) {
        //            this.eVipInfoVO = new VipInfoVO((VipInfoPO) userDAO2.getUserInfo(userID, userType));
        this.eVipInfoVO = new VipInfoVO("原", "qwe123", "12345678900",userType, "如家","rujia");
        return eVipInfoVO;
    }

}
