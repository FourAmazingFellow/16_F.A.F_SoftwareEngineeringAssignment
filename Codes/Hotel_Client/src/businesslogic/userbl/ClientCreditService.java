package businesslogic.userbl;

/**
 * 
 * @author sparkler
 * @version 
 * @see
 */
public interface ClientCreditService {

    /**
     * 获取客户的信用值
     * @param ID long型，界面传递过来的用户标识
     * @return 返回客户当前信用值
     * @see
     */
    public int getCreditValue(long ID);
    
    /**
     * 改变客户的信用值（有订单变化）
     * @param ID long型，界面传递过来的用户标识
     * @param num int型，界面传递过来的增加的信用值
     * @return 改变成功则返回true，改变失败则返回false
     * @see
     */
    public boolean changeCreditValue(long ID,int num);
}
