package runner;



import rmi.LinkToServer;

public class ClientRunner {

	private LinkToServer linkToServer;
	
	public ClientRunner() {
		this.linkToServer = new LinkToServer();
	}
	
	public void start() {
		linkToServer.linkToServer();
	}
	
	public static void main(String[] args) {
		ClientRunner clientRunner = new ClientRunner();
		clientRunner.start();
		while(true) {
			
		}
	}

}
