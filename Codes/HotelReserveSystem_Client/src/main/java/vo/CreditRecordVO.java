package vo;

import java.sql.Date;
import java.util.ArrayList;

import po.ActionType;
import po.ClientInfoPO;
import po.CreditRecordPO;

public class CreditRecordVO {
    public String userID;
    public Date changeTime;
    public String orderID;
    public ActionType action;
    public int process;
    public int creditResult;
    public ArrayList<CreditRecordPO> creditRecord;
    
    public CreditRecordVO(String userID, ArrayList<CreditRecordPO> creditRecord) {
        super();
        this.userID = userID;
        this.creditRecord = creditRecord;
    }
    
    public CreditRecordVO(Date changeTime, String orderID, ActionType action, int process, int creditResult) {
		super();
		this.changeTime = changeTime;
		this.orderID = orderID;
		this.action = action;
		this.process = process;
		this.creditResult = creditResult;
	}

	public CreditRecordVO(ClientInfoPO clientInfoPO){
        this.userID = clientInfoPO.getUserID();
        creditRecord = clientInfoPO.getCreditRecord();
    }

	public CreditRecordVO(CreditRecordPO creditRecordPO) {
		this.changeTime = creditRecordPO.getChangeTime();
		this.orderID = creditRecordPO.getOrderID();
		this.action = creditRecordPO.getAction();
		this.process = creditRecordPO.getProcess();
		this.creditResult = creditRecordPO.getCreditResult();
		
	}
}
