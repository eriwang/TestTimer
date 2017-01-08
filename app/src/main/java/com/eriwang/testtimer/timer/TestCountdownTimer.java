package com.eriwang.testtimer.timer;

import android.os.CountDownTimer;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class TestCountdownTimer extends CountDownTimer {

	TextView timerTextView;

	public TestCountdownTimer(long millisInFuture, long countDownInterval, TextView _timerTextView) {
		super(millisInFuture, countDownInterval);
		timerTextView = _timerTextView;
	}

	@Override
	public void onTick(long time) {
		timerTextView.setText(millisToTimeString(time));
	}

	@Override
	public void onFinish() {

	}

	private String millisToTimeString(long ms) {
		long seconds = TimeUnit.MILLISECONDS.toSeconds(ms);
		return String.valueOf(seconds);
	}

}
