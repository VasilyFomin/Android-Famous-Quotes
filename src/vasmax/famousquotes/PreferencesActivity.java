/**
 * 
 */
package vasmax.famousquotes;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

/**
 * @author Vasiliy Fomin
 * 
 * Class represent PreferencesActivity and used for providing user settings.
 *
 */
public class PreferencesActivity extends PreferenceActivity implements OnPreferenceClickListener{
	@Override
	public void onCreate( Bundle savedInstanceState ) {
		super.onCreate( savedInstanceState );
		addPreferencesFromResource( R.xml.settings );
		
		/* Get preferences objects and setup onClick event handlers. */
		Preference twitterSettingsPreference = findPreference( "twitter_account_settings" );
		twitterSettingsPreference.setOnPreferenceClickListener(this);		
		
		Preference facebookSettingsPreference = findPreference( "facebook_account_settings" );
		facebookSettingsPreference.setOnPreferenceClickListener( new FacebookAccountInstaller() );		
		
		Preference vkontakteSettingsPreference = findPreference( "vkontakte_account_settings" );
		vkontakteSettingsPreference.setOnPreferenceClickListener(this);		
		
	}	

	@Override
	public boolean onPreferenceClick(Preference preference) {
		Log.i("Pref type", preference.getKey() );			
		
		// This example shows how to add a custom layout to an AlertDialog
        LayoutInflater factory = LayoutInflater.from(this);
        final View textEntryView = factory.inflate(R.layout.login_form_layout, null);
        AlertDialog dialog =  new AlertDialog.Builder(PreferencesActivity.this)
            .setIcon(R.drawable.alert_dialog_icon)
            .setTitle(R.string.login_dialog_title)
            .setView(textEntryView)
            .setPositiveButton( "OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {

                    /* User clicked OK so do some stuff */
                	Log.i("DIALOG", "Clicked OK");
                }
            })
            .setNegativeButton( "Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {

                    /* User clicked cancel so do some stuff */
                	Log.i("DIALOG", "Clicked Cancel");               	
                	
                	CheckBoxPreference twitterPref = (CheckBoxPreference) findPreference( "twitter_account_settings");
                	twitterPref.setChecked( false );
                }
            })
            .create();
        dialog.show();
		
		
		//return true;
		return false;
	}		
	
}

class FacebookAccountInstaller implements OnPreferenceClickListener {

	@Override
	public boolean onPreferenceClick(Preference preference) {
		Log.i( "FB", "Facebook button clicked" );
		
		
		
		return false;
	}	
}
