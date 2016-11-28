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
    
    public AddCreditValueServiceImpl() {
        try {
            this.clientInfoVO = new UserVO(userDAO.getUserInfo(userID));
        } catch (RemoteException e) {
            e.printStackTrace();
        }    
    }

    @Override
    public boolean addCreditValue(String userID, int creditAdded) {
        this.userID = userID;
        ClientInfoPO clientInfoPO = null;
        try {
            clientInfoPO = userDAO.getClientInfo(this.userID);
        } catch (RemoteException e1) {
            e1.printStackTrace();
        }
        creditValue = clientInfoPO.getCreditValue();
        try {
            userDAO.updateUser(new ClientInfoPO(userID, null, null, userType, creditValue+creditAdded, null), "原");;
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }
	

}
