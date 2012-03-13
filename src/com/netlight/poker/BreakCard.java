package com.netlight.poker;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class BreakCard extends Activity {

	private static final int ABOUT = 0;
	private static final int SETTINGS = 1;
	private PokerApp app;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.break_card);

		app = (PokerApp) getApplication();

		TextView small_title = (TextView) findViewById(R.id.small_number);
		small_title.setText(app.getCurrentCard());

		ImageView image = (ImageView) findViewById(R.id.image);
		Random generator = new Random();
		int random = generator.nextInt(13);
		switch (random) {
		case 0:
			image.setImageResource(R.drawable.coffee);
			break;
		case 1:
			image.setImageResource(R.drawable.wine);
			break;
		case 2:
			image.setImageResource(R.drawable.drunk);
			break;
		case 3:
			image.setImageResource(R.drawable.tea);
			break;
		case 4:
			image.setImageResource(R.drawable.coffee2);
			break;
		case 5:
			image.setImageResource(R.drawable.milkshake);
			break;
		case 6:
			image.setImageResource(R.drawable.soda);
			break;
		case 7:
			image.setImageResource(R.drawable.bottle);
			break;
		case 8:
			image.setImageResource(R.drawable.can);
			break;
		case 9:
			image.setImageResource(R.drawable.beer);
			break;
		case 10:
			image.setImageResource(R.drawable.glas);
			break;
		case 11:
			image.setImageResource(R.drawable.pot);
			break;
		case 12:
			image.setImageResource(R.drawable.takeaway);
			break;
		case 13:
			image.setImageResource(R.drawable.water);
			break;
		default:
			break;
		}

	}

	@Override
	protected void onResume() {
		super.onResume();

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
			Intent about = new Intent(BreakCard.this, About.class);
			startActivity(about);
			return true;
		case SETTINGS:
			Intent pref = new Intent(BreakCard.this, PreferenceHelper.class);
			startActivity(pref);
			return true;

		}
		return super.onOptionsItemSelected(item);
	}

	public void back(View view) {
		finish();
	}

}