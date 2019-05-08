package edu.sjsu.cs.cs151.blackjack.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BlockingQueue;

import edu.sjsu.cs.cs151.blackjack.Controller.NewGameMessage;
import edu.sjsu.cs.cs151.blackjack.Controller.Message;
/**
 * The listener to listen for the click on the 'restart' or 'play again' button. 
 * The message queue is passed from the View object
 * */
public class NewGameListener implements ActionListener {

	private BlockingQueue<Message> queue;
	
	public NewGameListener(BlockingQueue<Message> queue) {
		this.queue = queue;
	}

	@Override
	public void actionPerformed(ActionEvent standEvent) {
			try {
				queue.put(new NewGameMessage());
			}
			catch(InterruptedException exception){
				exception.printStackTrace();
			}
		
	}

}