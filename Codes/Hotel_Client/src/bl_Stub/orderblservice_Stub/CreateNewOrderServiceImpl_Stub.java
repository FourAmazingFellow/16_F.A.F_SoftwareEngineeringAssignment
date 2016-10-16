package bl_Stub.orderblservice_Stub;

import businesslogicservice.orderblservice.CreateNewOrderService;
import businesslogicservice.orderblservice.ResultMessage;
import vo.OrderVO;

public class CreateNewOrderServiceImpl_Stub implements CreateNewOrderService {

	@Override
	public OrderVO initNewOrder(long ID, String address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPrice(OrderVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResultMessage checkNewOrder(OrderVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addNewOrder(OrderVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

}
