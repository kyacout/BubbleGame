package com.example.bubblegame;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	/***************** Declaration *****************/
	Button newGame;
	Button selectLevel;
	Button level_1;
	Button level_2;
	BubbleView bubbleView;
	/***********************************************/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bubbleView = new BubbleView(this);
		bubbleView = (BubbleView) findViewById(R.id.myview1);

		newGame = (Button) findViewById(R.id.new_game);
		newGame.setOnClickListener(new  View.OnClickListener(){
			@Override
 		   public void onClick(View v) {
 			   setContentView(bubbleView);
 		   }
 		   });
		
		selectLevel = (Button) findViewById(R.id.choose_level);
		selectLevel.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setContentView(R.layout.select_level);
				level_1 = (Button) findViewById(R.id.level_1);
				level_1.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						BubbleView.level = 1;
						
						/**
						 * must display bubbles sorted according to level number -- in BubbleView class
						 **/
						setContentView(bubbleView);
					}
				});

				level_2 = (Button) findViewById(R.id.level_2);
				level_2.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						BubbleView.level = 2;
						/**
						 * must display bubbles sorted according to level number -- in BubbleView class
						 **/
						setContentView(bubbleView);
					}
				});
			}
		});
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		bubbleView.BubbleView_OnPause();
	}
	@Override
	protected void onResume() {
		super.onResume();
		bubbleView.BubbleView_OnResume();
	};
	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
}
