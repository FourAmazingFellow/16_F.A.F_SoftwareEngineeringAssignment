package presentation.hotelui;

import po.OrderState;
import vo.OrderedHotelInfoVO;

/**
 * 把逻辑层的HotelVO转化为JavaFX自定义Model的工具类
 * @author Accident
 * @version 1.0
 * @see
 */
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
				break;
			case WITHDREW_ORDER:
				orderTypes += "撤销 ";
				break;
			default:
				break;
			}
		}
		String starLevel[] = {"一","二","三","四","五"};
		
		return new FxBriefHotelInfo(vo.hotelName, vo.tradeArea, vo.hotelAddress,
				starLevel[vo.starLevel - 1], vo.mark, vo.min_Price, orderTypes);
	}
	
	
}
