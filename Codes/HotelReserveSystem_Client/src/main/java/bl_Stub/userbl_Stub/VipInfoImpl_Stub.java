package bl_Stub.userbl_Stub;

import java.sql.Date;

import businesslogic.userbl.VipInfo;
import po.UserType;
import vo.EnterpriseVipVO;
import vo.RegularVipVO;

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
    public RegularVipVO getRegularVipInfo(String userID) {
        return new RegularVipVO(userID, password, telNum, UserType, creditValue, null, birth, creditValue);
    }

    @Override
    public EnterpriseVipVO getEnterpriseVipInfo(String userID) {
        return new EnterpriseVipVO(userID, password, telNum,UserType, creditValue, null, enterpriseID, enterprisepassword);
                
    }
    
    
}
