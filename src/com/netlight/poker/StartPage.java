package com.netlight.poker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class StartPage extends Activity {

	private static final int ABOUT = 0;

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
		menu.add(0, StartPage.ABOUT, 0, R.string.about);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case ABOUT:
			Intent about = new Intent(StartPage.this, About.class);
			startActivity(about);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}