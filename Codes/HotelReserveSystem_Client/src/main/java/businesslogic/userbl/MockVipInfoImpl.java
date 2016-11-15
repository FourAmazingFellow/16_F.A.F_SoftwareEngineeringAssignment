package businesslogic.userbl;

import java.rmi.RemoteException;
import java.sql.Date;

import data_Stub.UserDAOImpl_Stub;
import dataservice.userDAO.UserDAO;
import po.UserType;
import po.VipInfoPO;
import vo.VipInfoVO;

public class MockVipInfoImpl extends VipInfoImpl{
    private VipInfoVO rVipInfoVO;
    private VipInfoVO eVipInfoVO;
    private UserType userType = UserType.Client;
    private Date birth;
    private UserDAO userDAO1 = new UserDAOImpl_Stub("qwe121", "qwedsa", "23123455431", birth);
    private UserDAO userDAO2 = new UserDAOImpl_Stub("qwe123", "qweqwe", "12312312312", "如家");
    
    @Override
    public VipInfoVO getRegularVipInfo(String userID) {
        try {
            this.rVipInfoVO = (VipInfoVO) new VipInfoVO((VipInfoPO) userDAO1.getUserInfo(userID, userType));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return rVipInfoVO;
    }

    @Override
    public VipInfoVO getEnterpriseVipInfo(String userID) {
        try {
            this.eVipInfoVO = (VipInfoVO) new VipInfoVO((VipInfoPO) userDAO2.getUserInfo(userID, userType));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return eVipInfoVO;
    }

}
