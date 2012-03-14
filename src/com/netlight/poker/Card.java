package com.netlight.poker;

import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class Card extends Activity {

	private ViewPager awesomePager;
	private static int NUM_CARDS = 12;
	private Context context;
	private AwesomePagerAdapter awesomeAdapter;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pager);
		context = this;

		awesomeAdapter = new AwesomePagerAdapter();
		awesomePager = (ViewPager) findViewById(R.id.awesomepager);
		awesomePager.setAdapter(awesomeAdapter);

		PokerApp app = (PokerApp) getApplication();
		awesomePager.setCurrentItem(app.getCurrentIndex());

	}

	public void back(View view) {
		finish();
	}

	private class AwesomePagerAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			return NUM_CARDS;
		}

		/**
		 * Create the page for the given position. The adapter is responsible
		 * for adding the view to the container given here, although it only
		 * must ensure this is done by the time it returns from
		 * {@link #finishUpdate()}.
		 * 
		 * @param container
		 *            The containing View in which the page will be shown.
		 * @param position
		 *            The page position to be instantiated.
		 * @return Returns an Object representing the new page. This does not
		 *         need to be a View, but can be some other container of the
		 *         page.
		 */
		@Override
		public Object instantiateItem(View collection, int position) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View layout;
			PokerApp app = (PokerApp) getApplication();
			String[] texts = app.getCurrentNumbers();

			switch (position) {
			case 10:
				layout = inflater.inflate(R.layout.card, null);
				TextView text = (TextView) layout.findViewById(R.id.number);
				text.setText("?");
				TextView small = (TextView) layout
						.findViewById(R.id.small_number);
				small.setText("?");
				break;
			case 11:
				layout = inflater.inflate(R.layout.card, null);
				TextView small2 = (TextView) layout
						.findViewById(R.id.small_number);
				small2.setText("Break?");

				setImage(layout);
				break;

			default:
				layout = inflater.inflate(R.layout.card, null);

				TextView text2 = (TextView) layout.findViewById(R.id.number);
				if (texts[position] != null) {
					text2.setText(texts[position]);
					TextView small3 = (TextView) layout
							.findViewById(R.id.small_number);
					small3.setText(texts[position]);
				}
				break;
			}

			((ViewPager) collection).addView(layout, 0);

			return layout;
		}

		private void setImage(View layout) {
			TextView image = (TextView) layout.findViewById(R.id.number);

			Random generator = new Random();
			int random = generator.nextInt(13);
			switch (random) {
			case 0:
				image.setBackgroundResource(R.drawable.coffee);
				break;
			case 1:
				image.setBackgroundResource(R.drawable.wine);
				break;
			case 2:
				image.setBackgroundResource(R.drawable.drunk);
				break;
			case 3:
				image.setBackgroundResource(R.drawable.tea);
				break;
			case 4:
				image.setBackgroundResource(R.drawable.coffee2);
				break;
			case 5:
				image.setBackgroundResource(R.drawable.milkshake);
				break;
			case 6:
				image.setBackgroundResource(R.drawable.soda);
				break;
			case 7:
				image.setBackgroundResource(R.drawable.bottle);
				break;
			case 8:
				image.setBackgroundResource(R.drawable.can);
				break;
			case 9:
				image.setBackgroundResource(R.drawable.beer);
				break;
			case 10:
				image.setBackgroundResource(R.drawable.glas);
				break;
			case 11:
				image.setBackgroundResource(R.drawable.pot);
				break;
			case 12:
				image.setBackgroundResource(R.drawable.takeaway);
				break;
			case 13:
				image.setBackgroundResource(R.drawable.water);
				break;
			default:
				break;
			}
		}

		/**
		 * Remove a page for the given position. The adapter is responsible for
		 * removing the view from its container, although it only must ensure
		 * this is done by the time it returns from {@link #finishUpdate()}.
		 * 
		 * @param container
		 *            The containing View from which the page will be removed.
		 * @param position
		 *            The page position to be removed.
		 * @param object
		 *            The same object that was returned by
		 *            {@link #instantiateItem(View, int)}.
		 */
		@Override
		public void destroyItem(View collection, int position, Object view) {
			((ViewPager) collection).removeView((View) view);
			// ((ViewPager) collection).removeView((Button) view);
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			// return view == ((Button) object);
			return view == object;
		}

		/**
		 * Called when the a change in the shown pages has been completed. At
		 * this point you must ensure that all of the pages have actually been
		 * added or removed from the container as appropriate.
		 * 
		 * @param container
		 *            The containing View which is displaying this adapter's
		 *            page views.
		 */
		@Override
		public void finishUpdate(View arg0) {
		}

		@Override
		public void restoreState(Parcelable arg0, ClassLoader arg1) {
		}

		@Override
		public Parcelable saveState() {
			return null;
		}

		@Override
		public void startUpdate(View arg0) {
		}

	}

}