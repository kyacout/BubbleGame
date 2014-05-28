package com.example.bubblegame;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;

public class BubbleView extends View{

	static private Bubble[][] bubbles;
	static int level ;
	static boolean lose = false;
	
	public BubbleView(Context context){
		super(context);
	}
	
	public void initNewGame(){}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (lose) {
			lose = false;
			initNewGame();
		} else {
			/**continue */
		}
		
		return true;
	}
}
