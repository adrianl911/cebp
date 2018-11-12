package messenger;

public class Message {

	private MyClient sender;
	private MyClient recipient;
	private String content;
	
	public Message(String c, MyClient r, MyClient s)
	{
		recipient = r;
		content = c;
		sender = s;
	}
	
	public Message(String c)
	{
		content = c;
		recipient = null;
	}
	
	public MyClient getRecipient()
	{
		return recipient;
	}
	
	public String getContent()
	{
		return content;
	}
	
	public MyClient getSender()
	{
		return sender;
	}
	
	public String getSenderAsString()
	{
		return sender.getName();
	}
}
