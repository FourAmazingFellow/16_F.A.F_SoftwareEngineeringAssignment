package data_Stub;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import dataservice.userDAO.UserDAO;
import po.ClientInfoPO;
import po.CreditRecordPO;
import po.EnterpriseVipPO;
import po.HotelStaffInfoPO;
import po.RegularVipPO;
import po.UserPO;
import po.UserType;

public class UserDAOImpl_Stub implements UserDAO{
    
    public String userID;
    public String password;
    public String telNum;
    
    public int creditValue;
    public ArrayList<CreditRecordPO> creditRecord;
    
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
    public UserDAOImpl_Stub(String userID, String password, String telNum, int creditValue, ArrayList<CreditRecordPO> creditRecord) {
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
    public UserPO getUserInfo(String userID) throws RemoteException {
        return new UserPO(userID, password, telNum, userType);
    }
    @Override
    public ArrayList<CreditRecordPO> queryCreditRecord(String userID) throws RemoteException {
        return null;
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
    @Override
    public ClientInfoPO getClientInfo(String userID) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public HotelStaffInfoPO getHotelStaffInfo(String userID) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public void updateClient(ClientInfoPO clientInfoPO) throws RemoteException {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void signRegularVip(RegularVipPO regularVipPO) throws RemoteException {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void signEnterpriseVip(EnterpriseVipPO enterpriseVipPO) throws RemoteException {
        // TODO Auto-generated method stub
        
    }
    @Override
    public RegularVipPO getRegularVipInfo(String userID) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public EnterpriseVipPO getEnterpriseVipInfo(String userID) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
