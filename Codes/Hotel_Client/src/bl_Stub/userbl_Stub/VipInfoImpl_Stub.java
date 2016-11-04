package bl_Stub.userbl_Stub;

import java.sql.Date;

import businesslogic.userbl.VipInfo;
import po.UserType;
import vo.VipInfoVO;

/**
 * 
 * @author sparkler
 * @version 
 * @see
 */
public class VipInfoImpl_Stub implements VipInfo{
   
    public String userID;
    public String passpord;
    public String telNum;
    public Enum<UserType> UserType;
    public int creditValue;
    public Date birth;
    public String enterpriseID;
    public String enterprisePasspord;
    


    public VipInfoImpl_Stub(String userID, String passpord, String telNum, Enum<po.UserType> userType, int creditValue,
            Date birth) {
        super();
        this.userID = userID;
        this.passpord = passpord;
        this.telNum = telNum;
        UserType = userType;
        this.creditValue = creditValue;
        this.birth = birth;
    }
    
    

    public VipInfoImpl_Stub(String userID, String passpord, String telNum, Enum<po.UserType> userType, int creditValue,
            String enterpriseID, String enterprisePasspord) {
        super();
        this.userID = userID;
        this.passpord = passpord;
        this.telNum = telNum;
        UserType = userType;
        this.creditValue = creditValue;
        this.enterpriseID = enterpriseID;
        this.enterprisePasspord = enterprisePasspord;
    }



    @Override
    public VipInfoVO getRegularVipInfo(String userID) {
        return new VipInfoVO(userID, passpord, telNum, UserType, birth);
    }

    @Override
    public VipInfoVO getEnterpriseVipInfo(String userID) {
        return new VipInfoVO(userID, passpord, telNum,UserType, enterpriseID, enterprisePasspord);
                
    }
    
    
}
