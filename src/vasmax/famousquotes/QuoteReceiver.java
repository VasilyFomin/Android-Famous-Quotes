package vasmax.famousquotes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.InvalidParameterException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;

public class QuoteReceiver 
{	
	private HttpClient _httpClient;
	
	protected HttpClient getHttpClient()
	{
		return _httpClient;
	}
	
	protected void setHttpClient(HttpClient httpClient)
	{
		_httpClient = httpClient;
	}
	
	
	private Thread _workerThread;
	
	protected Thread getWorkerThread()
	{
		return _workerThread;
	}
	
	protected void setWorkerThread(Thread workerThread)
	{
		_workerThread = workerThread;
	}
	
	
	private int _requestInterval;
	
	public int getRequestInterval()
	{
		return _requestInterval;
	}
	
	public void setRequestInterval(int interval) throws InvalidParameterException
	{
		if (interval <= 0)
		{
			throw new InvalidParameterException();
		}
		_requestInterval = interval;
	}
	
	
	public QuoteReceiver()
	{
		setHttpClient(new DefaultHttpClient());
	}
	
	public String ExecuteWebRequest() throws Exception
	{
		BufferedReader reader = null;
		StringBuffer buffer = new StringBuffer("");
		
		try
		{
			HttpGet request = new HttpGet();
			request.setURI(new URI("http://api.forismatic.com/api/1.0/"));
			
			BasicHttpParams params = new BasicHttpParams();
			params.setParameter("method", "getQuote");
			params.setParameter("format", "xml");
			params.setParameter("lang", "ru");		//TODO: make it variable
			
			request.setParams(params);
			
			HttpResponse response = getHttpClient().execute(request);
			
			response.getEntity().getContent();
			reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			
			
			String temp = "";
			
			while ((temp = reader.readLine()) != null)
			{
				buffer.append(temp);
			}
		}
		finally
		{
			reader.close();
		}
		
		return buffer.toString();
		
	}
	
	
}
