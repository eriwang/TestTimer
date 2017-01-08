package com.eriwang.testtimer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.eriwang.testtimer.timer.QuestionCountUpTimer;
import com.eriwang.testtimer.timer.TestCountdownTimer;

public class TestTakingActivity extends AppCompatActivity {

	TestCountdownTimer fullTestTimer;
	QuestionCountUpTimer questionTimer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test_taking);

		TextView fullTestTimerTextView = (TextView) findViewById(R.id.fullTestTimer);
		fullTestTimer = new TestCountdownTimer(60 * 1000, 1000, fullTestTimerTextView);

		TextView questionTimerTextView = (TextView) findViewById(R.id.questionTimer);
		questionTimer = new QuestionCountUpTimer(60 * 1000, 1000, questionTimerTextView);

		fullTestTimer.start();
		questionTimer.start();
	}

}
