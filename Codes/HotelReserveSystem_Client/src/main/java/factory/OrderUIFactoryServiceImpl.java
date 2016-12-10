package factory;

import businesslogic.orderbl.browseHotelOrder.BrowseHotelOrderServiceImpl;
import businesslogic.orderbl.browseUserOrder.BrowseUserOrderServiceImpl;
import businesslogic.orderbl.checkAbnormalOrder.CheckAbnormalOrderServiceImpl;
import businesslogic.orderbl.createNewOrder.CreateNewOrderServiceImpl;
import businesslogic.orderbl.getOrderDone.GetOrderDoneServiceImpl;
import businesslogic.orderbl.withdrawOrder.WithdrawOrderServiceImpl;
import businesslogicservice.orderblservice.BrowseHotelOrderService;
import businesslogicservice.orderblservice.BrowseUserOrderService;
import businesslogicservice.orderblservice.CheckAbnormalOrderService;
import businesslogicservice.orderblservice.CreateNewOrderService;
import businesslogicservice.orderblservice.GetOrderDoneService;
import businesslogicservice.orderblservice.WithdrawOrderService;

public class OrderUIFactoryServiceImpl implements OrderUIFactoryService{

	@Override
	public BrowseUserOrderService createBrowseUserOrderService() {
		return new BrowseUserOrderServiceImpl();
	}

	@Override
	public BrowseHotelOrderService createBrowseHotelOrderService() {
		return new BrowseHotelOrderServiceImpl();
	}

	@Override
	public CheckAbnormalOrderService createBrowseAbnormalOrderService() {
		return new CheckAbnormalOrderServiceImpl();
	}

	@Override
	public CreateNewOrderService createOrderCreateService() {
		return new CreateNewOrderServiceImpl();
	}

	@Override
	public GetOrderDoneService createGetOrderDoneService() {
		return new GetOrderDoneServiceImpl();
	}

	@Override
	public WithdrawOrderService createWithdrawOrderService() {
		return new WithdrawOrderServiceImpl();
	}
	
}
