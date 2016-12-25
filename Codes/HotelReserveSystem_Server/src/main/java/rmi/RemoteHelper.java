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

	//初始化RMI配置
	public void initServer(){
		DataRemoteObjectMySql dataRemoteObjectMySql;
		try {
			System.setProperty("java.rmi.server.hostname","172.25.183.128");
			dataRemoteObjectMySql = new DataRemoteObjectMySql();
			LocateRegistry.createRegistry(1099);
			Naming.bind("rmi://172.25.183.128:1099/DataRemoteObjectMySql", dataRemoteObjectMySql);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		}
		
	}
}
