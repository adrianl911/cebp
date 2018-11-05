package messenger;

public class Topic extends Resource {
	private TopicType topic;
	private Message message;
	private int timeOut;
	
	public TopicType getTopicType() {
		return topic;
	}
	public Topic(Message m, TopicType t, int time) {
		if(m.getRecipient() == null)
			message = m;
		topic = t;
		timeOut = time;
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
