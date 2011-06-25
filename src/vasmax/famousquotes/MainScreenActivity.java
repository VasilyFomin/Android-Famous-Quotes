package vasmax.famousquotes;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class MainScreenActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // Setup click listeners for all buttons
        ImageButton settingsButton = (ImageButton)findViewById( R.id.settings_button );
        settingsButton.setOnClickListener( this );
        
        Button aboutButton = (Button)findViewById( R.id.about_button );
        aboutButton.setOnClickListener( this );
        
        ImageButton shareButton = (ImageButton) findViewById( R.id.share_button );
        shareButton.setOnClickListener( this );
        
        Button bookmarkButton = (Button)findViewById( R.id.bookmark_button );
        bookmarkButton.setOnClickListener( this );
        
        Button refreshButton = (Button)findViewById( R.id.refresh_button );
        refreshButton.setOnClickListener( this );              
    }

    /* Called when buttons clicked. */
	@Override
	public void onClick(View v) {
		switch ( v.getId() ) {
		case R.id.bookmark_button:
			// TODO: Implement bookmark_button event handler.				
			break;
		
		case R.id.settings_button:
			Intent settingsScreenIntent = new Intent( this, PreferencesActivity.class );
			startActivity( settingsScreenIntent );
			break;
			
		case R.id.share_button:
			openShareWithDialog();			
			break;
				
		case R.id.refresh_button:
			// TODO: Implement refresh_button event handler.	
			break;
		case R.id.about_button:
			Intent aboutDialogIntent = new Intent( this, AboutDialogActivity.class );
			startActivity( aboutDialogIntent );
			break;
	
		default:
			// TODO: Implement default case.	
			break;
		}
	}
	
	/* Called when user clicks Share button. 
	 * Creates alert dialog and populate it with items from resources. 
	 */
	private void openShareWithDialog() {
		new AlertDialog.Builder( this )
		.setTitle( R.string.share_with_dialog_title )
		.setItems( R.array.share_services, new DialogInterface.OnClickListener() {			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				shareWith( which );				
			}
		})
		.show();
	}
	
	/* Called from Share menu.
	 * @param serviceId The number in list of clicked item. From 0 to last.
	 */
	private void shareWith( final int serviceId ) {
		// TODO: Implement ShareFunction functionality.
		Log.d( "ShareWithFunction", "clicked on: " + serviceId );
	}
}
