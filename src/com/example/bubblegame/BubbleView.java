package com.example.bubblegame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class BubbleView extends SurfaceView implements SurfaceHolder.Callback {

	SurfaceHolder surfaceHolder;
	Game myGame = null;

	static private Bubble[][] bubbles;
	static private Bitmap[] bubble = new Bitmap[5];
	/** Assuming we have five bubble color **/
	static int level;
	static boolean lose = false;

	public BubbleView(Context context) {
		super(context);
		initNewGame();
		// adding the callback (this) to the surface holder to intercept events
		getHolder().addCallback(this);
	}

	public BubbleView(Context context, AttributeSet atts) {
		super(context, atts);
	}

	public BubbleView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public void initNewGame() {
		//number of bubbles should be initialized according to level no 

		BitmapFactory.Options options = new BitmapFactory.Options();

		try {
			bubble[0] = BitmapFactory.decodeResource(getResources(),
					R.drawable.bubble_blue, options);
			bubble[1] = BitmapFactory.decodeResource(getResources(),
					R.drawable.bubble_deepblue, options);
			bubble[2] = BitmapFactory.decodeResource(getResources(),
					R.drawable.bubble_green, options);
			bubble[3] = BitmapFactory.decodeResource(getResources(),
					R.drawable.bubble_orange, options);
			bubble[4] = BitmapFactory.decodeResource(getResources(),
					R.drawable.bubble_red, options);
		} catch (ExceptionInInitializerError e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (lose) {
			lose = false;
			initNewGame();
		} else {
			/** continue */
			// get x,y,slope
		}
		return true;
	}

	public void update() {
	}
	@Override
	protected void onDraw(Canvas canvas) {};
	/*****************************************************************************/

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int hight) {
	}

	@Override
	public void surfaceCreated(SurfaceHolder holdre) {
		/** start the game loop */
		myGame.start();
	}

	public void updateSurfaceView() {
		/** runs in background thread (not UI thread) */
		Canvas canvas = null;
		try {
			canvas = surfaceHolder.lockCanvas();
			synchronized (surfaceHolder) {
				update();
			}
		} finally {
			if (canvas != null) {
				surfaceHolder.unlockCanvasAndPost(canvas);
			}
		}
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
	}

	/**************************************************************************************/

	public void BubbleView_OnResume() {

		surfaceHolder = getHolder();
		getHolder().addCallback(this);

		/*** Create and start background Thread */
		myGame = new Game(this, 50);
		myGame.setRunning(true);
		myGame.start();
		
	}

	public void BubbleView_OnPause() {
		
		/*** kill background Thread */
		boolean retry = true;
		myGame.setRunning(false);
		myGame.run();

		while (retry) {
		try {
			myGame.join();
			retry = false;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	/**************************************************************************************/
}