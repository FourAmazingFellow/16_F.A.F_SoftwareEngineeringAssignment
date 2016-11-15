package businesslogic.userbl;

/**
 * 
 * @author 原
 * @version 1.1
 * @see
 */
public interface StrategyInfo {

	/**
	 * 验证企业会员注册信息
	 * @param enterpriseName String型，企业名称
	 * @param securityCode String型，企业验证码
	 * @return 如果验证通过返回true，验证不通过返回false
	 * @see
	 */
	public boolean verifyEnterpriseMember(String enterpriseName, String securityCode);
}
