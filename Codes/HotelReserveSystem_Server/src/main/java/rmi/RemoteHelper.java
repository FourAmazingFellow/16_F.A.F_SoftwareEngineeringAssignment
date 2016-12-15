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
			System.setProperty("java.rmi.server.hostname","192.168.1.100");
			dataRemoteObjectMySql = new DataRemoteObjectMySql();
			LocateRegistry.createRegistry(1099);
			Naming.bind("rmi://192.168.1.100:1099/DataRemoteObjectMySql", dataRemoteObjectMySql);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		}
		
	}
}
