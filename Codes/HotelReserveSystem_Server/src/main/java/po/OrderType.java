package po;

/**
 * 订单类型枚举类型
 * 全部订单、异常订单、未执行订单、已执行订单、已撤销订单
 * @author Accident
 * @version 1.0
 * @see
 */
public enum OrderType {
	ALL,
	ABNORMAL_ORDER,
	NOT_DONE_ORDER,
	DONE_ORDER,
	WITHDREW_ORDER;
}
