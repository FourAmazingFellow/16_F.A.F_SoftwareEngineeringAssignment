package po;

import java.util.Date;
import java.util.ArrayList;

import vo.RegularVipVO;

public class RegularVipPO extends ClientInfoPO{

    /**
     * 
     */
    private static final long serialVersionUID = -8928180744998954863L;

    private Date birth;
    private int vipRank;
    
    
    public RegularVipPO() {
    	
    }
    
    public RegularVipPO(String userID, String password, String telNum, po.UserType userType, int creditValue,
            ArrayList<CreditRecordPO> creditRecord, Date birth, int vipRank) {
        super(userID, password, telNum, userType, creditValue, creditRecord);
        this.birth = birth;
        this.vipRank = vipRank;
    }
    /**
     * @param regularVip
     */
    public RegularVipPO(RegularVipVO regularVipVO) {
        super(regularVipVO);
        this.birth = regularVipVO.birth;
        this.vipRank = regularVipVO.vipRank;
    }

    public Date getBirth() {
        return birth;
    }
    public void setBirth(Date birth) {
        this.birth = birth;
    }
    public int getVipRank() {
        return vipRank;
    }
    public void setVipRank(int vipRank) {
        this.vipRank = vipRank;
    }
    
    

}
