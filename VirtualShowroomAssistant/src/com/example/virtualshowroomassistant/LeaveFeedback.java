package com.example.virtualshowroomassistant;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class LeaveFeedback extends Activity implements OnClickListener {

	RatingBar ratingbar1, ratingbar2, ratingbar3;
	EditText etFeedback;
	Button bFeedback, bGoBack;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setupScreenSettings();
		setContentView(R.layout.leavefeedback);
		setupVariables();
	}

	private void setupScreenSettings() {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		Window window = getWindow();
		window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
	}

	private void setupVariables() {
		ratingbar1 = (RatingBar) findViewById(R.id.ratingBar1);
		ratingbar2 = (RatingBar) findViewById(R.id.ratingBar2);
		ratingbar3 = (RatingBar) findViewById(R.id.ratingBar3);
		etFeedback = (EditText) findViewById(R.id.etFeedback);
		bFeedback = (Button) findViewById(R.id.bFeedback);
		bGoBack = (Button) findViewById(R.id.bBackButtonLeaveFeedback);
		bFeedback.setOnClickListener(this);
		bGoBack.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bFeedback:

			SimpleDateFormat localDateFormat = new SimpleDateFormat();
			String temp0 = new String(localDateFormat.format(new Date())
					.toString());
			String temp1 = new String("Apperance: "
					+ (Float.toString(ratingbar1.getRating())));
			String temp2 = new String("Presentation: "
					+ (Float.toString(ratingbar2.getRating())));
			String temp3 = new String("Design: "
					+ (Float.toString(ratingbar3.getRating())));
			String temp4 = new String();
			if (etFeedback.getText().toString().length() > 0) {
				temp4 = new String("\nAdditional Comments: "
						+ etFeedback.getText().toString());
			}

			Context context = getApplicationContext();
			String text = new String(temp0 + "\n" + temp1 + "\n" + temp2 + "\n"
					+ temp3 + temp4);
			int duration = Toast.LENGTH_LONG;
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
			break;
		case R.id.bBackButtonLeaveFeedback:
			finish();
			break;
		}
	}
}