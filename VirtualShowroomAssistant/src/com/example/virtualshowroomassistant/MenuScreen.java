package com.example.virtualshowroomassistant;

import com.google.zxing.client.android.CaptureActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

public class MenuScreen extends Activity implements OnClickListener {

	Button bGetStarted, bHowTo, bLeaveFeedback;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setupScreenSettings();
		setContentView(R.layout.menuscreen);
		setupVariables();
	}
	
	private void setupScreenSettings() {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		Window window = getWindow();
		window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
	}
	
	private void setupVariables() {
		//set up buttons and their on click listener
		bGetStarted = (Button) findViewById(R.id.bGetStarted);
		bHowTo = (Button) findViewById(R.id.bHowTo);
		bLeaveFeedback = (Button) findViewById(R.id.bLeaveFeedback);
		bGetStarted.setOnClickListener(this);
		bHowTo.setOnClickListener(this);
		bLeaveFeedback.setOnClickListener(this);
		
		//get screen size
		/*
		Display display = getWindowManager().getDefaultDisplay();
		int width = display.getWidth();
		int height = display.getHeight();
		*/
		
		
	}


	@Override
	public void onClick(View v) {
		Intent intent = new Intent();
		switch(v.getId()) {
		case R.id.bGetStarted:
			intent = new Intent(getApplicationContext(),CaptureActivity.class);
			startActivity(intent);
			break;
		case R.id.bHowTo:
			intent = new Intent(getApplicationContext(),HowTo.class);
			startActivity(intent);
			break;
		case R.id.bLeaveFeedback:
			intent = new Intent(getApplicationContext(),LeaveFeedback.class);
			startActivity(intent);
			break;
		}
		
	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.menuscreen2, menu);
//		return true;
//	}
}
