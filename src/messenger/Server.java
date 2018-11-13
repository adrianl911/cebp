package messenger;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.*;

public class Server {
	
	private static int uniqueID = 0;
	private int id;
	private int maxNumberOfMessages;
	private long expirationTime;
	private Queue queue;
	private ArrayBlockingQueue<Topic> topics;
	
	public Server(int maxNumberOfMessages, long timeOut) {
	    ++uniqueID;
	    id = uniqueID;
		this.maxNumberOfMessages = maxNumberOfMessages;
		this.expirationTime = timeOut;
		topics = new ArrayBlockingQueue<Topic>(maxNumberOfMessages);
		queue = new Queue(maxNumberOfMessages);
	}
	
	//to be implemented
	public boolean isValid(int i) {
		return true;
	}

	public int getId() {
		return id;
	}

	public int getMaxNumberOfMessages() {
		return maxNumberOfMessages;
	}

	public long getExpirationTime() {
		return expirationTime;
	}
	
	public boolean receiveMessageQueue(Message m) {
		if(maxNumberOfMessages > (topics.size() + queue.getCurrentSize())) {
			queue.add(m);
			return true;
		}
		else return false;
	}
	
	public void sendMessageQueue() {
		Message m = queue.remove();
		MyClient r = m.getRecipient();
		
		r.receiveMessageFromServer(m);
	}
	
	public boolean receiveTopic(Topic t) {
		if(maxNumberOfMessages > (topics.size() + queue.getCurrentSize())) {
			topics.add(t);
			return true;
		}
		else return false;
	}
	
	public Topic searchTopicViaType(TopicType type) {
		if(topics.size() == 0) {
			System.out.println("Topics expired!");
			return null;
		}
		
		Iterator<Topic> it = topics.iterator();

		while(it.hasNext()) {
			Topic topic = it.next();
			if(topic.getTopicType() == type )
				return topic;
		}
		
		return null;
	}
	
	public void removeExpiredTopics(long timeOut) {
		Iterator<Topic> it = topics.iterator();
		
		while(it.hasNext())
		{
			if(!it.next().isValid(timeOut) && expirationTime < timeOut)
				it.remove();
		}
	}
	
    public void removeAllTopics() {
    	topics.clear();
    }
	
	
}
