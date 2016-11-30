package businesslogic.strategybl;

import java.rmi.RemoteException;
import java.util.Date;

import businesslogic.userbl.VerifyEnterpriseVip;
import data_Stub.StrategyDAOImpl_Stub;
import dataservice.strategyDAO.StrategyDAO;
import po.StrategyType;
import rmi.RemoteHelper;

public class VerifyEnterpriseVipImpl implements VerifyEnterpriseVip {

    StrategyDAO strategyDAO;

    @SuppressWarnings("deprecation")
    public VerifyEnterpriseVipImpl() {
        strategyDAO = new StrategyDAOImpl_Stub("江苏省南京市栖霞区仙林大道163号", "仙林大酒店", StrategyType.SpecificTimePromotion,
                "双十一折扣", 80, 0, null, null, new Date(116, 10, 10, 00, 00, 00), new Date(116, 10, 12, 00, 00, 00), null,
                0);
    }

    @Override
    public boolean verifyEnterpriseMember(String enterpriseName, String securityCode) {
        strategyDAO = RemoteHelper.getInstance().getStrategyDAO();
        boolean verifyed = false;
        try {
            verifyed = strategyDAO.verifyEnterpriseMember(enterpriseName, securityCode);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
        return verifyed;
    }

}
