package messenger;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.*;

public class Server {
	
	private static int uniqueID = 0;
	private int id;
	private int maxNumberOfMessages;
	private float expirationTime;
	private Queue queue;
	private ArrayBlockingQueue<Topic> topics;
	
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
		Iterator<Topic> it = topics.iterator();
		
		while(it.hasNext())
		{
			Topic topic = it.next();
			if(topic.getTopicType() == type )
				return topic;
		}
		
		return null;
	}
	
	public void removeExpiredTopics(int timeOut)
	{
		Iterator<Topic> it = topics.iterator();
		
		while(it.hasNext())
		{
			if(it.next().isValid(timeOut) || expirationTime < timeOut)
				it.remove();
		}
	}
	
	
}
