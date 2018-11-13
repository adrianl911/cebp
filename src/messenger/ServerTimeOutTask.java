package messenger;

import java.util.TimerTask;

public class ServerTimeOutTask implements Runnable{
	
	private Server server;
	private Thread t;
	private String name;
	
	ServerTimeOutTask(Server s) {
		name = "SERVER TIME OUT TASK";
		server = s;
	}
	public void run() {
		try {
			while(true) {
			Thread.sleep(server.getExpirationTime());
			System.out.println("Time out in server!");
			server.removeAllTopics();
			}
		}
		catch(InterruptedException e) {
			System.out.println("Time out server");
		}
	}
	
	public void start() {
		if(t == null) {
			System.out.println("Time out start....");
			t = new Thread(this, name);
			t.start();
		}
	}
	
}
