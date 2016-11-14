package data.roomdata;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import dataservice.roomDAO.RoomDAO;
import po.RoomPO;
import po.RoomType;

public class RoomDAOImpl implements RoomDAO {

	@Override
	public ArrayList<RoomPO> getSpareRoomInfoList(String address) throws RemoteException {
		return null;
	}

	@Override
	public RoomPO getSpareRoomInfo(String address, Enum<RoomType> roomType) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<RoomPO> getCheckInInfoList(String address) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<RoomPO> getCheckInInfo(String address, Date time) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<RoomPO> getCheckInInfo(String address, Enum<RoomType> roomType) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<RoomPO> getCheckOutInfoList(String address) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<RoomPO> getCheckOutInfo(String address, Date time) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<RoomPO> getCheckOutInfo(String address, Enum<RoomType> roomType) throws RemoteException {
		return null;
	}

	@Override
	public RoomPO find(String userID) throws RemoteException {
		return null;
	}

	@Override
	public void update(RoomPO po) throws RemoteException {

	}

	@Override
	public void insert(RoomPO po) throws RemoteException {

	}

	@Override
	public void delete(RoomPO po) throws RemoteException {

	}

	@Override
	public void init() throws RemoteException {

	}

	@Override
	public void finish() throws RemoteException {

	}

}
