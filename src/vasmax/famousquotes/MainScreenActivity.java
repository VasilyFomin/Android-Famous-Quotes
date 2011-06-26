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
import android.widget.TextView;

public class MainScreenActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        /*** Debug proposes. ***/
        TextView quoteView = (TextView)findViewById( R.id.quote_view );
        quoteView.setText( "This is Quote text and it in English, because we have problems with cyrillic when sending SMS." );
        
        TextView authorView = (TextView)findViewById( R.id.author_view );
        authorView.setText( "Author" );        
        /************************/
        
        // Setup click listeners for all buttons
        ImageButton settingsButton = (ImageButton)findViewById( R.id.settings_button );
        settingsButton.setOnClickListener( this );
        
        ImageButton shareButton = (ImageButton) findViewById( R.id.share_button );
        shareButton.setOnClickListener( this );
        
        ImageButton bookmarkButton = (ImageButton)findViewById( R.id.bookmark_button );
        bookmarkButton.setOnClickListener( this );
        
        ImageButton refreshButton = (ImageButton)findViewById( R.id.wiki_button );
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
				
		case R.id.wiki_button:
			// TODO: Implement refresh_button event handler.	
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
		Log.d( "ShareWithFunction", "clicked on: " + serviceId );
		
		// Get Quote Text
		String quoteText = (String)( ( (TextView)findViewById( R.id.quote_view ) ).getText() );
		Log.i( "QUOTE_TEXT", quoteText );
		
		// Get Quote Author
		String quoteAuthor = (String)( ( (TextView)findViewById( R.id.author_view ) ).getText() );
		
		// Make String to send share service.
		String strToSend;
		if ( quoteAuthor != null ) {
			Log.i( "QUOTE_AUTHOR", quoteAuthor );		
			strToSend = quoteText + quoteAuthor;
		} else {
			strToSend = quoteText;
		}
		
		switch ( serviceId ) {		
		/* SMS Action. */
		// TODO: Fix problems with Cyrillic letters.
		case 3:			

			// Create SMS sender Intent
			final Intent smsSendIntent = new Intent(Intent.ACTION_VIEW);
			smsSendIntent.setType("vnd.android-dir/mms-sms");
			
			// Put body text.
			smsSendIntent.putExtra("sms_body", strToSend );
						
			// Start SMS send Activity.
			startActivity( smsSendIntent );
			
			break;
			
		/* Email Action. */
		// TODO: Check Email on Device.
		case 4:
			// Create Email send Intent.
			final Intent emailSendIntent = new Intent(android.content.Intent.ACTION_SEND);
			emailSendIntent.setType("plain/text");
			//emailSendIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"vasili.fomin@gmail.com"});						
			emailSendIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "I have founded Great Quote!" );
			emailSendIntent.putExtra(android.content.Intent.EXTRA_TEXT, strToSend);
			startActivity( emailSendIntent );
			break;

		default:
			// TODO: Make default handler.
			break;
		}
	}
}
