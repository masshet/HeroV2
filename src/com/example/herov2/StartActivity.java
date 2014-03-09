package com.example.herov2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class StartActivity extends Activity implements OnClickListener {
	
	Button log;
	Button sign;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start_activity);
		
		log = (Button) findViewById(R.id.log_in);
		sign = (Button) findViewById(R.id.sign_up);
		
		log.setOnClickListener(this);
		sign.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent;
		switch (v.getId()) {
		case R.id.log_in:
			intent = new Intent(StartActivity.this, LogInActivity.class);
			startActivity(intent);
			break;
		case R.id.sign_up:
			intent = new Intent(StartActivity.this, SignUpActivity.class);
			startActivity(intent);
			break;
		default:
			break;
		}
		
	}

}
