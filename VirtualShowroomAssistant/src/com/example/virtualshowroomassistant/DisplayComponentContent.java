package com.example.virtualshowroomassistant;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayComponentContent extends Activity implements OnClickListener {
	
	String QRresult;
	TextView tvDisplayResult;
	ImageView ivComponentImage;
	Map<String, Integer> imageMap = new HashMap<String, Integer>();
	Button bGoBack;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setupScreenSettings();
		setContentView(R.layout.component_content);
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
		bGoBack = (Button) findViewById(R.id.bBackButtonComponentContent);
		bGoBack.setOnClickListener(this);
		
		//Delete this later
		Environment environment = new Environment();
		String test = environment.getExternalStorageDirectory().toString();
		Toast toast = Toast.makeText(getApplicationContext(), test, Toast.LENGTH_LONG);
		toast.show();
		
		imageMap.put("ecocar00", R.drawable.ecocar00);
		imageMap.put("ecocar01", R.drawable.ecocar01);
		imageMap.put("ecocar02", R.drawable.ecocar02);
		
		for(int i = 0; i < 50; i++) {
			
		}
		
		Intent sender = getIntent();
		QRresult = sender.getExtras().getString("QRresult");
		tvDisplayResult = (TextView) findViewById(R.id.tvQRresult);
		ivComponentImage = (ImageView) findViewById(R.id.ivComponentImage);
		try {
			ivComponentImage.setImageResource(imageMap.get(QRresult));
			tvDisplayResult.setText(QRresult);
		} catch (Exception name) {

		}
	}
	
	@Override
	public void onClick(View v) {
		Intent intent = new Intent();
		switch (v.getId()) {
		case R.id.bBackButtonComponentContent:
			finish();
		break;
		}
	}
}
