package businesslogic.userbl.mamageUserInfo;

import java.rmi.RemoteException;

import businesslogicservice.userblservice.ManageUserInfoService;
import dataservice.userDAO.UserDAO;
import po.UserPO;
import rmi.RemoteHelper;
import vo.HotelStaffInfoVO;
import vo.UserVO;

/**
 * 
 * @author sparkler
 * @version
 * @see
 */
public class ManageUserInfoServiceImpl implements ManageUserInfoService {

    private UserDAO userDAO;
    private String userID;
    private UserVO userVO;
    private HotelStaffInfoVO hotelStaffInfoVO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public ManageUserInfoServiceImpl() {
    }

    /*
     * (non-Javadoc)
     * 
     * @param user
     * 
     * @return
     * 
     * @see
     * businesslogicservice.userblservice.ManageUserInfoService#add(vo.UserVO)
     */
    @Override
    public boolean add(UserVO user) {
        this.userDAO = RemoteHelper.getInstance().getUserDAO();
        try {
            userDAO.insertUser(new UserPO(user));
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @param userID
     * 
     * @return
     * 
     * @see businesslogicservice.userblservice.ManageUserInfoService#
     * getHotelStaffInfo(java.lang.String)
     */
    @Override
    public HotelStaffInfoVO getHotelStaffInfo(String userID) {
        this.userDAO = RemoteHelper.getInstance().getUserDAO();
        this.userID = userID;
        try {
            this.hotelStaffInfoVO = new HotelStaffInfoVO(userDAO.getHotelStaffInfo(this.userID));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return hotelStaffInfoVO;
    }

    /*
     * (non-Javadoc)
     * 
     * @param userID
     * 
     * @return
     * 
     * @see
     * businesslogicservice.userblservice.ManageUserInfoService#getUserInfo(java
     * .lang.String)
     */
    @Override
    public UserVO getUserInfo(String userID) {
        this.userDAO = RemoteHelper.getInstance().getUserDAO();
        this.userID = userID;
        try {
            this.userVO = new UserVO(userDAO.getUserInfo(this.userID));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return userVO;
    }

    /*
     * (non-Javadoc)
     * 
     * @param userVO
     * 
     * @param userID
     * 
     * @return
     * 
     * @see
     * businesslogicservice.userblservice.ManageUserInfoService#modifyUserInfo(
     * vo.UserVO, java.lang.String)
     */
    @Override
    public boolean modifyUserInfo(UserVO userVO, String userID) {
        this.userDAO = RemoteHelper.getInstance().getUserDAO();
        try {
            userDAO.updateUser(new UserPO(userVO), userID);
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

}
