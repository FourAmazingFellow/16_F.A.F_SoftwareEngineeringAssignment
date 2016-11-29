package businesslogic.userbl.mamageUserInfo;

import java.rmi.RemoteException;

import businesslogicservice.userblservice.ManageUserInfoService;
import dataservice.userDAO.UserDAO;
import po.UserPO;
import vo.HotelStaffInfoVO;
import vo.UserVO;

/**
 * 
 * @author sparkler
 * @version
 * @see
 */
public class ManageUserInfoServiceImpl implements ManageUserInfoService{

    private UserDAO userDAO;
    
    public void setUserDAO(UserDAO userDAO){
        this.userDAO = userDAO;
    }
    
    public ManageUserInfoServiceImpl(String userID) {
    }

    /* (non-Javadoc)
     * @param user
     * @return
     * @see businesslogicservice.userblservice.ManageUserInfoService#add(vo.UserVO)
     */
    @Override
    public boolean add(UserVO user) {
        try {
            userDAO.insertUser(new UserPO(user));
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* (non-Javadoc)
     * @param userID
     * @return
     * @see businesslogicservice.userblservice.ManageUserInfoService#getHotelStaffInfo(java.lang.String)
     */
    @Override
    public HotelStaffInfoVO getHotelStaffInfo(String userID) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @param userID
     * @return
     * @see businesslogicservice.userblservice.ManageUserInfoService#getUserInfo(java.lang.String)
     */
    @Override
    public UserVO getUserInfo(String userID) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @param userVO
     * @param userID
     * @return
     * @see businesslogicservice.userblservice.ManageUserInfoService#modifyUserInfo(vo.UserVO, java.lang.String)
     */
    @Override
    public boolean modifyUserInfo(UserVO userVO, String userID) {
        // TODO Auto-generated method stub
        return false;
    }

}
