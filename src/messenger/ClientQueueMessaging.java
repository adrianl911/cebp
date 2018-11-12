package messenger;

public class ClientQueueMessaging implements Runnable{
	
	private Thread t;
	private String name;
	private MyClient client;
	private Server server;
	
	ClientQueueMessaging(String s, MyClient c, Server svr)
	{
		name = s;
		client = c;
		server = svr;
	}
	
	public void run()
	{
		System.out.println("Running thread  " + name);
		try
		{
			for(int i = 0; i< 5; ++i) {
				System.out.println("Sending message... in thread: " + name + " iteration " + i);
				client.sendMessageViaServer();
				Thread.sleep(50);
				server.sendMessageQueue();	
			}
		}
		catch(InterruptedException e)
		{
			System.out.println("Interruped thread: " + name);
		}
		System.out.println("Exiting thread: " + name);
	}
	
	
	public void start()
	{
		System.out.println("Start thread " + name);
		if(t == null)
		{
			t = new Thread(this, name);
			t.start();
		}
	}

}
