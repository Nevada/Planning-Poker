package com.netlight.poker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class StartPage extends Activity {

	private static final int POKER = 0;
	private static final int NETLIGHT = 1;
	private static final int SETTINGS = 2;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

	}

	public void showCard(View view) {
		Button b = (Button) view;
		String buttonText = b.getText().toString();
		PokerApp app = (PokerApp) getApplication();
		app.setCurrentCard(buttonText);
		Intent card = new Intent(StartPage.this, Card.class);
		startActivity(card);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, POKER, 0, R.string.poker);
		menu.add(0, NETLIGHT, 0, R.string.netlight);
		menu.add(0, SETTINGS, 0, R.string.settings);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case POKER:
			Intent about = new Intent(StartPage.this, About.class);
			startActivity(about);
			return true;
		case NETLIGHT:
			Intent netlight = new Intent(StartPage.this, Netlight.class);
			startActivity(netlight);
			return true;
		case SETTINGS:
			Intent pref = new Intent(StartPage.this, PreferenceHelper.class);
			startActivity(pref);
			return true;

		}
		return super.onOptionsItemSelected(item);
	}

}