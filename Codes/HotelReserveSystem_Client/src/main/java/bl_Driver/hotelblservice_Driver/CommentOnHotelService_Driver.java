package bl_Driver.hotelblservice_Driver;

import java.util.ArrayList;

import businesslogicservice.hotelblservice.CommentOnHotelService;
import vo.OrderVO;

public class CommentOnHotelService_Driver {
	public void drive(CommentOnHotelService commentOnHotelService) {
		ArrayList<OrderVO> orderVOList = commentOnHotelService.getCommentableOrderList("原");
		if(orderVOList.isEmpty())
			System.out.println("No such orders!\n");
		else
			System.out.println("There are " + orderVOList.size() + " such orders");
		boolean result = commentOnHotelService.confirmComment("原", 0000000000000003, "酒店隔音效果较差，wifi连接不稳定，经常掉线！", orderVOList.get(0).hotelAddress);
		if(result)
			System.out.println("Comment Succeed!\n");
		else
			System.out.println("Comment Failed!\n");
	}
}
