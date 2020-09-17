package com.techlad.instabio;

/**
 * Created by Kshitij on 8/2/2017.
 */

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.io.InputStream;


public class FullImageActivity extends AppCompatActivity {
	InterstitialAd mInterstitialAd;


	ProgressDialog pDialog;
	ImageView img;
	Bitmap bitmap;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fullimageview);

		mInterstitialAd = new InterstitialAd(this);
		mInterstitialAd.setAdUnitId(getString(R.string.interstitial_full_screen));
		AdRequest Request = new AdRequest.Builder()
				.build();
		mInterstitialAd.loadAd(Request);
		mInterstitialAd.setAdListener(new AdListener() {
			public void onAdLoaded() {
				showInterstitial();
			}
		});

		Intent i = getIntent();
		int position = i.getExtras().getInt("id");
		ImageAdapter imageAdapter = new ImageAdapter(this);

		img = (ImageView) findViewById(R.id.singleimage);
		String url = imageAdapter.getItem(position);

		new DownloadImage().execute(url);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			Intent intent = new Intent(FullImageActivity.this, AboutApp.class);
			startActivity(intent);
		}
		if (id == R.id.rate) {
			String url = "https://play.google.com/store/apps/details?id=com.techlad.instabio";
			Intent i = new Intent(Intent.ACTION_VIEW);
			i.setData(Uri.parse(url));
			startActivity(i);
			Toast.makeText(this, "So Sweet :)", Toast.LENGTH_LONG).show();
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onSupportNavigateUp() {
		onBackPressed();
		return true;
	}

	private void showInterstitial() {
		if (mInterstitialAd.isLoaded()) {
			mInterstitialAd.show();
		}
	}

	private class DownloadImage extends AsyncTask<String, Void, Bitmap> {

		@Override
		protected Bitmap doInBackground(String... URL) {
			String imageURL = URL[0];
			Bitmap bitmap = null;
			try {
				InputStream input = new java.net.URL(imageURL).openStream();
				bitmap = BitmapFactory.decodeStream(input);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return bitmap;
		}

		@Override
		protected void onPostExecute(Bitmap result) {
			img.setImageBitmap(result);
		}
	}
}