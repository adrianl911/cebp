package messenger;

import java.util.ArrayList;

public class Server {
	
	private static int uniqueID = 0;
	private int id;
	private int maxNumberOfMessages;
	private float expirationTime;
	private Queue queue;
	private ArrayList<Topic> topics;
	
	public Server(int maxNumberOfMessages, float timeOut) {
	    ++uniqueID;
	    id = uniqueID;
		this.maxNumberOfMessages = maxNumberOfMessages;
		this.expirationTime = timeOut;
	}
	
	//to be implemented
	public boolean isValid(int i)
	{
		return true;
	}

	public int getId() {
		return id;
	}

	public int getMaxNumberOfMessages() {
		return maxNumberOfMessages;
	}

	public float getExpirationTime() {
		return expirationTime;
	}
	
	public boolean recieveMessageQueue(Message m)
	{
		if(maxNumberOfMessages > (topics.size() + queue.getCurrentSize()))
		{
			queue.add(m);
			return true;
		}
		else return false;
	}
	
	public void sendMessageQueue()
	{
		Message m = queue.remove();
		Client r = m.getRecipient();
		
		r.recieveMessageFromServer(m);
	}
	
	public boolean recieveTopic(Topic t)
	{
		if(maxNumberOfMessages > (topics.size() + queue.getCurrentSize()))
		{
			topics.add(t);
			return true;
		}
		else return false;
	}
	
	public Topic searchTopicViaType(TopicType type)
	{
		for(int i = 0; i < topics.size(); ++i)
		{
			if(topics.get(i).getTopicType() == type )
				return topics.get(i);
		}
		return null;
	}
	
	public void removeExpiredTopics(int timeOut)
	{
		for(int i = 0; i < topics.size(); ++i)
		{
			if(!topics.get(i).isValid(timeOut) || expirationTime < timeOut)
				topics.remove(i);
		}
	}
	
	
}
