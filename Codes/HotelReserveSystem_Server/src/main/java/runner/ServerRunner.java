package runner;

import data.databaseutility.GenerateAbnormalOrder;
import rmi.RemoteHelper;

public class ServerRunner {

	//检查是否有已经超过订单最晚执行时间的未执行订单的线程变量
	private Thread checkAb;

	//服务器启动程序
	public ServerRunner() {
		new RemoteHelper();
		checkAb = new Thread(new GenerateAbnormalOrder());
		//启动自动检查异常订单的线程
		checkAb.start();
	}
	
	public static void main(String[] args) {
		new ServerRunner();
	}
}
