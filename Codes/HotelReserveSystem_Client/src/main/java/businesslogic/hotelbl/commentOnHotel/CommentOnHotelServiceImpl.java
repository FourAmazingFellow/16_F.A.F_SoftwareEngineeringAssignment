package businesslogic.hotelbl.commentOnHotel;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.hotelblservice.CommentOnHotelService;
import dataservice.hotelDAO.HotelDAO;
import po.HotelPO;
import rmi.RemoteHelper;
import vo.OrderVO;

public class CommentOnHotelServiceImpl implements CommentOnHotelService{

	private CommentableOrderList commentableOrderList;
	private HotelDAO hotelDAO;
	
	public CommentOnHotelServiceImpl() {
		this.hotelDAO = RemoteHelper.getInstance().getHotelDAO();
	}
	
	@Override
	public ArrayList<OrderVO> getCommentableOrderList(String userID) throws RemoteException {
		commentableOrderList = new CommentableOrderList(userID);
		return commentableOrderList.getCommentableOrderList();
	}

	@Override
	public boolean confirmComment(String username, float mark, String comment, String hotelAddress) throws RemoteException {
		HotelPO hotelPO = hotelDAO.getHotelDetails(hotelAddress);
		int numsOfBeforeComments = hotelPO.getComments().size();
		float nowMark = (numsOfBeforeComments * hotelPO.getMark() + mark) / (numsOfBeforeComments + 1);
		hotelPO.setMark(nowMark);
		hotelPO.getComments().put(username, comment);
		hotelDAO.updateHotel(hotelPO);
		return true;
	}
	
}
