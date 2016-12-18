package presentation.userui.querycredit;

import java.util.ArrayList;
import java.util.List;

import vo.CreditRecordVO;
import vo.RoomVO;

public class CreditRecordList {

    private List<CreditRecord> creditRecordList;
    
    public List<CreditRecord> getCreditRecordList(){
        return creditRecordList;
    }
    
    public void setRoomList(ArrayList<CreditRecordVO> creditRecordVOs){
    	creditRecordList.clear();
        for(CreditRecordVO creditRecordVO:creditRecordVOs){
        	creditRecordList.add(new CreditRecord(creditRecordVO));
        }
    }
}
