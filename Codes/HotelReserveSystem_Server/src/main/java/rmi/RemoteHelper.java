package rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RemoteHelper {
	public RemoteHelper(){
		initServer();
	}
	
	public void initServer(){
		DataRemoteObjectMySql dataRemoteObjectMySql;
		try {
			dataRemoteObjectMySql = new DataRemoteObjectMySql();
			LocateRegistry.createRegistry(8888);
			Naming.bind("rmi://192.168.56.1:8888/DataRemoteObjectMySql", dataRemoteObjectMySql);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		}
		
	}
}
