package messenger;

public class Topic extends Resource {
	private TopicType topic;
	private Message message;
	private float timeOut;
	
	public TopicType getTopicType() {
		return topic;
	}
	public Topic(Message m, TopicType t) {
		if(m.getRecipient() == null)
			message = m;
		topic = t;
		
	}
	
	//to be implemented
	public boolean isValid()
	{
		return true;
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
