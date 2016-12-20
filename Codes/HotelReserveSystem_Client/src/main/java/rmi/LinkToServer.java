package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class LinkToServer {

	private RemoteHelper remoteHelper;
	
	public void linkToServer() throws RemoteException {
		try {
			remoteHelper = RemoteHelper.getInstance();
			remoteHelper.setRemote(Naming.lookup("rmi://172.26.67.70:1099/DataRemoteObjectMySql"));
			System.out.println("连接成功");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
}
