package com.eriwang.testtimer.timer;

import android.os.CountDownTimer;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class QuestionCountUpTimer extends CountDownTimer {
	private TextView timerTextView;
	private long timerLength;

	public QuestionCountUpTimer(long _timerLength, long countDownInterval, TextView _timerTextView) {
		super(_timerLength, countDownInterval);
		timerTextView = _timerTextView;
		timerLength = _timerLength;
	}

	@Override
	public void onTick(long time) {
		long timeElapsed = timerLength - time;
		timerTextView.setText(millisToTimeString(timeElapsed));
	}

	@Override
	public void onFinish() {

	}

	private String millisToTimeString(long ms) {
		long seconds = TimeUnit.MILLISECONDS.toSeconds(ms) + 1;
		return String.valueOf(seconds);
	}
}
