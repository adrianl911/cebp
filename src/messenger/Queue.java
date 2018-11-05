	package messenger;

import java.util.concurrent.ArrayBlockingQueue;

public class Queue extends Resource {
	private int maxNumberOfMessages;
	
	// ArrayBlockingQueue is good when multiple threads are used
	private ArrayBlockingQueue<Message> messages;
	
	public boolean add(Message m) {
		if (messages.size() < maxNumberOfMessages && m.getRecipient() != null) {
			try {
			messages.put(m);
			return true;
			}
			catch(NullPointerException e)
			{
				System.out.println("Null value!");
				return false;
			} catch (InterruptedException e) {
				System.out.println("Waiting for stack to have space!");
				return false;
			}
		}
		else return false;
	}
	public Message remove(Message m) {
		return messages.remove();
	}
	
	@Override
	public String getType() {
		return "Queue";
	}
	
	public int getNumberOfMessage()
	{
		return maxNumberOfMessages;
	}
	
}
