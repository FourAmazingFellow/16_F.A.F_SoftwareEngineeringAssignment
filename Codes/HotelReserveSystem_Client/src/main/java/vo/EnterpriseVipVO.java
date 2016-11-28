package vo;

import java.util.ArrayList;

import po.CreditRecordPO;
import po.EnterpriseVipPO;
import po.UserType;

/**
 * 
 * @author sparkler
 * @version 1.0
 */
public class EnterpriseVipVO extends ClientInfoVO {
    public String enterpriseID;
    public String enterprisePassword;

    public EnterpriseVipVO(String userID, String password, String telNum, UserType userType, int creditValue,
            ArrayList<CreditRecordPO> creditRecord, String enterpriseID, String enterprisePassword) {
        super(userID, password, telNum, userType, creditValue, creditRecord);
        this.enterpriseID = enterpriseID;
        this.enterprisePassword = enterprisePassword;
    }

    /**
     * @param enterpriseVipInfo
     */
    public EnterpriseVipVO(EnterpriseVipPO enterpriseVipPO) {
        super(enterpriseVipPO);
        this.enterpriseID = enterpriseVipPO.getEnterpriseID();
        this.enterprisePassword = enterpriseVipPO.getEnterprisepassword();
    }

}
