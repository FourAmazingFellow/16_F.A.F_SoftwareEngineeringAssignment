package vo;


import java.sql.Date;
import java.util.ArrayList;

import po.CreditRecordPO;
import po.RegularVipPO;
import po.UserType;
/**
 * 普通会员信息的值对象
 * @author sparkler
 * @version 
 * @see
 */
public class RegularVipVO extends ClientInfoVO{

    public Date birth;
    public int vipRank;
    
    public RegularVipVO(String userID, String password, String telNum, UserType userType, int creditValue,
            ArrayList<CreditRecordPO> creditRecord, Date birth, int vipRank) {
        super(userID, password, telNum, userType, creditValue, creditRecord);
        this.birth = birth;
        this.vipRank = vipRank;
    }

    /**
     * @param regularVipInfo
     */
    public RegularVipVO(RegularVipPO regularVipPO) {
        super(regularVipPO);
        this.birth = regularVipPO.getBirth();
        this.vipRank = regularVipPO.getVipRank();
    }
  
}
