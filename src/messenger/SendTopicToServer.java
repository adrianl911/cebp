package messenger;

public class SendTopicToServer implements Runnable{

	private Thread t;
	private MyClient client;
	private String name;
	private TopicType type;
	
	SendTopicToServer(String str, MyClient c,TopicType t)
	{
		name = str;
		client = c;
		type = t;
	}
	
	public void start()
	{
		if(t == null)
		{
			t = new Thread(this, name);
			t.start();
		}
	}
	
	public void run()
	{
		System.out.println("Running thread  " + name);
		try
		{
			for(int i = 0; i< 5; ++i) {
				System.out.println("Sending topic... in thread: " + name + " iteration " + i);
				client.sendTopicViaServer(type, 2000);
				Thread.sleep(50);
			}
		}
		catch(InterruptedException e)
		{
			System.out.println("Interruped thread: " + name);
		}
		System.out.println("Exiting thread: " + name);
		
	}
	
}
