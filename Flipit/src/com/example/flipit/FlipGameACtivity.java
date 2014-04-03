package com.example.flipit;

import android.app.Activity;
import android.content.res.Configuration;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class FlipGameACtivity extends Activity {
	TextView textviewOrientation;
	TextView laps;
	int counter;
	String x;
	String x1;
	String x2;
	String x3;
	OrientationEventListener myOrientationEventListener;

	
	/** Called when the activity is first created. */
	  @Override
	  public void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.activity_flip_game_activity);
	      textviewOrientation = (TextView)findViewById(R.id.textorientation);
	      laps = (TextView)findViewById(R.id.laps);
	      counter = 0;
	    
	      myOrientationEventListener
	   = new OrientationEventListener(this, SensorManager.SENSOR_DELAY_NORMAL){

	    	  @Override
	    	    public void onOrientationChanged(int arg0) {
	    	     // TODO Auto-generated method stub
	    		 String x = String.valueOf(arg0);
	    		 if(x.equals("-1")){
	    			 
	    		 }
	    	     textviewOrientation.setText("Orientation: " + String.valueOf(arg0));
	    	    }};
	    	    
	    	    if (myOrientationEventListener.canDetectOrientation()){
	    	        Toast.makeText(this, "Can DetectOrientation", Toast.LENGTH_LONG).show();
	    	        myOrientationEventListener.enable();
	    	       }
	    	       else{
	    	        Toast.makeText(this, "Can't DetectOrientation", Toast.LENGTH_LONG).show();
	    	        finish();
	    	       }
	    	    
	    	   }

	    	 @Override
	    	 protected void onDestroy() {
	    	  // TODO Auto-generated method stub
	    	  super.onDestroy();
	    	  myOrientationEventListener.disable();
	    	    
}
}
