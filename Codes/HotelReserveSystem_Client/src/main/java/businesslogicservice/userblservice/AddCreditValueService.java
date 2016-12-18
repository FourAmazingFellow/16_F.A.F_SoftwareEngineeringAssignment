package businesslogicservice.userblservice;

import java.rmi.RemoteException;

public interface AddCreditValueService {
	
	 /**
     * 增加用户的信用值（信用充值）
     * @param ID long型，界面传递过来的用户标识
     * @param creditAdded int型，界面传递过来的增加的信用值
     * @return 增加信用值成功则返回true，失败则返回false
	 * @throws RemoteException 
     * @see
     */
    public boolean addCreditValue(String userID,int creditAdded) throws RemoteException;
}
