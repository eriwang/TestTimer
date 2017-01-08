package com.eriwang.testtimer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TestConfigurationActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test_configuration);
	}

	public void startTest(View view) {
		Intent intent = new Intent(this, TestTakingActivity.class);

		startActivity(intent);
	}
}
