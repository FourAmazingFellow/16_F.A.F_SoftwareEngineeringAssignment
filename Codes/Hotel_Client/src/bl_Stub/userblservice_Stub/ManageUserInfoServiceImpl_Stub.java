package bl_Stub.userblservice_Stub;

import businesslogicservice.userblservice.ManageUserInfoService;
import vo.UserType;
import vo.UserVO;
import vo.WebMarketStaffInfoVO;

/**
 * 
 * @author 原
 * @version
 * @see
 */
public class ManageUserInfoServiceImpl_Stub extends ModifyClientInfoServiceImpl_Stub implements ManageUserInfoService{

	public ManageUserInfoServiceImpl_Stub(long userID, String passpord, String telNum, UserType userType,
			int creditValue, String enterpriseName) {
		super(userID, passpord, telNum, userType, creditValue, enterpriseName);
	}

	@Override
	public boolean add(WebMarketStaffInfoVO webMarketStaff) {
		return true;
	}

	@Override
	public UserVO getUserInfo(String userID, UserType client) {
		return super.getUserInfo(userID, client);
	}

	
	
}
