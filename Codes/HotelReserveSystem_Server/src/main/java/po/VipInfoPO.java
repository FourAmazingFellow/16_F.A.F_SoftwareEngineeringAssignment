package po;

import java.sql.Date;

/**
 * 会员信息PO（继承于用户信息PO），负责持久化数据传输
 * @author sparkler
 * @version 1.0
 */
public class VipInfoPO extends UserPO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8906068652233749202L;
	
	private Date birth;
    private String enterpriseID;
    private String enterprisePassword;
    private int vipRank;
    
    public VipInfoPO(String userID, String password, String telNum, UserType userType, String enterpriseID,
            String enterprisePassword) {
        super(userID, password, telNum, userType);
        this.enterpriseID = enterpriseID;
        this.enterprisePassword = enterprisePassword;
    }
    public VipInfoPO(String userID, String password, String telNum, UserType userType, Date birth, int vipRank) {
        super(userID, password, telNum, userType);
        this.birth = birth;
        this.vipRank = vipRank;
    }
    
    
    public void setBirth(Date birth){
        this.birth = birth;
    }
    public Date getBirth(){
        return birth;
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
    public int getVipRank() {
        return vipRank;
    }
    public void setVipRank(int vipRank) {
        this.vipRank = vipRank;
    }
    
    
}
