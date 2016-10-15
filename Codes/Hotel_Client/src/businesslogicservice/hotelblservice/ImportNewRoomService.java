package businesslogicservice.hotelblservice;

import java.util.ArrayList;

import vo.RoomVO;

/**
 * 
 * @author 原
 * @version 1.0
 * @see
 */
public interface ImportNewRoomService {
	
	/**
	 * 获得酒店的可用客房列表
	 * @param address String型，界面传递来的酒店地址
	 * @return 返回酒店的可用客房列表
	 * @see
	 */
	public ArrayList<RoomVO> getAvailableRoomList(String address);
	
	/**
	 * 为酒店录入可用客房
	 * @param room RoomVO型，界面传递来的客房信息
	 * @return 录入客房成功返回true，录入客房失败返回false
	 * @see
	 */
	public boolean addRoom(RoomVO room);

}
