package vasmax.famousquotes;

import java.io.IOException;
import java.io.StringReader;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.util.Xml;


public class Quote 
{	
	public String Text;
	
	public String Author;
	
	public Quote () { }
	
	public Quote(String text, String author) 
	{
		Text = text;
		Author = author;
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
			if (eventType == XmlPullParser.START_TAG)
			{
				String nodeName = xmlParser.getName();
				if (nodeName.equals("quoteText")) 
				{ 
					xmlParser.next();
					quote.Text = xmlParser.getText();
				}
				else if (nodeName.equals("quoteAuthor"))
				{
					xmlParser.next();
					quote.Author = xmlParser.getText();
				}
			}			
			eventType = xmlParser.next();			
		}
		
		return quote;
	}	
}
