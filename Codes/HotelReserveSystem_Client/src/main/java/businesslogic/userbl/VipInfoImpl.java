package businesslogic.userbl;

import java.rmi.RemoteException;

import dataservice.userDAO.UserDAO;
import po.UserType;
import po.VipInfoPO;
import vo.VipInfoVO;

public class VipInfoImpl implements VipInfo{

    private VipInfoVO vipInfoVO;
    private UserType userType = UserType.Client;
    private UserDAO userDAO;
    
    @Override
    public VipInfoVO getRegularVipInfo(String userID) {
        try {
            this.vipInfoVO = (VipInfoVO) new VipInfoVO((VipInfoPO) userDAO.getUserInfo(userID, userType));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return vipInfoVO;
    }

    @Override
    public VipInfoVO getEnterpriseVipInfo(String userID) {
        try {
            this.vipInfoVO = (VipInfoVO) new VipInfoVO((VipInfoPO) userDAO.getUserInfo(userID, userType));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return vipInfoVO;
    }

}
