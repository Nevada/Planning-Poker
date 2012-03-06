package com.netlight.poker;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Card extends Activity {

	private PokerApp app;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.card);

		app = (PokerApp) getApplication();

		TextView title = (TextView) findViewById(R.id.number);
		title.setText(app.getCurrentCard());
		TextView small_title = (TextView) findViewById(R.id.small_number);
		small_title.setText(app.getCurrentCard());
		if (app.getCurrentCard().equals("Break?")) {
			title.setTextSize(70f);
		}
	}

}