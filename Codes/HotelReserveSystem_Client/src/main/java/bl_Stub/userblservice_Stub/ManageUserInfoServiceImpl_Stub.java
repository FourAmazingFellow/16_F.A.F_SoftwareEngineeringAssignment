package bl_Stub.userblservice_Stub;

import businesslogicservice.userblservice.ManageUserInfoService;
import po.UserType;
import vo.UserVO;

/**
 * 
 * @author 原
 * @version
 * @see
 */
public class ManageUserInfoServiceImpl_Stub extends ModifyClientInfoServiceImpl_Stub implements ManageUserInfoService{

	public ManageUserInfoServiceImpl_Stub(long userID, String password, String telNum, UserType userType,
			int creditValue, String enterpriseName) {
		super(userID, password, telNum, userType, creditValue, null);
	}

	@Override
	public boolean add(UserVO user) {
		return true;
	}

	@Override
	public UserVO getUserInfo(String userID, UserType client) {
		return super.getUserInfo(userID, client);
	}

	
	
}
