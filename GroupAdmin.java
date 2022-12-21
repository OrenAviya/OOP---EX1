package Task0;

import java.util.ArrayList;
import java.util.List;

/*
 * this is the observable - the thing that "send" messages to his registers when he changed
 */
public class GroupAdmin implements Sender{

	private List<Observer> observers;
	private String message;
	private boolean changed;
	private UndoableStringBuilder usb = new UndoableStringBuilder();
	
	public GroupAdmin() {
		this.observers=new ArrayList<>();
	}

	@Override
	public void register(Observer obj) {
		if(obj == null) throw new NullPointerException("Null Observer");
		synchronized (usb) {
		if(!observers.contains(obj)) observers.add(obj);
		}
		
	}

	@Override
	public void unregister(Observer obj) {
		synchronized (usb) {
			observers.remove(obj);
			}
		
	}

	@Override
	public void notifyObservers() {
		List<Observer> observersLocal = null;
		//synchronization is used to make sure any observer registered after message is received is not notified
		synchronized (usb) {
			if (!changed)
				return;
			observersLocal = new ArrayList<>(this.observers);
			this.changed=false;
		}
		for (Observer obj : observersLocal) {
			obj.update();
		}
		
	}

	@Override
	public Object getUpdate(Observer obj) {
		return this.message;
	}
	//method to post message to the topic
		public void postMessage(String msg){
			System.out.println("Message Posted to Topic:"+msg);
			this.message=msg;
			this.changed=true;
			notifyObservers();
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub

		}
}
