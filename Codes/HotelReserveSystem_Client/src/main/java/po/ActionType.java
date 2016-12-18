package po;

/**
 * 订单执行，订单异常，订单撤销（取消订单，扣除信用值），异常订单撤销，信用充值
 * 
 * @author sparkler
 * @version
 * @see
 */
public enum ActionType {
	ORDER_DONE, ORDER_ABNORMAL, ORDER_UNDO, ORDER_RECOVER, RECHARGE;

	public static String enumToChinese(ActionType actionType) {
		if (actionType == null) {
			return null;
		}
		if (actionType == ActionType.ORDER_DONE) {
			return "订单执行";
		} else if (actionType == ActionType.ORDER_ABNORMAL) {
			return "订单异常";
		} else if (actionType == ActionType.ORDER_UNDO) {
			return "订单撤销";
		} else if (actionType == ActionType.ORDER_RECOVER) {
			return "异常订单撤销";
		} else {
			return "信用充值";
		}
	}

	public static ActionType chineseToEnum(String actionTypeStr) {
		if (actionTypeStr == null || actionTypeStr.isEmpty()) {
			return null;
		}
		ActionType actionType;
		if (actionTypeStr.equals("订单执行")) {
			actionType = ActionType.ORDER_DONE;
		} else if (actionTypeStr.equals("订单异常")) {
			actionType = ActionType.ORDER_ABNORMAL;
		} else if (actionTypeStr.equals("订单撤销")) {
			actionType = ActionType.ORDER_UNDO;
		} else if (actionTypeStr.equals("异常订单撤销")) {
			actionType = ActionType.ORDER_RECOVER;
		} else {
			actionType = ActionType.RECHARGE;
		}
		return actionType;
	}
}