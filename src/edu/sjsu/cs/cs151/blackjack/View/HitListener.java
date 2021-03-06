package edu.sjsu.cs.cs151.blackjack.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BlockingQueue;

import edu.sjsu.cs.cs151.blackjack.Controller.HitMessage;
import edu.sjsu.cs.cs151.blackjack.Controller.Message;
import edu.sjsu.cs.cs151.blackjack.Controller.StandMessage;
/**
 * The listener to listen for the click on the 'hit' button. 
 * The message queue is passed from the View object
 * */
public class HitListener implements ActionListener {

	private BlockingQueue<Message> queue;
	
	/**
	 * Hit Listener ctor.
	 * @param queue	 message queue for listener
	 */
	public HitListener(BlockingQueue<Message> queue) {
		this.queue = queue;
	}

	/**
	 * Queues a new hit message.
	 */
	@Override
	public void actionPerformed(ActionEvent hitEvent) {
			try {
				queue.put(new HitMessage());
			}
			catch(InterruptedException exception){
				exception.printStackTrace();
			}
		
	}

}
