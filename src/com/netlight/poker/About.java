package com.netlight.poker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class About extends Activity {

	private static final int SETTINGS = 1;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, SETTINGS, 0, R.string.settings);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case SETTINGS:
			Intent pref = new Intent(About.this, PreferenceHelper.class);
			startActivity(pref);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
