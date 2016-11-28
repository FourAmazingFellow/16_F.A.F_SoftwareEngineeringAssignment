package businesslogic.userbl;

import java.rmi.RemoteException;
import dataservice.userDAO.UserDAO;
import rmi.RemoteHelper;
import vo.EnterpriseVipVO;
import vo.RegularVipVO;

public class VipInfoImpl implements VipInfo {
    private RegularVipVO regularVipVO;
    private EnterpriseVipVO enterpriseVipVO;
    private UserDAO userDAO;
    private String userID;
    @Override
    public RegularVipVO getRegularVipInfo(String userID) {
        this.userDAO = RemoteHelper.getInstance().getUserDAO();
        this.userID = userID;
        try {
            this.regularVipVO = new RegularVipVO(userDAO.getRegularVipInfo(this.userID));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return regularVipVO;
    }

    @Override
    public EnterpriseVipVO getEnterpriseVipInfo(String userID) {
        this.userDAO = RemoteHelper.getInstance().getUserDAO();
        this.userID = userID;
        try {
            this.enterpriseVipVO = new EnterpriseVipVO(userDAO.getEnterpriseVipInfo(this.userID));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return enterpriseVipVO;
    }

}
