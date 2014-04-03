package com.example.flipit;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
<<<<<<< HEAD
import android.view.View.OnClickListener;
import android.widget.Button;
=======
>>>>>>> origin/master

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

<<<<<<< HEAD
	
	/*public void playsound(View view){
		Intent intet = new Intent(this, MainActivity.class);
	Button b = (Button) findViewById(R.id.button1);
	b.
	
	}*/
	
	
=======
	public void flip(View view){
		Intent intent = new Intent(this, FlipGameACtivity.class);
		
		startActivity(intent);
	}
>>>>>>> origin/master
	
}
