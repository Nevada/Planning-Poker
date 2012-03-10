package com.netlight.poker;

import android.app.Application;

public class PokerApp extends Application {

	private String currentCard;
	private String[] currentNumbers;

	@Override
	public void onCreate() {
		super.onCreate();
	}

	@Override
	public void onTerminate() {
		// not guaranteed to be called
		super.onTerminate();
	}

	public String getCurrentCard() {
		return currentCard;
	}

	public void setCurrentCard(String currentCard) {
		this.currentCard = currentCard;
	}

	public String[] getCurrentNumbers() {
		return currentNumbers;
	}

	public void setCurrentNumbers(String[] currentNumbers) {
		this.currentNumbers = currentNumbers;
	}
}
