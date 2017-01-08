package com.eriwang.testtimer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.concurrent.TimeUnit;

public class TestConfigurationActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test_configuration);
	}

	// FIXME: error checking
	public void startTest(View view) {
		Intent intent = new Intent(this, TestTakingActivity.class);

		EditText numQuestionsEditText = (EditText) findViewById(R.id.numQuestions);
		int numQuestions = Integer.valueOf(numQuestionsEditText.getText().toString());

		EditText timeForTestEditText = (EditText) findViewById(R.id.timeForTest);
		long timeForTest = getMillisecondsFromTimeString(timeForTestEditText.getText().toString());

		intent.putExtra("NUM_QUESTIONS", numQuestions);
		intent.putExtra("TIME_FOR_TEST", timeForTest);

		startActivity(intent);
	}

	private long getMillisecondsFromTimeString(String timeString) {
		String[] timeStringSplit = timeString.split(":");
		int hours = Integer.valueOf(timeStringSplit[0]);
		int minutes = Integer.valueOf(timeStringSplit[1]);

		return TimeUnit.HOURS.toMillis(hours) + TimeUnit.MINUTES.toMillis(minutes);
	}
}
