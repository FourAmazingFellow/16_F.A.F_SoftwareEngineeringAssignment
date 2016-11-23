package org.FAF.businesslogic.userbl.queryClientCreditRecord;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import businesslogic.userbl.queryClientCreditRecord.MockQueryClientCreditRecordServiceImpl;
import businesslogic.userbl.queryClientCreditRecord.QueryClientCreditRecordServiceImpl;
import po.UserType;
import vo.UserVO;

/**
 * 
 * @author sparkler
 * @version 1.0
 * @see
 */
public class QueryClientCreditRecordServiceImplTest {
    @SuppressWarnings("unused")
    private QueryClientCreditRecordServiceImpl queryClientCreditRecord;
    private String userID;
    private String password;
    private String telNum;
    private UserType userType;
//    private String[] creditRecord = null;
    
    @Before
    public void setUp() throws Exception {
        this.userID = "原";
        this.password = "qwe123";
        this.telNum = "12345678900";
        this.userType = UserType.Client;
    }
    
    @Test
    public void queryCreditRecord() {
       queryClientCreditRecord = new MockQueryClientCreditRecordServiceImpl();
       UserVO userVO = new UserVO(this.userID, this.password, this.telNum, this.userType);
       assertEquals("QueryClientCreditRecordService.queryCreditRecord(userID) has an error in userID!", userID, userVO.userID);        
       assertEquals("QueryClientCreditRecordService.queryCreditRecord(userID) has an error in password!", password, userVO.password);        
       assertEquals("QueryClientCreditRecordService.queryCreditRecord(userID) has an error in telNum!", telNum, userVO.telNum);        
//       assertEquals("QueryClientCreditRecordService.queryCreditRecord(userID) has an error in creditRecord!", creditRecord, queryClientCreditRecord.queryCreditRecord(userID));        
    }


    
}