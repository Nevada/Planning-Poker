package net.bahnhof.poker;

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
	}

}