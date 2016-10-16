package bl_Stub.hotelblservice_Stub;

import java.util.ArrayList;
import java.util.Calendar;

import businesslogicservice.hotelblservice.CommentOnHotelService;
import po.OrderState;
import vo.OrderVO;

public class CommentOnHotelServiceImpl_Stub implements CommentOnHotelService{

	public Calendar orderProducedTime;
	public Calendar lastedOrderDoneTime;
	public int numOfPerson;
	public boolean isChildren;
	public boolean isOnSale;
	public OrderState orderState;
	public boolean isCommented;
	
	public CommentOnHotelServiceImpl_Stub(Calendar orderProducedTime, Calendar lastedOrderDoneTime, int numOfPerson,
			boolean isChildren, boolean isOnSale, OrderState orderState, boolean isCommented) {
		this.orderProducedTime = orderProducedTime;
		this.lastedOrderDoneTime = lastedOrderDoneTime;
		this.numOfPerson = numOfPerson;
		this.isChildren = isChildren;
		this.isOnSale = isOnSale;
		this.orderState = orderState;
		this.isCommented = isCommented;
	}

	@Override
	public ArrayList<OrderVO> getCommentableOrderList(long ID) {
		return null;
	}

	@Override
	public boolean confirmComment(String username, int mark, String comment) {
		return false;
	}
	

}
