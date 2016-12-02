package po;

/**
 * 订单执行，订单异常，订单撤销（取消订单，扣除信用值），异常订单撤销，信用充值
 * @author sparkler
 * @version 
 * @see
 */
public enum ActionType {
    ORDER_DONE, ORDER_ABNORMAL, ORDER_UNDO, ORDER_RECOVER, RECHARGE;
}
