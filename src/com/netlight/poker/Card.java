package com.netlight.poker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Card extends Activity {

	private static final int ABOUT = 0;
	private static final int SETTINGS = 1;
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, ABOUT, 0, R.string.about);
		menu.add(0, SETTINGS, 0, R.string.settings);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case ABOUT:
			Intent about = new Intent(Card.this, About.class);
			startActivity(about);
			return true;
		case SETTINGS:
			Intent pref = new Intent(Card.this, PreferenceHelper.class);
			startActivity(pref);
			return true;

		}
		return super.onOptionsItemSelected(item);
	}

	public void back(View view) {
		finish();
	}

}