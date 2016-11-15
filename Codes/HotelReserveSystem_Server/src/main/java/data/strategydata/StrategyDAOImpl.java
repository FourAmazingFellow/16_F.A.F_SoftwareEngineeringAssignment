package data.strategydata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.StrategyPO;
import po.StrategyType;

public class StrategyDAOImpl implements dataservice.strategyDAO.StrategyDAO {

	@Override
	public ArrayList<StrategyPO> getStrategyList(String address, Enum<StrategyType> strategyType)
			throws RemoteException {
		return null;
	}

	@Override
	public StrategyPO getMarketStrategyInfo(String address, String strategyName) throws RemoteException {
		return null;
	}

	@Override
	public void update(StrategyPO po) throws RemoteException {

	}

	@Override
	public void insert(StrategyPO po) throws RemoteException {

	}

	@Override
	public void delete(StrategyPO po) throws RemoteException {

	}

	@Override
	public void init() throws RemoteException {

	}

	@Override
	public void finish() throws RemoteException {

	}

}
