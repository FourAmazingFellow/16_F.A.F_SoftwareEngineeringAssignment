package businesslogic.userbl.addCreditValue;

import java.rmi.RemoteException;

import businesslogicservice.userblservice.AddCreditValueService;
import dataservice.userDAO.UserDAO;
import po.ClientInfoPO;
import po.UserType;
import vo.UserVO;

public class AddCreditValueServiceImpl implements AddCreditValueService {
    UserDAO userDAO;
    UserVO clientInfoVO;
    String userID;
    UserType userType;
    int creditValue;
    
    public AddCreditValueServiceImpl(String userID, UserType userType) {
        try {
            this.clientInfoVO = new UserVO(userDAO.getUserInfo(userID, userType));
        } catch (RemoteException e) {
            e.printStackTrace();
        }    
    }
    
    @Override
    public boolean addCreditValue(String userID, int creditAdded) {
        this.userID = userID;
        ClientInfoPO clientInfoPO = new ClientInfoPO(this.userID, null, null, null, creditValue, null);
        creditValue = clientInfoPO.getCreditValue();
        try {
            userDAO.updateUser(new ClientInfoPO(userID, null, null, userType, creditValue+creditAdded, null));;
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }
	

}
