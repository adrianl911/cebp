package messenger;

public class Message {

	private Client sender;
	private Client recipient;
	private String content;
	
	public Message(String c, Client r, Client s)
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
	
	public Client getRecipient()
	{
		return recipient;
	}
	
	public String getContent()
	{
		return content;
	}
	
	public Client getSender()
	{
		return sender;
	}
	
	public String getSenderAsString()
	{
		return sender.getName();
	}
}
