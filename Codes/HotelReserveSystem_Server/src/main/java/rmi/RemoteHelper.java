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
			System.setProperty("java.rmi.server.hostname","172.28.135.124");
			dataRemoteObjectMySql = new DataRemoteObjectMySql();
			LocateRegistry.createRegistry(1099);
			Naming.bind("rmi://172.28.135.124:1099/DataRemoteObjectMySql", dataRemoteObjectMySql);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		}
		
	}
}
