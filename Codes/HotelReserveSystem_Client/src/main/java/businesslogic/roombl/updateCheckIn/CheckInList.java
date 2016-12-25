package businesslogic.roombl.updateCheckIn;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import businesslogic.strategybl.exception.WrongInputException;
import dataservice.roomDAO.RoomDAO;
import factory.FactoryService;
import factory.FactoryServiceImpl;
import po.RoomPO;
import po.RoomType;
import vo.RoomVO;

/**
 * 入住信息的列表类
 * @author 双
 * @version
 * @see
 */
public class CheckInList {

	private RoomDAO roomDAO;

	private FactoryService factoryService;

	public CheckInList() {
	    //用工厂初始化roomDAO
		this.factoryService = new FactoryServiceImpl();
		roomDAO = factoryService.getRoomDAO();
	}

	/**
	 * 从数据层得到入住信息列表
	 * @param address String型，酒店地址
	 * @return ArrayList<CheckInItem>型，入住信息列表
	 * @throws RemoteException
	 * @see
	 */
	public ArrayList<CheckInItem> getCheckInList(String address) throws RemoteException {
		ArrayList<RoomPO> roomPOs;
		ArrayList<CheckInItem> checkInItems = new ArrayList<CheckInItem>();
		roomPOs = roomDAO.getCheckInInfoList(address);
		for (RoomPO roomPO : roomPOs) {
			checkInItems.add(new CheckInItem(roomPO));
		}
		return checkInItems;
	}

	/**
	 * 根据入住时间搜索符合条件的入住信息列表
	 * @param address string型，酒店地址
	 * @param time Date型，入住时间
	 * @return ArrayList<CheckInItem>型，返回符合条件的入住信息列表
	 * @throws RemoteException
	 * @see
	 */
	public ArrayList<CheckInItem> searchCheckInInfo(String address, Date startTime, Date endTime)
			throws RemoteException {
		ArrayList<RoomPO> roomPOs;
		ArrayList<CheckInItem> checkInItems = new ArrayList<CheckInItem>();
		roomPOs = roomDAO.getCheckInInfo(address, startTime, endTime);
		for (RoomPO roomPO : roomPOs) {
			checkInItems.add(new CheckInItem(roomPO));
		}
		return checkInItems;
	}

	/**
	 * 根据房间类型搜索符合条件的入住信息列表
	 * @param addressstring型，酒店地址
	 * @param time Date型，入住时间
	 * @return ArrayList<CheckInItem>型，返回符合条件的入住信息列表
	 * @throws RemoteException
	 * @see
	 */
	public ArrayList<CheckInItem> searchCheckInInfo(String address, Enum<RoomType> roomType) throws RemoteException {
		ArrayList<RoomPO> roomPOs;
		ArrayList<CheckInItem> checkInItems = new ArrayList<CheckInItem>();
		roomPOs = roomDAO.getCheckInInfo(address, roomType);
		for (RoomPO roomPO : roomPOs) {
			checkInItems.add(new CheckInItem(roomPO));
		}
		return checkInItems;
	}

	/**
	 * 增加入住信息，即办理入住
	 * @param address string型，酒店地址
	 * @param checkIn Room VO型，入住信息
	 * @return 返回是否增加成功
	 * @throws RemoteException
	 * @see
	 */
	public boolean addCheckIn(String address, RoomVO checkIn, boolean updateSpareRoom) throws RemoteException {
		CheckInItem checkInItem = new CheckInItem(checkIn);
		return checkInItem.addCheckIn(address, updateSpareRoom);
	}

	/**
	 * 判断该入住信息是否有效
	 * @param address  string型，酒店地址
	 * @param checkIn Room VO型，入住信息
	 * @return 返回是否入住信息有效
	 * @throws WrongInputException 当该入住信息有误时抛出该异常
	 * @throws RemoteException
	 * @see
	 */
	public boolean validCheckIn(String address, RoomVO checkIn) throws WrongInputException, RemoteException {
		CheckInItem checkInItem = new CheckInItem(checkIn);
		return checkInItem.validCheckIn();
	}
}
