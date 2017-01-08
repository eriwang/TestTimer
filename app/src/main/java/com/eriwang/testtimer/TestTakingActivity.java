package com.eriwang.testtimer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.eriwang.testtimer.timer.QuestionCountUpTimer;
import com.eriwang.testtimer.timer.TestCountdownTimer;

public class TestTakingActivity extends AppCompatActivity {

	private TestCountdownTimer fullTestTimer;
	private QuestionCountUpTimer questionTimer;
	private int currentQuestionNumber;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test_taking);
		currentQuestionNumber = 1;

		fullTestTimer = null;
		questionTimer = null;

		startFullTestTimer();
		startQuestionTimer();
		setQuestionNumber(currentQuestionNumber);
	}

	public void nextQuestion(View view) {
		++currentQuestionNumber;
		setQuestionNumber(currentQuestionNumber);
		startQuestionTimer();
	}

	private void startFullTestTimer() {
		TextView fullTestTimerTextView = (TextView) findViewById(R.id.fullTestTimer);
		fullTestTimer = new TestCountdownTimer(120 * 60 * 1000 + 5 * 1000, 1000, fullTestTimerTextView);
		fullTestTimer.start();
	}

	private void startQuestionTimer() {
		if (questionTimer != null) {
			questionTimer.cancel();
		}

		TextView questionTimerTextView = (TextView) findViewById(R.id.questionTimer);
		questionTimer = new QuestionCountUpTimer(60 * 1000, 1000, questionTimerTextView);
		questionTimer.start();
	}

	private void setQuestionNumber(int questionNumber) {
		TextView questionNumberTextView = (TextView) findViewById(R.id.questionNumber);
		questionNumberTextView.setText(String.valueOf(questionNumber));
	}

}
