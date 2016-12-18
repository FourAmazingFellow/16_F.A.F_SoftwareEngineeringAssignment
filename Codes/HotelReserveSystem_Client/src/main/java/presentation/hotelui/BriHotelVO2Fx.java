package presentation.hotelui;

import po.OrderState;
import vo.OrderedHotelInfoVO;

public class BriHotelVO2Fx {
	public FxBriefHotelInfo trans(OrderedHotelInfoVO vo) {
		String orderTypes = "";
		for(Enum<OrderState> i : vo.hotelState) {
			switch ((OrderState)i) {
			case ABNORMAL_ORDER:
				orderTypes += "异常 ";
				break;
			case DONE_ORDER:
				orderTypes += "正常 ";
			case WITHDREW_ORDER:
				orderTypes += "撤销 ";
			default:
				break;
			}
		}
		String starLevel[] = {"一","二","三","四","五"};
		
		return new FxBriefHotelInfo(vo.hotelName, vo.tradeArea, vo.hotelAddress,
				starLevel[vo.starLevel - 1], vo.mark, orderTypes);
	}
	
	
}
