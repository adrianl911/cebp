package messenger;

import java.util.Stack;

public class Queue extends Resource {
	private int maxNumberOfMessages;
	private Stack<Message> messages;
	
	public boolean add(Message m) {
		if (messages.size() < maxNumberOfMessages && m.getRecipient() != null) {
			messages.push(m);
			return true;
		}
		else return false;
	}
	public Message remove(Message m) {
		return messages.pop();
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
