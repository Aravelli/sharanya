
package Driver;

import org.testng.annotations.Test;

public class AppTest
{	
	
	@Test
	public void kickStart()
	{		
		TestConfig t = new TestConfig();
		
		try 
		{
			t.startTest();
		} 
		catch (Exception e)
		{			
			e.printStackTrace();
		}
	}	
}