package businesslogicservice.userblservice;


import java.rmi.RemoteException;

import vo.EnterpriseVipVO;
import vo.RegularVipVO;

/**
 * 
 * @author sparkler
 * @version 
 * @see
 */
public interface SignVipService {

    /**
     * 注册普通会员
     * @param regularVip UserVO型，界面传递过来的普通会员信息
     * @return 注册成功则返回true，注册失败则返回false
     * @throws RemoteException 
     * @see
     */
    public boolean signRegularVip(RegularVipVO regularVip) throws RemoteException;
    
    /**
     * 注册企业会员
     * @param EnterpriseVip UserVO型，界面传递过来的企业会员信息
     * @return 注册成功则返回true，注册失败则返回false
     * @throws RemoteException 
     * @see
     */
    public boolean signEnterpriseVip(EnterpriseVipVO EnterpriseVip) throws RemoteException;
}
