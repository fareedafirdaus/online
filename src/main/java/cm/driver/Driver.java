package cm.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
	
	
	public static WebDriver getDriver(String browser)
	{
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\\\\\\\NexGenTesting\\\\\\\\Driver\\\\\\\\chromedriver_win32\\\\\\\\chromedriver.exe");
			return new ChromeDriver();
		}
		else
		{
		return null;
		
		}
		
	}

}
