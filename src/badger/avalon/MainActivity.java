package badger.avalon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends Activity implements
		MediaPlayer.OnCompletionListener {
	private static final String TAG = "MainActivity";

	private static final int PAUSE = 500;
	MediaPlayer mediaPlayer;

	private List<Integer> trackList;
	private Iterator<Integer> trackIterator;

	private boolean merlin = false;
	private boolean percival = false;
	private boolean galahad = false;
	private boolean guinevere = false;
	private boolean bedivere = false;
	private boolean morganna = false;
	private boolean mordred = false;
	private boolean oberon = false;
	private boolean lancelot = false;

	private String voicePreference;
	private Voice activeVoice;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setVolumeControlStream(AudioManager.STREAM_MUSIC);
		trackList = new ArrayList<Integer>();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection
		switch (item.getItemId()) {
		case R.id.action_settings:
			showSettings();
			return true;
		case R.id.action_credits:
			showCredits();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private void showSettings() {
		Log.d(TAG, "Showing settings");
		startActivity(new Intent(this, SettingsActivity.class));
	}

	private void showCredits() {
		Log.d(TAG, "Showing Credits");
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		// Get the layout inflater
		LayoutInflater inflater = this.getLayoutInflater();

		// Inflate and set the layout for the dialog
		// Pass null as the parent view because its going in the dialog layout
		View dialogView = inflater.inflate(R.layout.credits, null);
		builder.setView(dialogView).setPositiveButton(R.string.ok,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						dialog.dismiss();
					}
				});

		AlertDialog dialog = builder.create();
		dialog.show();
	}

	public void showGuinevereRules(View view) {
		showRules(R.string.guinevere, R.string.guinevere_include,
				R.string.guinevere_rules, R.string.guinevere_advantage,
				R.color.loyalBlue);
	}

	public void showGalahadRules(View view) {
		showRules(R.string.galahad, R.string.galahad_include,
				R.string.galahad_rules, R.string.galahad_advantage,
				R.color.loyalBlue);
	}

	public void showBedivereRules(View view) {
		showRules(R.string.bedivere, R.string.bedivere_include,
				R.string.bedivere_rules, R.string.bedivere_advantage,
				R.color.loyalBlue);
	}

	private void showRules(int titleId, int includeId, int rulesId,
			int advantageId, int titleColorId) {

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		// Get the layout inflater
		LayoutInflater inflater = this.getLayoutInflater();

		// Inflate and set the layout for the dialog
		// Pass null as the parent view because its going in the dialog layout
		View dialogView = inflater.inflate(R.layout.rules_dialog, null);
		builder.setView(dialogView).setPositiveButton(R.string.ok,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						dialog.dismiss();
					}
				});

		AlertDialog dialog = builder.create();

		TextView titleView = (TextView) dialogView
				.findViewById(R.id.dialog_title);
		titleView.setText(titleId);
		titleView.setBackgroundResource(titleColorId);

		TextView includeView = (TextView) dialogView
				.findViewById(R.id.dialog_include);
		includeView.setText(includeId);

		TextView rulesView = (TextView) dialogView
				.findViewById(R.id.dialog_rules);
		rulesView.setText(rulesId);

		TextView advantageView = (TextView) dialogView
				.findViewById(R.id.dialog_advantage);
		advantageView.setText(advantageId);

		dialog.show();
	}

	public void start(View view) {
		if (mediaPlayer != null && mediaPlayer.isPlaying()) {
			Log.d(TAG, "Stopping!");
			mediaPlayer.stop();

			Button startButton = (Button) findViewById(R.id.startButton);
			startButton.setText(R.string.start);
		} else {
			Log.d(TAG, "Starting!");

			Button startButton = (Button) findViewById(R.id.startButton);
			startButton.setText(R.string.stop);

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
	}

	private void playClip() {
		trackList.clear();
		SharedPreferences sharedPref = PreferenceManager
				.getDefaultSharedPreferences(this);
		voicePreference = sharedPref.getString(
				SettingsActivity.VOICE_PREFERENCE, "");
		if (voicePreference.equals(getString(R.string.female_voice))) {
			activeVoice = new FemaleVoice();
		} else {
			activeVoice = new MaleVoice();
		}
		addStartPhase();
		addMinions();
		addMerlin();
		addPercival();
		addLancelot();
		addGuinevere();
		addFinal();

		playTracks();
	}

	private void playTracks() {
		trackIterator = trackList.iterator();
		mediaPlayer = MediaPlayer.create(getApplicationContext(),
				trackIterator.next());
		mediaPlayer.setOnCompletionListener(this);
		mediaPlayer.start();
	}

	public void onCompletion(MediaPlayer player) {
		mediaPlayer.release();
		if (trackIterator.hasNext()) {
			mediaPlayer = MediaPlayer.create(getApplicationContext(),
					trackIterator.next());
			mediaPlayer.setOnCompletionListener(this);
			mediaPlayer.start();
		} else {
			Button startButton = (Button) findViewById(R.id.startButton);
			startButton.setText(R.string.start);
		}
	}

	private void addStartPhase() {
		trackList.add(activeVoice.getStart());
	}

	private void pause() {
		try {
			Thread.sleep(PAUSE);
		} catch (InterruptedException e) {
			Log.d(TAG, "Exception sleeping: " + e.getMessage());
		}
	}

	private void addMinions() {
		if (oberon && lancelot) {
			trackList.add(activeVoice.getMinionYesLancelotYesOberon());
		} else if (oberon && !lancelot) {
			trackList.add(activeVoice.getMinionNoLancelotYesOberon());
		} else if (!oberon && lancelot) {
			trackList.add(activeVoice.getMinionYesLancelotNoOberon());
		} else {
			trackList.add(activeVoice.getMinionNoLancelotNoOberon());
		}

		pause();

		trackList.add(activeVoice.getMinionReset());

		pause();
	}

	private void addMerlin() {
		if (!merlin) {
			return;
		}

		if (mordred) {
			trackList.add(activeVoice.getMerlinYesMordred());
		} else {
			trackList.add(activeVoice.getMerlinNoMordred());
		}

		pause();

		trackList.add(activeVoice.getMerlinReset());

		pause();
	}

	private void addPercival() {
		if (!percival) {
			return;
		}

		if (morganna) {
			trackList.add(activeVoice.getPercivalYesMorganna());
		} else {
			trackList.add(activeVoice.getPercivalNoMorganna());
		}

		pause();

		trackList.add(activeVoice.getPercivalReset());

		pause();
	}

	private void addLancelot() {
		if (!lancelot) {
			return;
		}

		trackList.add(activeVoice.getLancelot());

		pause();

		trackList.add(activeVoice.getLancelotReset());

		pause();
	}

	private void addGuinevere() {
		if (guinevere) {
			trackList.add(activeVoice.getGuinevere());
			pause();

			trackList.add(activeVoice.getGuinevereReset());
			pause();
		}
	}

	private void addFinal() {
		trackList.add(activeVoice.getFinalReset());
	}

}
