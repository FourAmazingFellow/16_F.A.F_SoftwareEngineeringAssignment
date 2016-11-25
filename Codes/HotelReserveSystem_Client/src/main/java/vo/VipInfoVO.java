package vo;

import java.sql.Date;
import java.util.ArrayList;

import po.CreditRecordPO;
import po.UserType;

/**
 * 
 * @author sparkler
 * @version 1.0
 */
public class VipInfoVO extends ClientInfoVO {
   

    public Date birth;
    public int vipRank;
    public String enterpriseID;
    public String enterprisePassword;
    public VipInfoVO(String userID, String password, String telNum, UserType userType, int creditValue,
            ArrayList<CreditRecordPO> creditRecord, Date birth, int vipRank) {
        super(userID, password, telNum, userType, creditValue, creditRecord);
        this.birth = birth;
        this.vipRank = vipRank;
    }
    
    public VipInfoVO(String userID, String password, String telNum, UserType userType, int creditValue,
            ArrayList<CreditRecordPO> creditRecord, String enterpriseID, String enterprisePassword) {
        super(userID, password, telNum, userType, creditValue, creditRecord);
        this.enterpriseID = enterpriseID;
        this.enterprisePassword = enterprisePassword;
    }
   
    


}
