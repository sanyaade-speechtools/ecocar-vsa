package com.example.virtualshowroomassistant;

import com.google.zxing.client.android.CaptureActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HowTo extends Activity implements OnClickListener {

	Button bGoBack;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setupScreenSettings();
		setContentView(R.layout.howto);
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
		bGoBack = (Button) findViewById(R.id.bBackButtonHowTo);
		bGoBack.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent();
		switch (v.getId()) {
		case R.id.bBackButtonHowTo:
			finish();
		break;
		}
	}
}
