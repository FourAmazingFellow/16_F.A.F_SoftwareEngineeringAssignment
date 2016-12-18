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
    
    public void setUserDAO(UserDAO userDAO){
        this.userDAO = userDAO;
    }
    
    @Override
    public RegularVipVO getRegularVipInfo(String userID) throws RemoteException {
        this.userDAO = RemoteHelper.getInstance().getUserDAO();
        this.userID = userID;
        this.regularVipVO = new RegularVipVO(userDAO.getRegularVipInfo(this.userID));
        return regularVipVO;
    }

    @Override
    public EnterpriseVipVO getEnterpriseVipInfo(String userID) throws RemoteException {
        this.userDAO = RemoteHelper.getInstance().getUserDAO();
        this.userID = userID;
        this.enterpriseVipVO = new EnterpriseVipVO(userDAO.getEnterpriseVipInfo(this.userID));
        return enterpriseVipVO;
    }

}
