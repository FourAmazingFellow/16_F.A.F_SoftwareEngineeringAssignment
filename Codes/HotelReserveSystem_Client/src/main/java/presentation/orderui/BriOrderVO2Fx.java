package presentation.orderui;

import vo.BriefOrderInfoVO;

public class BriOrderVO2Fx {
	public FxBriefOrder briefOrderVO2Fx(BriefOrderInfoVO vo){
		FxBriefOrder fxBriefOrder;
		
		fxBriefOrder = new FxBriefOrder(vo.userID, vo.orderID, vo.hotelName, vo.hotelAddress,
				vo.beginDate, vo.finishDate, vo.roomType, vo.num, vo.totalPrice, vo.orderState);
		
		return fxBriefOrder;
	}
}
