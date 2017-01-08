package com.eriwang.testtimer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.eriwang.testtimer.timer.TestCountdownTimer;

public class TestTakingActivity extends AppCompatActivity {

	CountDownTimer testCountDownTimer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test_taking);

		TextView testCountDownTimerTextView = (TextView) findViewById(R.id.fullTestTimer);
		testCountDownTimer = new TestCountdownTimer(60 * 1000, 1000, testCountDownTimerTextView);
		testCountDownTimer.start();
	}

}
