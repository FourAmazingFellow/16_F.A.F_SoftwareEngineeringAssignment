package data_Stub;

import java.rmi.RemoteException;
import java.sql.Date;

import dataservice.userDAO.UserDAO;
import po.ClientInfoPO;
import po.HotelStaffInfoPO;
import po.UserPO;
import po.UserType;

public class UserDAOImpl_Stub implements UserDAO{
    
    public String userID;
    public String password;
    public String telNum;
    
    public int creditValue;
    public String[] creditRecord;
    
    public String enterpriseName;

    public Date birth;
    public String enterpriseID;
    public String enterprisePassword;
    
    public UserType userType;
    
    public UserDAOImpl_Stub(String userID, String password, String telNum) {
        super();
        this.userID = userID;
        this.password = password;
        this.telNum = telNum;
    }
    public UserDAOImpl_Stub(String userID, String password, String telNum, int creditValue, String[] creditRecord) {
        super();
        this.userID = userID;
        this.password = password;
        this.telNum = telNum;
        this.creditValue = creditValue;
        this.creditRecord = creditRecord;
    }
    public UserDAOImpl_Stub(String userID, String password, String telNum,
            Date birth) {
        super();
        this.userID = userID;
        this.password = password;
        this.telNum = telNum;
        this.birth = birth;
    }
    public UserDAOImpl_Stub(String userID, String password, String telNum, String enterpriseName,String enterprisePassword) {
        super();
        this.userID = userID;
        this.password = password;
        this.telNum = telNum;
        this.enterpriseName = enterpriseName;
        this.enterprisePassword = enterprisePassword;
    }

    
    @Override
    public UserPO getUserInfo(String userID, UserType userType) throws RemoteException {
        return new UserPO(userID, password, telNum, userType);
    }
    @Override
    public ClientInfoPO queryCreditRecord(String userID) throws RemoteException {
        return new ClientInfoPO(userID, password, telNum, userType, creditValue, creditRecord);
    }
    @Override
    public int getCreditValue(String userID) throws RemoteException {
        return creditValue;
    }
    @Override
    public void insertUser(UserPO po) throws RemoteException {
        System.out.println("Insert Succeed!\n");
    }
    @Override
    public void updateUser(UserPO po) throws RemoteException {
        System.out.println("Update Succeed!\n");
        
    }
	
    @Override
    public void insertClient(ClientInfoPO clientInfoPO) throws RemoteException {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void insertHotelStaff(HotelStaffInfoPO hotelStaffInfoPO) throws RemoteException {
        // TODO Auto-generated method stub
        
    }
    
}
