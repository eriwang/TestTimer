package com.eriwang.testtimer.question;

public class QuestionInformation {
	private long questionNumber;
	private long time;

	public QuestionInformation(long _questionNumber, long _time) {
		questionNumber = _questionNumber;
		time = _time;
	}

	public String toString() {
		return String.format("Question %1d, %2d milliseconds", questionNumber, time);
	}
}
