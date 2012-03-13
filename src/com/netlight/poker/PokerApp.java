package com.netlight.poker;

import android.app.Application;
import android.preference.PreferenceManager;

public class PokerApp extends Application {

	private String currentCard;
	private int index;
	private String[] currentNumbers;

	@Override
	public void onCreate() {
		super.onCreate();
		PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
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

	public void setCurrentIndex(int i) {
		index = i;
	}

	int getCurrentIndex() {
		return index;
	}
}
