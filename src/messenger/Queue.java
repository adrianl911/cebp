	package messenger;

import java.util.concurrent.ArrayBlockingQueue;

public class Queue extends Resource {
	private int maxNumberOfMessages;
	
	// ArrayBlockingQueue is good when multiple threads are used
	private ArrayBlockingQueue<Message> messages;
	
	public boolean add(Message m) {
		if (messages.size() < maxNumberOfMessages && m.getRecipient() != null) {
			messages.add(m);
			return true;
		}
		else return false;
	}
	public Message remove() {
		return messages.remove();
	}
	
	@Override
	public String getType() {
		return "Queue";
	}
	
	public int getMaxNumberOfMessage()
	{
		return maxNumberOfMessages;
	}
	
	public int getCurrentSize()
	{
		return messages.size();
	}
	
}
