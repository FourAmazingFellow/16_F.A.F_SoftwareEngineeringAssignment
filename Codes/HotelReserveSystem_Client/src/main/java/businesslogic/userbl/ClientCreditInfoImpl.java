package businesslogic.userbl;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import dataservice.userDAO.UserDAO;
import po.ActionType;
import po.ClientInfoPO;
import po.CreditRecordPO;
import po.RegularVipPO;
import po.UserType;
import rmi.RemoteHelper;

public class ClientCreditInfoImpl implements ClientCreditInfo{

    private UserDAO userDAO;
    private String userID;
    private int creditValue;
    private int creditResult;
    private int vipRank;
    private String orderID;
    private ActionType actionType;
    private ArrayList<CreditRecordPO> creditRecord;
    private ClientInfoPO clientInfoPO;
    
    public void setUserDAO(UserDAO userDAO){
        this.userDAO = userDAO;
    }
    
    @Override
    public int getCreditValue(String userID) {
     //   userDAO = RemoteHelper.getInstance().getUserDAO();
        this.userID = userID;
        this.creditValue = 0;
        try {
            this.creditValue = userDAO.getCreditValue(this.userID);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return creditValue;
    }

    @Override
    public boolean changeCreditValue(String userID, int num, String orderID, ActionType actionType) {
   //     userDAO = RemoteHelper.getInstance().getUserDAO();
        this.userID = userID;
        this.creditValue = 0;
        try {
            this.clientInfoPO = userDAO.getClientInfo(this.userID);
        } catch (RemoteException e1) {
            e1.printStackTrace();
        }
        creditValue = clientInfoPO.getCreditValue();
        this.creditResult = creditValue + num;
        
      //update普通会员vipRank
        RegularVipPO regularVipPO = null;
        try {
            regularVipPO = userDAO.getRegularVipInfo(this.userID);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
        if (regularVipPO != null) {
            if (creditResult <= 600)
                this.vipRank = 0;
            else if (creditResult > 600 && creditResult <= 2000)
                this.vipRank = 1;
            else if (creditResult > 2000 && creditResult <= 6000)
                this.vipRank = 2;
            else if (creditResult > 6000 && creditResult <= 12000)
                this.vipRank = 3;
            else if (creditResult > 12000)
                this.vipRank = 4;

            RegularVipPO modifiedVipRank = new RegularVipPO(regularVipPO.getUserID(),
                    regularVipPO.getPassword(), regularVipPO.getTelNum(), UserType.Client, creditResult, creditRecord,
                    regularVipPO.getBirth(), vipRank);
            try {
                userDAO.updateRegularVipInfo(modifiedVipRank);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        //update信用记录和信用值
        this.creditRecord = new ArrayList<>();
        creditRecord = clientInfoPO.getCreditRecord();
        CreditRecordPO creditRecordPO = new CreditRecordPO(new Date(System.currentTimeMillis()), orderID,
                actionType, num, creditResult);
        creditRecord.add(creditRecordPO);
        
        ClientInfoPO modified = new ClientInfoPO(clientInfoPO.getUserID(), clientInfoPO.getPassword(), clientInfoPO.getTelNum(), UserType.Client, creditResult, creditRecord);
        try {
            userDAO.updateClient(modified, this.userID);
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

}
