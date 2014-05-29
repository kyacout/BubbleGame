package com.example.bubblegame;

public class Game extends Thread {
	boolean running = false;
	long sleepTime;
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
		while (running) { 
			try {
				sleep(sleepTime);
				bubbleView.updateSurfaceView();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}