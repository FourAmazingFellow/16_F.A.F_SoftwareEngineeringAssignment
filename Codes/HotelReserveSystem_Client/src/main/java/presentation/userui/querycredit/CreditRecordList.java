package presentation.userui.querycredit;

import java.util.ArrayList;
import java.util.List;

import vo.CreditRecordVO;

/**
 * creditRecordList模型类
 * 
 * @author sparkler
 * @version
 * @see
 */
public class CreditRecordList {

	private List<CreditRecord> creditRecordList = new ArrayList<>();

	public List<CreditRecord> getCreditRecordList() {
		return creditRecordList;
	}

	public void setCreditRecordList(ArrayList<CreditRecordVO> creditRecordVOs) {
		creditRecordList.clear();
		for (CreditRecordVO creditRecordVO : creditRecordVOs) {
			creditRecordList.add(new CreditRecord(creditRecordVO));
		}
	}

}
