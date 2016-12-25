package po;

import java.io.Serializable;
import java.sql.Date;

/**
 * 客户信用记录的PO，负责持久化数据传输
 * @author sparkler
 * @version 
 * @see
 */
public class CreditRecordPO implements Serializable {
	private static final long serialVersionUID = -1560844507837087960L;	
    private Date changeTime;
    private String orderID;
    private ActionType action;
    private int process;
    private int creditResult;
    
    public CreditRecordPO(Date changeTime, String orderID, ActionType action, int process, int creditResult) {
        super();
        this.changeTime = changeTime;
        this.orderID = orderID;
        this.action = action;
        this.process = process;
        this.creditResult = creditResult;
    }

    public Date getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(Date changeTime) {
        this.changeTime = changeTime;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public ActionType getAction() {
        return action;
    }

    public void setAction(ActionType action) {
        this.action = action;
    }

    public int getProcess() {
        return process;
    }

    public void setProcess(int process) {
        this.process = process;
    }

    public int getCreditResult() {
        return creditResult;
    }

    public void setCreditResult(int creditResult) {
        this.creditResult = creditResult;
    }
    
    
}
