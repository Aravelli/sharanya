
package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileUtil 
{
	public static String getValueForKey(String key) throws Exception
	{
		
		Properties configProporties=new Properties();
		
		configProporties.load(new FileInputStream(new File("./PropertiesFile/Environment.properties")));
		
		return configProporties.getProperty(key);
		
	}
}



