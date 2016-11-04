package businesslogicservice.orderblservice;

import vo.OrderVO;

/**
 * 撤销订单服务
 * @author Accident
 * @version 1.0
 * @see
 */
public interface WithdrawOrderService {

    /**
     * 撤销订单（（扣除信用值），系统将订单置为撤销状态，记录撤销时间，更新空房列表）
     * @param vo 订单VO
     * @return boolean 
     * @see
     */
    public boolean withdrawOrder(OrderVO vo, boolean isTooLate); 
}
