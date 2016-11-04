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
    public VipInfoVO(String userID, String passpord, String telNum, Date birth) {
        super(userID, passpord, telNum);
        this.birth = birth;
    }
    public VipInfoVO(String userID, String passpord, String telNum, String enterpriseID, String enterprisePasspord) {
        super(userID, passpord, telNum);
        this.enterpriseID = enterpriseID;
        this.enterprisePasspord = enterprisePasspord;
    }
    

}
