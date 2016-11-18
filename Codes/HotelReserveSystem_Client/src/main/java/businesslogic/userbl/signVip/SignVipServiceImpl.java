package businesslogic.userbl.signVip;

import java.rmi.RemoteException;

import businesslogic.strategybl.StrategyInfoService;
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
    private StrategyInfoService strategyInfo;
    
    public void setStrategyInfo(StrategyInfoService strategyInfo){
        this.strategyInfo = strategyInfo;
    }
    
    @Override
    public boolean signRegularVip(VipInfoVO regularVip) {
        try {
            userDAO.update(new UserPO(regularVip));
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean signEnterpriseVip(VipInfoVO enterpriseVip) {
        try {
            if(strategyInfo.verifyEnterpriseMember(enterpriseVip.enterpriseID, enterpriseVip.enterprisePassword)){
            userDAO.update(new UserPO(enterpriseVip));
            return true;
            }
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }


}
