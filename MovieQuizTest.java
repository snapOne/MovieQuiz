import static org.junit.Assert.*;
import java.util.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MovieQuizTest
{
	
	private MovieQuiz m;

	@Before
	public void setUp() throws Exception
	{
		m = new MovieQuiz();
	}
	
	@Test
	public void canLoadData() throws Exception
	{
		String movieFileName = "MovieData.xml";
		LinkedList<String> questionAndAnwsers = m.loadData( movieFileName );
		
		assertFalse( "Array is empty", questionAndAnwsers.isEmpty() );
		System.out.println(questionAndAnwsers);
	}
	
	@Test
	public void isDataMovieQuizClass() throws Exception
	{
		String movieFileName = "MovieData.xml";
		LinkedList<String> questionsAndAnwsers = m.loadData( movieFileName );
		Object testClassAtIndex0 = questionsAndAnwsers.get(0);
		Object testClass = testClassAtIndex0.getClass();
		System.out.println( "Class is" +testClass );
		
		assertEquals("MovieQuiz", testClass);
	}
	

	
}
