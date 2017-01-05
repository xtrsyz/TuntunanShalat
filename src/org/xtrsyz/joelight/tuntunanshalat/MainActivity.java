package org.xtrsyz.joelight.tuntunanshalat;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

	static final String[]gerakanShalat = new String[] { "Takbir", "Rukuk", "Ikhtidal", "Sujud", "Duduk diantara dua sujud", "Tahyat awal", "Tahyat akhir", "Salam", "Sujud syahwi" };
	static final String[]shalatWajib = new String[] { "Subuh", "Dzuhur", "Ashar", "Maghrib", "Isya",};
	static final String[]shalatSunnah = new String[] { "Tasbih", "Idul Fitri", "Jenazah", "Gerhana"};
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //untuk shared activity BEGIN
		final Intent intent = new Intent( getBaseContext(), MenuListActivity.class);  
        final Bundle b = new Bundle();  
        //untuk shared activity END
        
        Button tombolInfo = (Button) findViewById(R.id.bPosisiBerjamaah);
	    tombolInfo.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
		        Intent intent = new Intent( getBaseContext(), InfoActivity.class);  
	            Bundle b = new Bundle();
	            b.putString("name", "jamaah" );
	            intent.putExtras(b);
	            startActivity(intent);  
			}
		});
        
        Button bGerakanShalat = (Button) findViewById(R.id.bGerakanShalat);
        bGerakanShalat.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//Toast.makeText(getApplicationContext(), "air", Toast.LENGTH_SHORT).show();
				
				b.putStringArray("listshalat", gerakanShalat);           
		        intent.putExtras(b);
		        startActivity(intent);
			}
		});

        Button bShalatWajib = (Button) findViewById(R.id.bShalatWajib);
        bShalatWajib.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				b.putStringArray("listshalat", shalatWajib);           
		        intent.putExtras(b);
		        startActivity(intent);
			}
		});
        
        Button bShalatSunnah = (Button) findViewById(R.id.bShalatSunnah);
        bShalatSunnah.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				b.putStringArray("listshalat", shalatSunnah);           
		        intent.putExtras(b);
		        startActivity(intent);
			}
		});
        
        Button tombolexit = (Button) findViewById(R.id.bExit);
        tombolexit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				keluarga();
			}
		});

        Button tombolabout = (Button)findViewById(R.id.bAbout);
        tombolabout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent( getBaseContext(), InfoActivity.class);  
	            Bundle b = new Bundle();
				b.putString("name", "about" );
	            intent.putExtras(b);
	            startActivity(intent);  
			}
		});
        
	}
	public void keluarga(){
    	DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    //Yes button clicked
                	finish();
                    break;

                case DialogInterface.BUTTON_NEGATIVE:
                    //No button clicked
                    break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure?").setPositiveButton("Yes", dialogClickListener)
            .setNegativeButton("No", dialogClickListener).show();
    }

}
