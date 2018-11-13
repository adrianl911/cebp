	package messenger;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.*;

public class Queue extends Resource {
	private int maxNumberOfMessages;

	// ArrayBlockingQueue is good when multiple threads are used
	private ArrayBlockingQueue<Message> messages;
	
	Queue(int maxNumberOfMessages) {
		this.maxNumberOfMessages = maxNumberOfMessages;
		messages = new ArrayBlockingQueue<Message>(maxNumberOfMessages);
	}
	
	public boolean add(Message m) {
		if (messages.size() < maxNumberOfMessages && m.getRecipient() != null) {
			messages.add(m);
			return true;
		}
		else return false;
	}
	public Message remove(){
		if(messages.size() == 0) {
			System.out.println("No messages availble!");
			return null;
		}
		Iterator<Message> it = messages.iterator();
		Message tmp = it.next();
		if( tmp  == null ) {
			System.out.print("No next element");
			return null;
		}
		messages.remove(tmp);
		return tmp;
	}
	
	@Override
	public String getType() {
		return "Queue";
	}
	
	public int getMaxNumberOfMessage() {
		return maxNumberOfMessages;
	}
	
	public int getCurrentSize() {
		return messages.size();
	}
	
}
