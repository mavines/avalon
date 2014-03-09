/**
 * 
 */
package badger.avalon;

import android.os.Bundle;
import android.preference.PreferenceActivity;



/**
 * @author Mason
 *
 */
public class SettingsActivity extends PreferenceActivity  {
	public final static String VOICE_PREFERENCE = "pref_voice";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.voice_preferences);        
    }
}
