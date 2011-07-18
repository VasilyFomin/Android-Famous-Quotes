/**
 * 
 */
package vasmax.famousquotes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

/**
 * @author Vasiliy
 * Class represent Quote downloader.
 */
public class QuoteDownloader {
	static String m_ApiUrl;
	
	public QuoteDownloader(final String apiUrl) {
		m_ApiUrl = apiUrl;
	}
	
	public void SetApiUrl( final String apiUrl ) {
		m_ApiUrl = apiUrl;
	}
	
	// Function download and setup one quote per one request.
	public void Download( TextView quoteTextView, TextView authorTextView ) {
		QuoteDownloadertask downloaderTask = new QuoteDownloadertask( quoteTextView, authorTextView );
		downloaderTask.execute( m_ApiUrl );
	}
	
	// Method download answer string from the server, parse it and return Quote object.
	private static Quote downloadQuote( String apiUrl ) throws XmlPullParserException, IOException {
		BufferedReader reader = null;
		StringBuffer buffer = new StringBuffer("");
		HttpClient httpClient = new DefaultHttpClient();
		
		try {
			HttpGet request = new HttpGet();
			request.setURI(new URI( apiUrl ));
			
			HttpResponse response = null;
			response = httpClient.execute(request);
			reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String temp = "";
			while ((temp = reader.readLine()) != null) {
				buffer.append(temp);
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IllegalStateException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} finally {
			reader.close();
		}
 		
		return Quote.Parse( buffer.toString() );
	}
	
	// Class download and setup quote text and author in separated thread.
	private class QuoteDownloadertask extends AsyncTask<String, Void, Quote> {
		private final WeakReference< TextView > quoteTextViewReference;
		private final WeakReference< TextView > authorTextViewReference;
		
		public QuoteDownloadertask( final TextView quoteTextView, final TextView authorTextView ) {
			quoteTextViewReference = new WeakReference<TextView>(quoteTextView);
			authorTextViewReference = new WeakReference<TextView>(authorTextView);			
		}
		
		@Override
		// Method perform download quote in the separated thread.
		protected Quote doInBackground(String... params) {
			// Params comes from excute method.
			// params[0] is the apiUrl.
			Quote quote = null;
			try {
				quote = downloadQuote( params[0] );
			} catch (XmlPullParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return quote;
		}
		
		@Override
		// Method fill Text and Author textviews with quote body.
		protected void onPostExecute( Quote quote ) {
			if( isCancelled() ) {
				quote = null;
			}			
			if( quote.Author != null) {
				if( ( quoteTextViewReference != null ) && ( authorTextViewReference != null ) ) {
					TextView quoteTextView = quoteTextViewReference.get();
					TextView authorTextView = authorTextViewReference.get();
					
					if( ( quoteTextView != null ) && ( authorTextView != null ) ) {
						// OK, set the quote and author texts.
						quoteTextView.setText( quote.Text );
						authorTextView.setText( quote.Author );
					}
				}
			}			
		}		
	}	
}
