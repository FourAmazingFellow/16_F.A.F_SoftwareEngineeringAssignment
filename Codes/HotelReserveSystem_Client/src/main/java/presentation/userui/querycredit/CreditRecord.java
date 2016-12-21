package presentation.userui.querycredit;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import po.ActionType;
import presentation.userui.DateToString;
import vo.CreditRecordVO;

public class CreditRecord {
	private StringProperty userID;;
	private StringProperty changeTime;
    private StringProperty orderID;
    private StringProperty action;
    private StringProperty process;
    private StringProperty creditResult;
    private DateToString trans;
    
	public CreditRecord(CreditRecordVO creditRecordVO) {
		this.changeTime = new SimpleStringProperty(trans.dateToString(creditRecordVO.changeTime));
		this.orderID = new SimpleStringProperty(creditRecordVO.orderID);
		this.action = new SimpleStringProperty(ActionType.enumToChinese(creditRecordVO.action));
		this.process = new SimpleStringProperty(String.valueOf(creditRecordVO.process));
		this.creditResult = new SimpleStringProperty(String.valueOf(creditRecordVO.creditResult));

	}

	public StringProperty userIDProperty() {
		return userID;
	}

	public StringProperty changeTimeProperty() {
		return changeTime;
	}

	public StringProperty orderIDProperty() {
		return orderID;
	}

	public StringProperty actionProperty() {
		return action;
	}
	public StringProperty processProperty() {
		return process;
	}
	public StringProperty creditResultProperty() {
		return creditResult;
	}

	public StringProperty getUserID() {
		return userID;
	}

	
	public void setUserID(String userID) {
		this.userID.set(userID);
	}

	public Date getChangeTime() {
		return trans.stringToDate(changeTime.get());
	}

	public void setChangeTime(Date changeTime) {
		this.changeTime.set(trans.dateToString(changeTime));
	}

	public String getOrderID() {
		return orderID.get();
	}

	public void setOrderID(String orderID) {
		this.orderID.set(orderID);
	}

	public ActionType getAction() {
		return ActionType.chineseToEnum(action.get());
	}

	public void setAction(ActionType action) {
		this.action.set(ActionType.enumToChinese(action));
	}

	public int getProcess() {
		return Integer.parseInt(process.get());
	}

	public void setProcess(int process) {
		this.process.set(String.valueOf(process));;
	}

	public int getCreditResult() {
		return Integer.parseInt(creditResult.get());
	}

	public void setCreditResult(int creditResult) {
		this.creditResult.set(String.valueOf(creditResult));
	}
	
	public Date getDate(String dateStr) {
		java.util.Date date = null;
		  SimpleDateFormat formater = new SimpleDateFormat();  
	        formater.applyPattern("yyyy/MM/dd"); 
	        try {  
	            date = formater.parse(dateStr);  
	        } catch (ParseException e) {  
	            e.printStackTrace();  
	        }  
		return (Date) date;
	}
	
}
