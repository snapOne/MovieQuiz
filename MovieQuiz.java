import java.io.*;
import java.util.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class MovieQuiz
{
	private String question 	= new String();
	private String answer		= new String();
	private List<String> options 	= new ArrayList<String>();
	
	
	public LinkedList<String> loadData( String fileName ) throws Exception
	{
		DocumentBuilderFactory factory 	= DocumentBuilderFactory.newInstance();
		DocumentBuilder builder 		= factory.newDocumentBuilder();
		
		FileInputStream fis = new FileInputStream( fileName );
		InputSource is		= new InputSource( fis );
		Document doc 		= builder.parse(is);
		
		Element element = doc.getDocumentElement();
		
		NodeList nodes = element.getChildNodes();
		
		LinkedList<String> questionAndAnswers = new LinkedList<String>();
				
		for ( int i = 0; i < nodes.getLength(); i++ )
		{
			Node node = nodes.item(i);
			MovieQuiz questionsAnswersOptions = new MovieQuiz();
			
			if (node.getNodeType() == Node.ELEMENT_NODE )
			{
				if ( nodes.item(i).getNodeName() == "question")
					MovieQuiz.this.question = nodes.item(i).getTextContent();
				else if ( nodes.item(i).getNodeName() == "answer")
					MovieQuiz.this.answer = nodes.item(i).getTextContent();
				else
					MovieQuiz.this.options.add( nodes.item(i).getTextContent() );
				
				questionAndAnswers.add( nodes.item(i).getNodeName() );// nodes.item(i).getTextContent() );
			}
		}
		
	
		return questionAndAnswers;
	}
}
