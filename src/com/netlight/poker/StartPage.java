package com.netlight.poker;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class StartPage extends Activity {

	SharedPreferences prefs;
	List<Button> buttons;

	private static final int ABOUT = 0;
	private static final int SETTINGS = 1;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start_page);

		buttons = new ArrayList<Button>();
		Button b1 = (Button) findViewById(R.id.b1);
		Button b2 = (Button) findViewById(R.id.b2);
		Button b3 = (Button) findViewById(R.id.b3);
		Button b4 = (Button) findViewById(R.id.b4);
		Button b5 = (Button) findViewById(R.id.b5);
		Button b6 = (Button) findViewById(R.id.b6);
		Button b7 = (Button) findViewById(R.id.b7);
		Button b8 = (Button) findViewById(R.id.b8);
		Button b9 = (Button) findViewById(R.id.b9);
		Button b10 = (Button) findViewById(R.id.b10);
		buttons.add(b1);
		buttons.add(b2);
		buttons.add(b3);
		buttons.add(b4);
		buttons.add(b5);
		buttons.add(b6);
		buttons.add(b7);
		buttons.add(b8);
		buttons.add(b9);
		buttons.add(b10);

		prefs = PreferenceManager.getDefaultSharedPreferences(this);

	}

	@Override
	protected void onResume() {
		super.onResume();
		int list = Integer.parseInt(prefs.getString("listPref", "0"));
		String[] numbers = null;
		switch (list) {
		case 0:
			numbers = getResources().getStringArray(R.array.Fibonacci);
			break;
		case 1:
			numbers = getResources().getStringArray(R.array.oneten);
			break;
		case 2:
			numbers = getResources().getStringArray(R.array.Binary);
			break;
		case 3:
			numbers = getResources().getStringArray(R.array.Large);
			break;
		case 4:
			String unparsed = prefs.getString("customPref",
					"0,0,0,0,0,0,0,0,0,0");
			numbers = unparsed.split(",");
			if (numbers.length != 10) {
				numbers = getResources().getStringArray(R.array.Fibonacci);
			}
		}
		int i = 0;
		for (Button button : buttons) {
			button.setText(numbers[i]);
			i++;
		}
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
		menu.add(0, ABOUT, 0, R.string.about);
		menu.add(0, SETTINGS, 0, R.string.settings);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case ABOUT:
			Intent about = new Intent(StartPage.this, About.class);
			startActivity(about);
			return true;
		case SETTINGS:
			Intent pref = new Intent(StartPage.this, PreferenceHelper.class);
			startActivity(pref);
			return true;

		}
		return super.onOptionsItemSelected(item);
	}

}