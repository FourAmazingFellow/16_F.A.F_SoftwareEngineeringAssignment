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

	 public long userID;
	 public String password;
	 public String telNum;
	 public UserType UserType;
	 public int creditValue;
	 public String enterpriseName;
	
	 public ModifyClientInfoServiceImpl_Stub(long userID, String password, String telNum, UserType userType,
			int creditValue, String enterpriseName) {
		this.userID = userID;
		this.password = password;
		this.telNum = telNum;
		UserType = userType;
		this.creditValue = creditValue;
		this.enterpriseName = enterpriseName;
	}
	 
	

    /* (non-Javadoc)
     * @param userID
     * @return
     * @see businesslogicservice.userblservice.ModifyClientInfoService#getClientInfo(java.lang.String)
     */
    @Override
    public ClientInfoVO getClientInfo(String userID) {
        return null;
    }

    /* (non-Javadoc)
     * @param user
     * @param oldUserID
     * @return
     * @see businesslogicservice.userblservice.ModifyClientInfoService#modifyClientInfo(vo.UserVO, java.lang.String)
     */
    @Override
    public boolean modifyClientInfo(UserVO user, String oldUserID) {
        return false;
    }

}
