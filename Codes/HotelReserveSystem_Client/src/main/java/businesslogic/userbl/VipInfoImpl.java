package businesslogic.userbl;

import java.sql.Date;

import po.UserType;
import vo.EnterpriseVipVO;
import vo.RegularVipVO;

public class VipInfoImpl implements VipInfo {
    private RegularVipVO regularVipVO;
    private EnterpriseVipVO enterpriseVipVO;
    private UserType userType = UserType.Client;
    private String userID;
    private String password;
    private String telNum;
    private Date birth;
    private String enterpriseID;
    private String enterprisePassword;

    @Override
    public RegularVipVO getRegularVipInfo(String userID) {
        this.userID = userID;
        // this.vipInfoVO = (VipInfoVO) new VipInfoVO((VipInfoPO)
        // userDAO.getUserInfo(userID, userType));
        this.regularVipVO = new RegularVipVO(this.userID, password, telNum, userType, 0, null, birth, 0);
        return regularVipVO;
    }

    @Override
    public EnterpriseVipVO getEnterpriseVipInfo(String userID) {
        this.userID = userID;
        // this.vipInfoVO = (VipInfoVO) new VipInfoVO((VipInfoPO)
        // userDAO.getUserInfo(userID, userType));
        this.enterpriseVipVO = new EnterpriseVipVO(this.userID, password, telNum, userType, 0, null, enterpriseID, enterprisePassword);
        return enterpriseVipVO;
    }

}
