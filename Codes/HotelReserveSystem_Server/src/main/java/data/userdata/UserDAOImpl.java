package data.userdata;

import java.rmi.RemoteException;

import dataservice.userDAO.UserDAO;
import po.UserPO;
import po.UserType;

public class UserDAOImpl implements UserDAO {

	@Override
	public UserPO getUserInfo(String userID, UserType UserType) throws RemoteException {
		return null;
	}

	@Override
	public UserPO queryCredit(String userID) throws RemoteException {
		return null;
	}

	@Override
	public int getCreditValue(String userID) throws RemoteException {
		return 0;
	}

	@Override
	public void insert(UserPO po) throws RemoteException {

	}

	@Override
	public void delete(UserPO po) throws RemoteException {

	}

	@Override
	public void update(UserPO po) throws RemoteException {

	}

	@Override
	public void finish() throws RemoteException {

	}

}
