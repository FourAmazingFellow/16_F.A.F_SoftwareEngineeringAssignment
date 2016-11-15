package businesslogic.orderbl.createNewOrder;

import businesslogicservice.orderblservice.ResultMessage;
import vo.OrderVO;

public class MockChecker extends Checker {
	boolean canUserCreateNewOrder;
	ResultMessage resultMessage;
	
	public MockChecker(boolean canUserCreateNewOrder, ResultMessage resultMessage){
		this.canUserCreateNewOrder = canUserCreateNewOrder;
		this.resultMessage = resultMessage;
	}
	
	/**
	 * 判断该客户能否生成订单
	 * @param UserID
	 * @return boolean 能否生成订单
	 * @see
	 */
	public boolean canUserCreateNewOrder(String userID) {
		
		return canUserCreateNewOrder;
	}

	/**
	 * 检查该订单在当前时刻能否被生成
	 * @param vo 被检查的订单VO
	 * @return 检查结果
	 * @see
	 */
	public ResultMessage checkNewOrder(OrderVO vo) {

		return resultMessage;
	}
}
