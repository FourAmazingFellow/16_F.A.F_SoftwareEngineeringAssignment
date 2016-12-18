package runner;

import data.databaseutility.GenerateAbnormalOrder;
import rmi.RemoteHelper;

public class ServerRunner {

	private Thread checkAb;
	
	public ServerRunner() {
		new RemoteHelper();
		checkAb = new Thread(new GenerateAbnormalOrder());
		checkAb.start();
	}
	
	public static void main(String[] args) {
		new ServerRunner();
	}
}
