package badger.avalon;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ToggleButton;

public class MainActivity extends Activity {
	private static final String TAG = "MainActivity";
	
	private boolean merlin = false;
	private boolean percival = false;
	private boolean galahad = false;
	private boolean gwenevere = false;
	private boolean bedevere = false;
	private boolean morganna = false;
	private boolean mordred = false;
	private boolean oberon = false;
	private boolean lancelot = false;
	
	
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
	
	public void start(View view)
	{
		Log.d(TAG, "Starting!");

		ToggleButton merlinButton = (ToggleButton)findViewById(R.id.merlinButton);
		merlin = merlinButton.isChecked();
		
		ToggleButton percivalButton = (ToggleButton)findViewById(R.id.percivalButton);
		percival = percivalButton.isChecked();

		ToggleButton galahadButton = (ToggleButton)findViewById(R.id.galahadButton);
		galahad = galahadButton.isChecked();

		ToggleButton gwenevereButton = (ToggleButton)findViewById(R.id.gwenevereButton);
		gwenevere = gwenevereButton.isChecked();

		ToggleButton bedevereButton = (ToggleButton)findViewById(R.id.bedevereButton);
		bedevere = bedevereButton.isChecked();

		ToggleButton morgannaButton = (ToggleButton)findViewById(R.id.morgannaButton);
		morganna = morgannaButton.isChecked();

		ToggleButton mordredButton = (ToggleButton)findViewById(R.id.mordredButton);
		mordred = mordredButton.isChecked();

		ToggleButton oberonButton = (ToggleButton)findViewById(R.id.oberonButton);
		oberon = oberonButton.isChecked();

		ToggleButton lancelotButton = (ToggleButton)findViewById(R.id.lancelotButton);
		lancelot = lancelotButton.isChecked();
		
		playClip();
	}
	
	private void playClip()
	{
	
	
	}
}
