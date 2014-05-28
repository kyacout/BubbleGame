package com.example.bubblegame;

import android.graphics.Bitmap;

public class Bubble {
	Bitmap bitmap;
	int dx;		
	int dy;		
	int color;
	boolean destroy ;
	boolean markedCheck=false;
	
	public Bubble() {
		// TODO Auto-generated constructor stub
		dx=0;
		dy=0;
		destroy=true;
		markedCheck=false;
	}
	public Bubble(Bitmap bitmap, int x, int y) {
		super();
		
		this.bitmap = bitmap;
		this.dx = x;
		this.dy = y;
		color=0;
		destroy = false;
	}	
}