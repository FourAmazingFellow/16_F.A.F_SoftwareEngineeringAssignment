package presentation.orderui;

import vo.BriefOrderInfoVO;

/**
 * 把逻辑层的OrderVO转化为JavaFX自定义Model的工具类
 * @author Accident
 * @version 1.0
 * @see
 */
public class BriOrderVO2Fx {
	public FxBriefOrder briefOrderVO2Fx(BriefOrderInfoVO vo){
		FxBriefOrder fxBriefOrder;
		
		fxBriefOrder = new FxBriefOrder(vo.userID, vo.orderID, vo.hotelName, vo.hotelAddress,
				vo.beginDate, vo.finishDate, vo.roomType, vo.num, vo.totalPrice, vo.orderState);
		
		return fxBriefOrder;
	}
}
