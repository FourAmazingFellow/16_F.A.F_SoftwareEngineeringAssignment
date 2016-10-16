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
    
    public VipInfoVO(long userID, String passpord, long telNum, Date birth, String enterpriseID,
            String enterprisePasspord) {
        super(userID, passpord, telNum);
        this.birth = birth;
        this.enterpriseID = enterpriseID;
        this.enterprisePasspord = enterprisePasspord;
    }
}
