package com.example.flipit;

import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
 
public class SplashActivity extends Activity {
	
   private static String TAG = SplashActivity.class.getName();
   private static long SLEEP_TIME = 5;    // Sleep for some time
 
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      MediaPlayer mp = new MediaPlayer();
      
      try {
    	mp = MediaPlayer.create(getBaseContext(), R.raw.evil);
		mp.start();
	} catch (IllegalArgumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SecurityException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalStateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      
 
      this.requestWindowFeature(Window.FEATURE_NO_TITLE);    // Removes title bar
      this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);    // Removes notification bar
 
      setContentView(R.layout.splash);
 
      // Start timer and launch main activity
      IntentLauncher launcher = new IntentLauncher();
      launcher.start();
   }
 
   private class IntentLauncher extends Thread {
      @Override
      /**
       * Sleep for some time and than start new activity.
       */
      public void run() {
         try {
            // Sleeping
            Thread.sleep(SLEEP_TIME*1000);
         } catch (Exception e) {
            Log.e(TAG, e.getMessage());
         }
 
         // Start main activity
         Intent intent = new Intent(SplashActivity.this, MainActivity.class);
         SplashActivity.this.startActivity(intent);
         //SplashActivity.this.finish();
      }
   }
}
