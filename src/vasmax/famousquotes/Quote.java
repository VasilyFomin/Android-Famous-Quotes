package vasmax.famousquotes;

import java.io.IOException;
import java.io.StringReader;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.util.Xml;


public class Quote {
	
	public String Text;
	
	public String Author;
	
	public String Sender;
	
	public String SenderLink;
	
	public Quote () { }
	
	public Quote(String text, String author, String sender, String senderLink) 
	{
		Text = text;
		Author = author;
		Sender = sender;
		SenderLink = senderLink;
	}
	
	public static Quote Parse(String forsmaticResponseString) throws XmlPullParserException, IOException
	{
		Quote quote = new Quote();
		
		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		XmlPullParser xmlParser = factory.newPullParser();
		
		xmlParser.setInput(new StringReader(forsmaticResponseString));
		
		int eventType = xmlParser.getEventType();
		
		while (eventType != XmlPullParser.END_DOCUMENT)
		{
			eventType = xmlParser.next();
			//TODO: Parse nodes
		}
		
		return quote;
	}

}
