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
    public boolean add(UserVO user) throws RemoteException {
        this.userDAO = RemoteHelper.getInstance().getUserDAO();
        userDAO.insertUser(new UserPO(user));
        return true;
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
    public HotelStaffInfoVO getHotelStaffInfo(String userID) throws RemoteException {
        this.userDAO = RemoteHelper.getInstance().getUserDAO();
        this.userID = userID;
        this.hotelStaffInfoVO = new HotelStaffInfoVO(userDAO.getHotelStaffInfo(this.userID));
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
    public UserVO getUserInfo(String userID) throws RemoteException {
        this.userDAO = RemoteHelper.getInstance().getUserDAO();
        this.userID = userID;
        this.userVO = new UserVO(userDAO.getUserInfo(this.userID));
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
    public boolean modifyUserInfo(UserVO userVO, String userID) throws RemoteException {
        this.userDAO = RemoteHelper.getInstance().getUserDAO();
        userDAO.updateUser(new UserPO(userVO), userID);
        return true;
    }

}
