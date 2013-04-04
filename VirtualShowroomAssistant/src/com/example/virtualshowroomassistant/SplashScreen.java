package com.example.virtualshowroomassistant;


import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class SplashScreen extends Activity{

	//MediaPlayer splashSong;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		Window window = getWindow();
	    window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	    		WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.splash);
		//splashSong = MediaPlayer.create(SplashScreen.this, R.raw.splashmusic);
		//splashSong.start();
		Thread time = new Thread(){
			public void run(){
				try{
					sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					Intent intent = new Intent("com.example.virtualshowroomassistant.MENUSCREEN");
					startActivity(intent);
				}
			}
		};
		time.start();
	}

	@Override
	protected void onPause() {
		super.onPause();
		//splashSong.release();
		finish();
	}
	
}