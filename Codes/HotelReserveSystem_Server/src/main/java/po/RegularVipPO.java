package po;

import java.sql.Date;
import java.util.ArrayList;

/**
 * 普通会员信息的PO，负责持久化数据运输
 * 
 * @author sparkler
 * @version
 * @see
 */
public class RegularVipPO extends ClientInfoPO {

	private static final long serialVersionUID = -8928180744998954863L;

	private Date birth;
	private int vipRank;

	public RegularVipPO() {

	}

	public RegularVipPO(String userID, String password, String telNum, po.UserType userType, int creditValue,
			ArrayList<CreditRecordPO> creditRecord, Date birth, int vipRank) {
		super(userID, password, telNum, userType, creditValue, creditRecord);
		this.birth = birth;
		this.vipRank = vipRank;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public int getVipRank() {
		return vipRank;
	}

	public void setVipRank(int vipRank) {
		this.vipRank = vipRank;
	}

}
