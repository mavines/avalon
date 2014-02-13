package badger.avalon;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends Activity {
	private static final String TAG = "MainActivity";

	private static final int PAUSE = 500;

	private SoundPool sounds;

	private boolean merlin = false;
	private boolean percival = false;
	private boolean galahad = false;
	private boolean guinevere = false;
	private boolean bedivere = false;
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


	public void showGuinevereRules(View view) {
		showRules(R.string.guinevere, R.string.guinevere_include,
				R.string.guinevere_rules, R.string.guinevere_advantage, R.color.loyalBlue);
	}

	public void showGalahadRules(View view) {
		showRules(R.string.galahad, R.string.galahad_include,
				R.string.galahad_rules, R.string.galahad_advantage, R.color.loyalBlue);
	}

	public void showBedivereRules(View view) {
		showRules(R.string.bedivere, R.string.bedivere_include,
				R.string.bedivere_rules, R.string.bedivere_advantage, R.color.loyalBlue);
	}

	private void showRules(int titleId, int includeId, int rulesId,
			int advantageId, int titleColorId) {

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		// Get the layout inflater
		LayoutInflater inflater = this.getLayoutInflater();

		// Inflate and set the layout for the dialog
		// Pass null as the parent view because its going in the dialog layout
		View dialogView = inflater.inflate(R.layout.rules_dialog, null);
		builder.setView(dialogView)
				.setPositiveButton(R.string.ok,
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								dialog.dismiss();
							}
						});

		
		AlertDialog dialog = builder.create();

		TextView titleView = (TextView)dialogView.findViewById(R.id.dialog_title);
		titleView.setText(titleId);
		titleView.setBackgroundResource(titleColorId);
		
		TextView includeView = (TextView)dialogView.findViewById(R.id.dialog_include);
		includeView.setText(includeId);
		
		TextView rulesView = (TextView)dialogView.findViewById(R.id.dialog_rules);
		rulesView.setText(rulesId);
		
		TextView advantageView = (TextView)dialogView.findViewById(R.id.dialog_advantage);
		advantageView.setText(advantageId);
		
		dialog.show();

		/*
		 * AlertDialog.Builder builder = new AlertDialog.Builder(this);
		 * 
		 * builder.setMessage(rulesId) .setTitle(titleId);
		 * 
		 * builder.setPositiveButton(R.string.ok, new
		 * DialogInterface.OnClickListener() { public void
		 * onClick(DialogInterface dialog, int id) { dialog.dismiss(); } });
		 * 
		 * AlertDialog dialog = builder.create(); dialog.show();
		 */
	}

	public void start(View view) {
		Log.d(TAG, "Starting!");

		CheckBox merlinCheckBox = (CheckBox) findViewById(R.id.merlinCheckBox);
		merlin = merlinCheckBox.isChecked();

		CheckBox percivalCheckBox = (CheckBox) findViewById(R.id.percivalCheckBox);
		percival = percivalCheckBox.isChecked();

		CheckBox galahadCheckBox = (CheckBox) findViewById(R.id.galahadCheckBox);
		galahad = galahadCheckBox.isChecked();

		CheckBox guinevereCheckBox = (CheckBox) findViewById(R.id.guinevereCheckBox);
		guinevere = guinevereCheckBox.isChecked();

		CheckBox bedivereCheckBox = (CheckBox) findViewById(R.id.bedivereCheckBox);
		bedivere = bedivereCheckBox.isChecked();

		CheckBox morgannaCheckBox = (CheckBox) findViewById(R.id.morgannaCheckBox);
		morganna = morgannaCheckBox.isChecked();

		CheckBox mordredCheckBox = (CheckBox) findViewById(R.id.mordredCheckBox);
		mordred = mordredCheckBox.isChecked();

		CheckBox oberonCheckBox = (CheckBox) findViewById(R.id.oberonCheckBox);
		oberon = oberonCheckBox.isChecked();

		CheckBox lancelotCheckBox = (CheckBox) findViewById(R.id.lancelotCheckBox);
		lancelot = lancelotCheckBox.isChecked();

		playClip();
	}

	private void playClip() {
		playStartPhase();
		playMinions();
		playMerlin();
		playPercival();
		playLancelot();
		playGuinevere();
		playFinal();
	}

	private void playSound(int soundId) {
		MediaPlayer player = MediaPlayer.create(MainActivity.this, soundId);
		player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

			@Override
			public void onCompletion(MediaPlayer mp) {
				mp.release();
			}
		});

		player.start();
		while (player.isPlaying())
			;
	}

	private void playStartPhase() {
		playSound(R.raw.start);
	}

	private void pause() {
		try {
			Thread.sleep(PAUSE);
		} catch (InterruptedException e) {
			Log.d(TAG, "Exception sleeping: " + e.getMessage());
		}
	}

	private void playMinions() {
		if (oberon && lancelot) {
			playSound(R.raw.minion_yes_oberon_yes_lancelot);
		} else if (oberon && !lancelot) {
			playSound(R.raw.minion_yes_oberon_no_lancelot);
		} else if (!oberon && lancelot) {
			playSound(R.raw.minion_no_oberon_yes_lancelot);
		} else {
			playSound(R.raw.minion_no_oberon_no_lancelot);
		}

		pause();

		playSound(R.raw.minion_reset);

		pause();
	}

	private void playMerlin() {
		if (!merlin) {
			return;
		}

		if (mordred) {
			playSound(R.raw.merlin_yes_mordred);
		} else {
			playSound(R.raw.merlin_no_mordred);
		}

		pause();

		playSound(R.raw.merlin_reset);

		pause();
	}

	private void playPercival() {
		if (!percival) {
			return;
		}

		if (morganna) {
			playSound(R.raw.percival_yes_morganna);
		} else {
			playSound(R.raw.percival_no_morganna);
		}

		pause();

		playSound(R.raw.percival_reset);

		pause();
	}

	private void playLancelot() {
		if (!lancelot) {
			return;
		}

		playSound(R.raw.lancelot);

		pause();

		playSound(R.raw.lancelot_reset);

		pause();
	}

	private void playGuinevere() {
		if (guinevere) {
			playSound(R.raw.guinevere);
			pause();
		}
	}

	private void playFinal() {
		playSound(R.raw.final_reset);
	}

}
