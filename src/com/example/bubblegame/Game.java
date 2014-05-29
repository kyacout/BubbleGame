package com.example.bubblegame;

public class Game extends Thread {
	volatile boolean running = false;
	long sleepTime ;
	BubbleView bubbleView;
	
	Game(BubbleView bv, long st) {
		super();
		bubbleView = bv;
		sleepTime = st;
	}
	
	public void setRunning(boolean rn) {
		running = rn;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}