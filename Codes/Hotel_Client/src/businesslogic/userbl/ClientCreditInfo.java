package businesslogic.userbl;

import vo.ClientCreditRecordVO;

/**
 * 
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
    public boolean changeCreditValue(String userID,int num);
    
    /**
     * 获得客户的信用记录
     * @param userID String型，业务逻辑层传来的用户标识
     * @return 返回客户的信用记录
     * @see
     */
    public ClientCreditRecordVO getClientCreditInfo(String userID);
}
