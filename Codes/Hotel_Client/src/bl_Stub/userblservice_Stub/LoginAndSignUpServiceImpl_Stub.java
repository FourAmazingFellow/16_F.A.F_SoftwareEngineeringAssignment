package bl_Stub.userblservice_Stub;

import businesslogicservice.userblservice.LoginAndSignUpService;
import vo.UserVO;

/**
 * 
 * @author 原
 * @version
 * @see
 */
public class LoginAndSignUpServiceImpl_Stub implements LoginAndSignUpService {

	@Override
	public boolean login(String userID, String password) {
		return true;
	}

	@Override
	public boolean add(UserVO user) {
		return true;
	}

}
