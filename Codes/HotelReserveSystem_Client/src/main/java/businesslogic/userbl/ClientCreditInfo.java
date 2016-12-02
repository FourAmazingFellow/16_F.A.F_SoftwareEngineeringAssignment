package businesslogic.userbl;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import po.ActionType;

/**
 * 供同层间调用的关于信用值的接口
 * @author sparkler
 * @version 
 * @see
 */
public interface ClientCreditInfo {

    /**
     * 获取客户的信用值
     * @param ID long型，业务逻辑层传递过来的用户标识
     * @return 返回客户当前信用值
     * @see
     */
    public int getCreditValue(String userID);
    
    /**
     * 改变客户的信用值（有订单变化）
     * @param ID long型，业务逻辑层传递过来的用户标识
     * @param num int型，业务逻辑层传递过来的增加的信用值
     * @return 改变成功则返回true，改变失败则返回false
     * @see
     */
    public boolean changeCreditValue(String userID,int num,String orderID, ActionType actionType);
    

}
