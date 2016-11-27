package businesslogic.userbl;

import vo.EnterpriseVipVO;
import vo.RegularVipVO;

/**
 * 供同层间调用的关于会员信息的接口
 * @author sparkler
 * @version 
 * @see
 */
public interface VipInfo {

    /**
     * 获取普通会员信息
     * @param ID String型，业务逻辑层传递过来的用户标识
     * @return 返回普通会员信息
     * @see
     */
    public RegularVipVO getRegularVipInfo(String userID);
    
    /**
     * 获取企业会员信息
     * @param ID String型，业务逻辑层传递过来的用户标识
     * @return 返回企业会员信息
     * @see
     */
    public EnterpriseVipVO getEnterpriseVipInfo(String userID);
}
