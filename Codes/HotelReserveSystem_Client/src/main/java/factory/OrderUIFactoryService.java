package factory;

import businesslogicservice.orderblservice.BrowseHotelOrderService;
import businesslogicservice.orderblservice.BrowseUserOrderService;
import businesslogicservice.orderblservice.CheckAbnormalOrderService;
import businesslogicservice.orderblservice.CreateNewOrderService;
import businesslogicservice.orderblservice.GetOrderDoneService;
import businesslogicservice.orderblservice.WithdrawOrderService;

public interface OrderUIFactoryService {
	public BrowseUserOrderService createBrowseUserOrderService();
	
	public BrowseHotelOrderService createBrowseHotelOrderService();
	
	public CheckAbnormalOrderService createBrowseAbnormalOrderService();
	
	public CreateNewOrderService createOrderCreateService();
	
	public GetOrderDoneService createGetOrderDoneService();
	
	public WithdrawOrderService createWithdrawOrderService();
}
