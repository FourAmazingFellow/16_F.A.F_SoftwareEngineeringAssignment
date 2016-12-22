package vo;

import java.sql.Date;

import po.ActionType;
import po.CreditRecordPO;

public class CreditRecordVO {
    public String userID;
    public Date changeTime;
    public String orderID;
    public ActionType action;
    public int process;
    public int creditResult;
    
    public CreditRecordVO(Date changeTime, String orderID, ActionType action, int process, int creditResult) {
		super();
		this.changeTime = changeTime;
		this.orderID = orderID;
		this.action = action;
		this.process = process;
		this.creditResult = creditResult;
	}

	public CreditRecordVO(CreditRecordPO creditRecordPO) {
		this.changeTime = creditRecordPO.getChangeTime();
		this.orderID = creditRecordPO.getOrderID();
		this.action = creditRecordPO.getAction();
		this.process = creditRecordPO.getProcess();
		this.creditResult = creditRecordPO.getCreditResult();
		
	}
}
