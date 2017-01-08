package com.eriwang.testtimer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.eriwang.testtimer.question.QuestionInformation;
import com.eriwang.testtimer.timer.QuestionCountUpTimer;
import com.eriwang.testtimer.timer.TestCountdownTimer;

import java.util.ArrayList;

public class TestTakingActivity extends AppCompatActivity {
	private long timeForTest;
	private int numQuestions;

	private TestCountdownTimer fullTestTimer;
	private QuestionCountUpTimer questionTimer;
	private int currentQuestionNumber;

	private ArrayList<QuestionInformation> questionsAnswered;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test_taking);

		Intent intent = getIntent();
		timeForTest = intent.getLongExtra("TIME_FOR_TEST", -1);
		numQuestions = intent.getIntExtra("NUM_QUESTIONS", -1);

		System.out.println(timeForTest);
		System.out.println(numQuestions);

		currentQuestionNumber = 1;

		fullTestTimer = null;
		questionTimer = null;
		questionsAnswered = new ArrayList<>();

		startFullTestTimer();
		startQuestionTimer();
		setQuestionNumber(currentQuestionNumber);
	}

	public void nextQuestion(View view) {
		long timeElapsed = questionTimer.getTimeElapsed();
		QuestionInformation questionInformation = new QuestionInformation(currentQuestionNumber, timeElapsed);
		questionsAnswered.add(questionInformation);

		++currentQuestionNumber;
		setQuestionNumber(currentQuestionNumber);

		startQuestionTimer();
	}

	public void showQuestionInformation(View view) {
		for (QuestionInformation qi : questionsAnswered) {
			System.out.println(qi);
		}
	}

	// FIXME: remove default values use real ones
	private void startFullTestTimer() {
		TextView fullTestTimerTextView = (TextView) findViewById(R.id.fullTestTimer);
		fullTestTimer = new TestCountdownTimer(timeForTest, 1000, fullTestTimerTextView);
		fullTestTimer.start();
	}

	// FIXME: remove default values use real ones
	private void startQuestionTimer() {
		if (questionTimer != null) {
			questionTimer.cancel();
		}

		TextView questionTimerTextView = (TextView) findViewById(R.id.questionTimer);
		questionTimer = new QuestionCountUpTimer(120 * 60 * 1000 + 5 * 1000, 1000, questionTimerTextView);
		questionTimer.start();
	}

	private void setQuestionNumber(int questionNumber) {
		TextView questionNumberTextView = (TextView) findViewById(R.id.questionNumber);
		questionNumberTextView.setText(String.valueOf(questionNumber));
	}

}
