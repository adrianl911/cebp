package messenger;

public class Topic extends Resource {
	private TopicType topic;
	private Message message;
	private int timeOut;
	private Server onServer;
	
	public TopicType getTopicType() {
		return topic;
	}
	public Topic(Message m, TopicType t, int time, Server s) {
		if(m.getRecipient() == null)
			message = m;
		topic = t;
		timeOut = time;
		onServer = s;
	}
	
	//to be implemented
	public boolean isValid(int time)
	{
		return timeOut < time;
		
	}
	
	public Message getMessage()
	{
		return message;
	}
	
	@Override
	public String getType() {
		return "Resource";
	}
	
	public float getTimeOut()
	{
		return timeOut;
	}
}
