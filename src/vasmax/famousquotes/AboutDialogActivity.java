/**
 * 
 */
package vasmax.famousquotes;

import android.app.Activity;
import android.os.Bundle;

/**
 * @author Vasiliy * 
 * 
 * This Activity implements About dialog as a Activity with theme.
 *
 */
public class AboutDialogActivity extends Activity {
	@Override
	public void onCreate( Bundle savedInstanceState ) {
		super.onCreate( savedInstanceState );
		setContentView( R.layout.about_dialog_activity );
	}
}
