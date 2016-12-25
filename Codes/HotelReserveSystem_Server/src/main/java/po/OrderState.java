package po;

/**
 * 订单状态枚举类型
 * 异常订单、未执行订单、已执行订单、已撤销订单
 * @author Accident
 * @version 
 * @see
 */
public enum OrderState {
	ABNORMAL_ORDER,
	NOT_DONE_ORDER,
	DONE_ORDER,
	WITHDREW_ORDER;
}
