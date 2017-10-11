
package CommonFuncLibrary;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.PropertyFileUtil;

public class FunctionLibrary 
{
	
	public static void openApplication(WebDriver driver) throws Exception
	{		
		driver.manage().window().maximize();
		
		driver.get(PropertyFileUtil.getValueForKey("URL"));
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
	}
	
	public static WebDriver startBrowser(WebDriver driver) throws Exception 
	{
		if(PropertyFileUtil.getValueForKey("Browser").equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(PropertyFileUtil.getValueForKey("Browser").equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "CommonJarFiles/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else
		{
			System.setProperty("webdriver.ie.driver","CommonJarFiles/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		
		return driver;
	}
	
	public static void closeBrowser(WebDriver driver)
	{
		driver.close();
	}
	
	public static void clickAction(WebDriver driver, String locatorType, String locatorValue)
	{
		if(locatorType.equalsIgnoreCase("id"))
		{
			driver.findElement(By.id(locatorValue)).click();
		}
		else
			if(locatorType.equalsIgnoreCase("xpath"))
			{
				driver.findElement(By.xpath(locatorValue)).click();
			}
			else
				if(locatorType.equalsIgnoreCase("name"))
				{
					driver.findElement(By.name(locatorValue)).click();
				}
	}
	
	
	public static void typeAction(WebDriver driver, String locatorType, String locatorValue, String data)
	{
		if(locatorType.equalsIgnoreCase("id"))
		{
			driver.findElement(By.id(locatorValue)).clear();
			driver.findElement(By.id(locatorValue)).sendKeys(data);
		}
		else
			if(locatorType.equalsIgnoreCase("xpath"))
			{
				
				driver.findElement(By.xpath(locatorValue)).clear();
				driver.findElement(By.xpath(locatorValue)).sendKeys(data);
			}
			else
				if(locatorType.equalsIgnoreCase("name"))
				{
					driver.findElement(By.name(locatorValue)).clear();
					driver.findElement(By.name(locatorValue)).sendKeys(data);
				}
	}
	
	
	public static void waitforelement(WebDriver driver,String locatorType, String locatorValue,String waitTime)
	{
		WebDriverWait wait=new WebDriverWait(driver, Integer.parseInt(waitTime));
		
		if (locatorType.equalsIgnoreCase("id"))
		{			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));			
		}
		else
			if (locatorType.equalsIgnoreCase("xpath")) 
			{				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
			}
			else
				if (locatorType.equalsIgnoreCase("name")) 
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
				}
		}
	
	
	public static String getRandomNumberFromDate()
	{
		
		Date date=new Date();
		
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY_MM_dd_ss");
		
		return sdf.format(date);
	}
	
	
	public static void pageScroll(WebDriver driver)
	{		
//		 Actions action = new Actions(driver);
//		 action.sendKeys(Keys.PAGE_DOWN);
		
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
	     jse.executeScript("window.scrollBy(0,250)", "");		
	}
	
	public static void mouseHoverAction(WebDriver driver, String locatorType, String locatorValue)
	{
		
		Actions act=new Actions(driver);
		
		if(locatorType.equalsIgnoreCase("id"))
		{
			act.moveToElement(driver.findElement(By.id(locatorValue))).build().perform();
			
		}
		else
			if(locatorType.equalsIgnoreCase("xpath"))
			{
				act.moveToElement(driver.findElement(By.xpath(locatorValue))).build().perform();
				
			}
			else
				if(locatorType.equalsIgnoreCase("name"))
				{
					act.moveToElement(driver.findElement(By.name(locatorValue))).build().perform();
				}
	}
	
}