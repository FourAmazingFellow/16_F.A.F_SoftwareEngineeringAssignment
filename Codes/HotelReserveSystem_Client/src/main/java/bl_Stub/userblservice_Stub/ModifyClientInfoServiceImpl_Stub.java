package bl_Stub.userblservice_Stub;

import businesslogicservice.userblservice.ModifyClientInfoService;
import po.UserType;
import vo.ClientInfoVO;
import vo.UserVO;

/**
 * 
 * @author 原
 * @version
 * @see
 */
public class ModifyClientInfoServiceImpl_Stub implements ModifyClientInfoService {

	public String userID;
	public String password;
	public String telNum;
	public UserType userType;
	public int creditValue;
	public String enterpriseName;

	public ModifyClientInfoServiceImpl_Stub(String userID, String password, String telNum, UserType userType,
			Integer creditValue, String enterpriseName) {
		this.userID = userID;
		this.password = password;
		this.telNum = telNum;
		this.userType = userType;
		this.creditValue = creditValue;
		this.enterpriseName = enterpriseName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @param userID
	 * 
	 * @return
	 * 
	 * @see
	 * businesslogicservice.userblservice.ModifyClientInfoService#getClientInfo(
	 * java.lang.String)
	 */
	@Override
	public ClientInfoVO getClientInfo(String userID) {
		if (userType == UserType.Client) {
			return new ClientInfoVO(userID, password, telNum, userType, creditValue, null);
		} else {
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @param user
	 * 
	 * @param oldUserID
	 * 
	 * @return
	 * 
	 * @see businesslogicservice.userblservice.ModifyClientInfoService#
	 * modifyClientInfo(vo.UserVO, java.lang.String)
	 */
	@Override
	public boolean modifyClientInfo(UserVO user, String oldUserID) {
		return true;
	}

}
