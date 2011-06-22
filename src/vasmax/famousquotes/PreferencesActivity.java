/**
 * 
 */
package vasmax.famousquotes;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * @author Vasiliy
 * 
 * Class represent PreferencesActivity and need to provide user settings.
 *
 */
public class PreferencesActivity extends PreferenceActivity {
	@Override
	public void onCreate( Bundle savedInstanceState ) {
		super.onCreate( savedInstanceState );
		addPreferencesFromResource( R.xml.settings );
	}	
}
