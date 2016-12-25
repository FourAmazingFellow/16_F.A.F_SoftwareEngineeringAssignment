package po;

import java.util.ArrayList;

import vo.EnterpriseVipVO;

/**
 * 企业会员信息PO（继承于客户信息PO），负责持久化数据传输
 * @author sparkler
 * @version 1.0
 */
public class EnterpriseVipPO extends ClientInfoPO { 
    /**
	 * 
	 */
	private static final long serialVersionUID = -8906068652233749202L;
	

    private String enterpriseID;
    private String enterprisePassword;

    public EnterpriseVipPO() {
    	
    }
    
    public EnterpriseVipPO(String userID, String password, String telNum, po.UserType userType, int creditValue,
            ArrayList<CreditRecordPO> creditRecord, String enterpriseID, String enterprisePassword) {
        super(userID, password, telNum, userType, creditValue, creditRecord);
        this.enterpriseID = enterpriseID;
        this.enterprisePassword = enterprisePassword;
    }
    /**
     * @param enterpriseVip
     */
    public EnterpriseVipPO(EnterpriseVipVO enterpriseVipVO) {
        super(enterpriseVipVO);
        this.enterpriseID = enterpriseVipVO.enterpriseID;
        this.enterprisePassword = enterpriseVipVO.enterprisePassword;
    }
    

    public void setEnterpriseID(String enterpriseID){
        this.enterpriseID = enterpriseID;
    }
    public String getEnterpriseID(){
        return enterpriseID;
    }
    public void setEnterprisepassword(String enterprisepassword){
        this.enterprisePassword = enterprisepassword;
    }
    public String getEnterprisepassword(){
        return enterprisePassword;
    }
}
