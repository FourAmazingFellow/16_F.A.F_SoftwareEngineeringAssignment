package businesslogic.userbl;

import java.sql.Date;

import po.UserType;
import vo.VipInfoVO;

public class VipInfoImpl implements VipInfo {

    private VipInfoVO vipInfoVO;
    private UserType userType = UserType.Client;
    private String userID;
    private String password;
    private String telNum;
    private Date birth;
    private String enterpriseID;
    private String enterprisePassword;

    @Override
    public VipInfoVO getRegularVipInfo(String userID) {
        this.userID = userID;
        // this.vipInfoVO = (VipInfoVO) new VipInfoVO((VipInfoPO)
        // userDAO.getUserInfo(userID, userType));
        this.vipInfoVO = new VipInfoVO(this.userID, password, telNum, userType, 0, null, birth, 0);
        return vipInfoVO;
    }

    @Override
    public VipInfoVO getEnterpriseVipInfo(String userID) {
        this.userID = userID;
        // this.vipInfoVO = (VipInfoVO) new VipInfoVO((VipInfoPO)
        // userDAO.getUserInfo(userID, userType));
        this.vipInfoVO = new VipInfoVO(this.userID, password, telNum, userType, 0, null, enterpriseID, enterprisePassword);
        return vipInfoVO;
    }

}
