package com.techlad.instabio;

/**
 * Created by Kshitij on 7/27/2017.
 */

import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splashscreen extends Activity {
	/**
	 * Called when the activity is first created.
	 */
	Thread splashTread;

	public void onAttachedToWindow() {
		super.onAttachedToWindow();
		Window window = getWindow();
		window.setFormat(PixelFormat.RGBA_8888);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_splashscreen);
		StartAnimations();
	}

	private void StartAnimations() {
		Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
		anim.reset();
		ImageView l = findViewById(R.id.splash);
		l.clearAnimation();
		l.startAnimation(anim);


		splashTread = new Thread() {
			@Override
			public void run() {
				try {
					int waited = 0;
					// Splash screen pause time
					while (waited < 1000) {
						sleep(100);
						waited += 100;
					}
					Intent intent = new Intent(Splashscreen.this,
							WelcomeActivity.class);
					intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
					startActivity(intent);
					Splashscreen.this.finish();
				} catch (InterruptedException e) {
					// do nothing
				} finally {
					Splashscreen.this.finish();
				}

			}
		};
		splashTread.start();

	}

}