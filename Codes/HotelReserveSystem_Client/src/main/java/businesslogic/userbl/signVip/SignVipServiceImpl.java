package businesslogic.userbl.signVip;

import java.rmi.RemoteException;

import businesslogicservice.userblservice.SignVipService;
import dataservice.userDAO.UserDAO;
import po.UserPO;
import vo.VipInfoVO;


/**
 * 
 * @author sparkler
 * @version 
 * @see
 */
public class SignVipServiceImpl implements SignVipService {

    private UserDAO userDAO;
    
    @Override
    public boolean signRegularVip(VipInfoVO regularVip) {
        try {
            userDAO.updateUser(new UserPO(regularVip));;
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean signEnterpriseVip(VipInfoVO enterpriseVip) {
        try {
            userDAO.updateUser(new UserPO(enterpriseVip));;
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }


}
