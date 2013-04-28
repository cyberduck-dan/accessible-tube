package com.example.accessible_tube;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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
	
	
	
	public void ButOnClickXml(View v) {
		EditText editText1 = (EditText) findViewById(R.id.editText1);		
		
		double lat;
		double lon;
		
		try{
			Location loc = getLocation();
			lat = loc.getLatitude();
			lon = loc.getLongitude();
			editText1.setText("Lat - " + Double.toString(lat) + ", Lon - " + Double.toString(lon));
		}catch(Exception e){			
			editText1.setText("Could not access the location service");
		}
		
	}
	
	private Location getLocation(){
		 // Get the location manager
		 LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
		 Criteria criteria = new Criteria();
		 String bestProvider = locationManager.getBestProvider(criteria, false);
		 return locationManager.getLastKnownLocation(bestProvider);	
	}
}
