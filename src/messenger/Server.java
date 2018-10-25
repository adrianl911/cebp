package messenger;

import java.util.ArrayList;

public class Server {
	
	private static int uniqueID = 0;
	private int id;
	private int maxNumberOfMessages;
	private float expirationTime;
	private ArrayList resources = new ArrayList <Resource>();
	
	public Server(int maxNumberOfMessages, float timeOut) {
	    ++uniqueID;
	    id = uniqueID;
		this.maxNumberOfMessages = maxNumberOfMessages;
		this.expirationTime = timeOut;
	}
	
	public boolean addMessage(Resource resource)
	{
		if (resources.size() == maxNumberOfMessages)
			return false;
		resources.add(resource);
		return true;
	}
	
	//to be implemented
	public boolean isValid()
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
	
	
}
