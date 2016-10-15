package po;

import java.sql.Date;

/**
 * 
 * @author sparkler
 * @version 1.0
 */
public class VipInfoPO extends HotelPO {
    private Date birth;
    private String enterpriseID;
    private String enterprisePasspord;
    
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
    public void setEnterprisePasspord(String enterprisePasspord){
        this.enterprisePasspord = enterprisePasspord;
    }
    public String getEnterprisePasspord(){
        return enterprisePasspord;
    }
}
