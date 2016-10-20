package businesslogic.userbl;

/**
 * 
 * @author 原
 * @version 1.0
 * @see
 */
public interface EnterpriseInfo {

	/**
	 * 验证企业会员注册信息
	 * @param hotelName String型，注册企业会员对应的酒店名称
	 * @param enterpriseName String型，企业名称
	 * @param securityCode String型，企业验证码
	 * @return 如果验证通过返回true，验证不通过返回false
	 * @see
	 */
	public boolean verifyEnterpriseMember(String hotelName, String enterpriseName, String securityCode);
}
