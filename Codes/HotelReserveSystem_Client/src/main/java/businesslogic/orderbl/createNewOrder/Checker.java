package businesslogic.orderbl.createNewOrder;

import businesslogic.roombl.RoomInfoService;
import businesslogic.userbl.ClientCreditInfo;
import businesslogicservice.orderblservice.ResultMessage;
import vo.OrderVO;

public class Checker {
	ClientCreditInfo clientCreditGetter;
	RoomInfoService orderChecker;

	/**
	 * 判断该客户能否生成订单
	 * @param UserID
	 * @return boolean 能否生成订单
	 * @see
	 */
	public boolean canUserCreateNewOrder(String userID) {
		if (clientCreditGetter.getCreditValue(userID) <= 0) {
			return false;
		} else
			return true;
	}

	/**
	 * 检查该订单在当前时刻能否被生成
	 * @param vo 被检查的订单VO
	 * @return 检查结果
	 * @see
	 */
	public ResultMessage checkNewOrder(OrderVO vo) {

		ResultMessage message = orderChecker.checkOrder(vo);
		return message;
	}
}
