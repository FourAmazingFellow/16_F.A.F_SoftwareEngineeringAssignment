package vo;

import java.sql.Date;

import po.UserType;
import po.VipInfoPO;

/**
 * 
 * @author sparkler
 * @version 1.0
 */
public class VipInfoVO extends UserVO {
   

    public Date birth;
    public String enterpriseID;
    public String enterprisePassword;
    public VipInfoVO(String userID, String password, String telNum, Enum<UserType> userType, Date birth) {
        super(userID, password, telNum, userType);
        this.birth = birth;
    }
    public VipInfoVO(String userID, String password, String telNum, Enum<UserType> userType, String enterpriseID,
            String enterprisepassword) {
        super(userID, password, telNum, userType);
        this.enterpriseID = enterpriseID;
        this.enterprisePassword = enterprisepassword;
    }
    public VipInfoVO(VipInfoPO vipInfo) {
        super(vipInfo);
        this.enterpriseID = vipInfo.getEnterpriseID();
        this.enterprisePassword = vipInfo.getEnterprisepassword();
    }


}
