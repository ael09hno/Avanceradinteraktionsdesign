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
	boolean x0 = false;
	boolean x1 = false;
	boolean x2 = false;
	boolean x3 = false;


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
	    		 String temp = String.valueOf(arg0);
	    		 if(temp.equals("90")){
	    			 x0 = true;
	    		 }
	    		 if(temp.equals("-1") & x0){
	    			 x1 = true;
	    		 }
	    		 if(temp.equals("270") & x1){
	    			 x2 = true;
	    		 }
	    		 if(temp.equals("-1") & x2){
	    			 x3 = true;
	    		 }
	    		 if(temp.equals("90") & x3){
	    			 counter = counter +1;
	    			 x1 = false;
	    			 x2 = false;
	    			 x3 = false;
	    		 }
	    	     textviewOrientation.setText("Orientation: " + String.valueOf(arg0));
	    	     laps.setText("Laps: " + String.valueOf(counter));
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
