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
    public String enterprisePasspord;
    public VipInfoVO(String userID, String passpord, String telNum, Enum<UserType> userType, Date birth) {
        super(userID, passpord, telNum, userType);
        this.birth = birth;
    }
    public VipInfoVO(String userID, String passpord, String telNum, Enum<UserType> userType, String enterpriseID,
            String enterprisePasspord) {
        super(userID, passpord, telNum, userType);
        this.enterpriseID = enterpriseID;
        this.enterprisePasspord = enterprisePasspord;
    }
    public VipInfoVO(VipInfoPO vipInfo) {
        super(vipInfo);
        this.enterpriseID = vipInfo.getEnterpriseID();
        this.enterprisePasspord = vipInfo.getEnterprisePasspord();
    }


}
