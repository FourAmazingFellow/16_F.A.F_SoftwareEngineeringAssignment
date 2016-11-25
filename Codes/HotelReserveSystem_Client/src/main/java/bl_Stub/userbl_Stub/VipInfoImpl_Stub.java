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
    public String password;
    public String telNum;
    public UserType UserType;
    public int creditValue;
    public Date birth;
    public String enterpriseID;
    public String enterprisepassword;
    


    public VipInfoImpl_Stub(String userID, String password, String telNum, UserType userType, int creditValue,
            Date birth) {
        super();
        this.userID = userID;
        this.password = password;
        this.telNum = telNum;
        UserType = userType;
        this.creditValue = creditValue;
        this.birth = birth;
    }
    
    

    public VipInfoImpl_Stub(String userID, String password, String telNum, UserType userType, int creditValue,
            String enterpriseID, String enterprisepassword) {
        super();
        this.userID = userID;
        this.password = password;
        this.telNum = telNum;
        UserType = userType;
        this.creditValue = creditValue;
        this.enterpriseID = enterpriseID;
        this.enterprisepassword = enterprisepassword;
    }



    @Override
    public VipInfoVO getRegularVipInfo(String userID) {
        return new VipInfoVO(userID, password, telNum, UserType, creditValue, null, birth, creditValue);
    }

    @Override
    public VipInfoVO getEnterpriseVipInfo(String userID) {
        return new VipInfoVO(userID, password, telNum,UserType, creditValue, null, enterpriseID, enterprisepassword);
                
    }
    
    
}
