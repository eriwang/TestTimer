package com.eriwang.testtimer.timer;

import android.os.CountDownTimer;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class QuestionCountUpTimer extends CountDownTimer {
	private TextView timerTextView;
	private long timerLength;
	private long timeElapsed;

	public QuestionCountUpTimer(long _timerLength, long countDownInterval, TextView _timerTextView) {
		super(_timerLength, countDownInterval);
		timerTextView = _timerTextView;
		timerLength = _timerLength;
	}

	@Override
	public void onTick(long time) {
		timeElapsed = timerLength - time;
		timerTextView.setText(millisToTimeString(timeElapsed));
	}

	@Override
	public void onFinish() {

	}

	public long getTimeElapsed() {
		return timeElapsed;
	}

	private String millisToTimeString(long ms) {
		long hours = TimeUnit.MILLISECONDS.toHours(ms);
		long minutes = TimeUnit.MILLISECONDS.toMinutes(ms % TimeUnit.HOURS.toMillis(1));
		long seconds = TimeUnit.MILLISECONDS.toSeconds(ms % TimeUnit.MINUTES.toMillis(1));
		return String.format("%1$02d:%2$02d:%3$02d", hours, minutes, seconds);
	}
}
