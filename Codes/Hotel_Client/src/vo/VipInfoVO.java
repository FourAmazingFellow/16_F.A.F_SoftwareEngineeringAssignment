package vo;

import java.sql.Date;

/**
 * 
 * @author sparkler
 * @version 1.0
 */
public class VipInfoVO extends UserVO {
   
    public Date birth;
    public String enterpriseID;
    public String enterprisePasspord;
    
    public VipInfoVO(long userID, String passpord, long telNum, String creditChangeRecord, Enum<vo.UserType> userType,
            Date birth, String enterpriseID, String enterprisePasspord) {
        super(userID, passpord, telNum, userType);
        this.birth = birth;
        this.enterpriseID = enterpriseID;
        this.enterprisePasspord = enterprisePasspord;
    }
}
