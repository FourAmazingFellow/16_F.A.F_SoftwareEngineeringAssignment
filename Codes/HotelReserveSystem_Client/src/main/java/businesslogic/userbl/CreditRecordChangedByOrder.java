/**
 * 
 */
package businesslogic.userbl;

import vo.CreditRecordVO;

/**
 * @author sparkler
 * @version 
 * @see
 */
public interface CreditRecordChangedByOrder {
    //userID不能唯一标识 某一条信用记录，参数要修改
    public CreditRecordVO getOrderRecord(String userID);
}
