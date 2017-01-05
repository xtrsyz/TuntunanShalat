package org.xtrsyz.joelight.tuntunanshalat;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class InfoActivity extends Activity {
	Integer nogam = 1;
	String nama;
	ImageView gambar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_info);
		
		Bundle b = getIntent().getExtras(); 
	    nama = b.getString("name").toLowerCase();
	    
	    gambar = (ImageView) findViewById(R.id.image_info);
	    int idimg = getResources().getIdentifier(getPackageName() + ":drawable/info_" + nama + "_" + nogam, null, null);
		gambar.setImageResource(idimg);
	    
	    Button tombolBack = (Button) findViewById(R.id.buttonInfo1);
		tombolBack.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if ( nogam > 1) {nogam--;
				int idimg = getResources().getIdentifier(getPackageName() + ":drawable/info_" + nama + "_" + nogam, null, null);
				gambar.setImageResource(idimg);
				} else {finish();}
			}
		});
		Button tombolNext = (Button) findViewById(R.id.buttonInfo2);
		tombolNext.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				nogam++;
				int idimg = getResources().getIdentifier(getPackageName() + ":drawable/info_" + nama + "_" + nogam, null, null);
				if (idimg < 1) nogam--;
				else gambar.setImageResource(idimg);
				
			}
		});
		
		
	}
}
