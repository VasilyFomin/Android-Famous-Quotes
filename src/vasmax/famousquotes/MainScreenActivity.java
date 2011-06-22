package vasmax.famousquotes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainScreenActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // Setup click listeners for all buttons
        Button settingsButton = (Button)findViewById( R.id.settings_button );
        settingsButton.setOnClickListener( this );
        
        Button aboutButton = (Button)findViewById( R.id.about_button );
        aboutButton.setOnClickListener( this );
        
        Button shareButton = (Button) findViewById( R.id.share_button );
        shareButton.setOnClickListener( this );
        
        Button bookmarkButton = (Button)findViewById( R.id.bookmark_button );
        bookmarkButton.setOnClickListener( this );
        
        Button refreshButton = (Button)findViewById( R.id.refresh_button );
        refreshButton.setOnClickListener( this );       
        
	    /* Setup click listeners for all buttons. */
	    Button settingsButton = (Button)findViewById( R.id.settings_button );
	    settingsButton.setOnClickListener( this );
	    
	    Button aboutButton = (Button)findViewById( R.id.about_button );
	    aboutButton.setOnClickListener( this );
	    
	    Button shareButton = (Button) findViewById( R.id.share_button );
	    shareButton.setOnClickListener( this );
	    
	    Button bookmarkButton = (Button)findViewById( R.id.bookmark_button );
	    bookmarkButton.setOnClickListener( this );
	    
	    Button refreshButton = (Button)findViewById( R.id.refresh_button );
	    refreshButton.setOnClickListener( this ); 
    }

	@Override
	public void onClick(View v) {
		switch ( v.getId() ) {
		case R.id.bookmark_button:
			// TODO: Implement bookmark_button event handler.				
			break;
		
		case R.id.settings_button:
			// TODO: Implement settings_button event handler.				
			break;
			
		case R.id.share_button:
			// TODO: Implement share_button event handler.			
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
}

   
	@Override
	public void onClick(View v) {
		switch ( v.getId() ) {
		case R.id.bookmark_button:
			// TODO: Implement bookmark_button event handler.				
			break;
		
		case R.id.settings_button:
			Intent settingsScreenIntent = new Intent( this, SettingsScreenActivity.class );
			startActivity( settingsScreenIntent );
			break;
			
		case R.id.share_button:
			// TODO: Implement share_button event handler.			
			break;
				
		case R.id.refresh_button:
			// TODO: Implement refresh_button event handler.	
			break;
		case R.id.about_button:
			// TODO: Implement about_button event handler.	
			break;

		default:
			// TODO: Implement default case.	
			break;
		}
	}
		
	}
