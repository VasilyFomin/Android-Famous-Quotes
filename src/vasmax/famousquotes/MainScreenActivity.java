package vasmax.famousquotes;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainScreenActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log.i(ACTIVITY_SERVICE, "MainScreenAcitivity Created" );
    }
}
