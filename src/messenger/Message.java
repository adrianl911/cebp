package messenger;

public class Message {

	private Client recipient;
	private String content;
	
	public Message(String c, Client r)
	{
		recipient = r;
		content = c;
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
}
