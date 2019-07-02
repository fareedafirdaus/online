package demo;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.List;
	import java.io.File;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import java.util.concurrent.TimeUnit;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.By;
	import org.openqa.selenium.OutputType;

	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;
	import org.testng.ITestResult;
	import org.testng.SkipException;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.Status;
	import com.aventstack.extentreports.markuputils.ExtentColor;
	import com.aventstack.extentreports.markuputils.MarkupHelper;
	import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
	import com.aventstack.extentreports.reporter.configuration.Theme;

import cm.driver.Driver;
import junit.framework.Assert;


	public class NewTest{
		int flag;
		WebDriver driver;
		ExtentHtmlReporter htmlreporter;
		ExtentReports reports;
		ExtentTest logger;
		String expected="jdkj";
		@BeforeClass
		public void beforeclass()
		{
			//System.setProperty("webdriver.chrome.driver","C:\\\\\\\\NexGenTesting\\\\\\\\Driver\\\\\\\\chromedriver_win32\\\\\\\\chromedriver.exe");
			//driver=new ChromeDriver();
			driver=Driver.getDriver("chrome");
			driver.navigate().to("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
			driver.manage().window().maximize();
			
			  
		}
		
		
		
		@BeforeTest
		public void startReportBeforeTest()
		{
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss-ms");
			String path=System.getProperty("user.dir")+"/extent-reports/"+sdf.format(new Date())+".html";
			htmlreporter=new ExtentHtmlReporter(path);
			reports=new ExtentReports();
			reports.attachReporter(htmlreporter);
			htmlreporter.config().setReportName("Test Me App Report");
			htmlreporter.config().setTheme(Theme.DARK);


			
		}
		
		
		
		
	  @Test
	  public void testLogin() 
	  {
		  driver.findElement(By.linkText("SignIn")).click();
		    //logger=reports.createTest("passTest");
			//logger.log(Status.INFO,"pass test started");
			
			//logger=reports.createTest("skipTest");
			//logger.log(Status.INFO,"skip test started");
			//throw new SkipException("SKIP");

			driver.findElement(By.name("userName")).sendKeys("Lalitha");
			logger=reports.createTest("failTest");
			logger.log(Status.INFO,"fail test started");
			driver.findElement(By.name("password")).sendKeys("Password23");
			driver.findElement(By.name("Login")).click();
			
			Assert.assertEquals(expected,driver.getTitle());

		  
		  
	  }
	  @Test(priority=1)
	  public void testRegistration() {
		  
		  
		  
		  logger=reports.createTest("passTest");
		  logger.log(Status.INFO,"pass test started");
		  
		  
		  
		  driver.findElement(By.xpath("/html/body/header/div/b/a")).click();
		  driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul/li[2]/a")).click();
		
		  
		  
		  
		  driver.findElement(By.name("userName")).sendKeys("udaya2788948");
		  driver.findElement(By.name("firstName")).sendKeys("Testing");
		  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		  String cmp=driver.findElement(By.xpath("//*[@id=\"err\"]")).getText();
		  if(cmp.equals("Available")) 
		 {
			  driver.findElement(By.name("lastName")).sendKeys("Batch");
			  driver.findElement(By.name("password")).sendKeys("Password123");
			  driver.findElement(By.name("confirmPassword")).sendKeys("Password123");
			  driver.findElement(By.xpath("//*[@id=\"gender\"]")).click();
			  driver.findElement(By.xpath("//*[@id=\"emailAddress\"]")).sendKeys("Team4@gmail.com");
			  driver.findElement(By.xpath("//*[@id=\"mobileNumber\"]")).sendKeys("9047586926");
			  driver.findElement(By.xpath("//*[@id=\"dob\"]")).sendKeys("15/10/1997");
			  driver.findElement(By.xpath("//*[@id=\"address\"]")).sendKeys("Chennai");
			  driver.findElement(By.xpath("//*[@id=\"securityQuestion\"]")).click();
			  WebElement category=driver.findElement(By.id("securityQuestion"));
			  Select s=new Select(category);
			  java.util.List<WebElement> values=s.getOptions();
			   for(WebElement e:values)
			   {
			    String  option = e.getText();
			    if (option.equals("What is your favour color?"))
			    {
			    s.selectByVisibleText(option);
			    flag = 1;
			    break;
			    }
			   } 
			   driver.findElement(By.xpath("//*[@id=\"answer\"]")).sendKeys("yellow");
		 }
		  else {
			  driver.findElement(By.name("userName")).clear();
			  driver.findElement(By.name("userName")).sendKeys("udaya1");
		  driver.findElement(By.name("firstName")).sendKeys("Testing");
		  driver.findElement(By.name("lastName")).sendKeys("Batch");
		  driver.findElement(By.name("password")).sendKeys("Password123");
		  driver.findElement(By.name("confirmPassword")).sendKeys("Password123");
		  driver.findElement(By.xpath("//*[@id=\"gender\"]")).click();
		  driver.findElement(By.xpath("//*[@id=\"emailAddress\"]")).sendKeys("Team4@gmail.com");
		  driver.findElement(By.xpath("//*[@id=\"mobileNumber\"]")).sendKeys("9047586926");
		  driver.findElement(By.xpath("//*[@id=\"dob\"]")).sendKeys("15/10/1997");
		  driver.findElement(By.xpath("//*[@id=\"address\"]")).sendKeys("Chennai");
		  driver.findElement(By.xpath("//*[@id=\"securityQuestion\"]")).click();
		  WebElement category=driver.findElement(By.id("securityQuestion"));
		  Select s=new Select(category);
		  java.util.List<WebElement> values=s.getOptions();
		   for(WebElement e:values)
		   {
		    String  option = e.getText();
		    if (option.equals("What is your favour color?"))
		    {
		    s.selectByVisibleText(option);
		    flag = 1;
		    break;
		    }
		   } 
		   driver.findElement(By.xpath("//*[@id=\"answer\"]")).sendKeys("yellow");
		   
	      
	  }
		 driver.findElement(By.xpath("/html/body/main/div/div/form/fieldset/div/div[13]/div/input[1]")).submit();
		}	

	  @Test(priority=2)
	  public void testLoginn() {  
		  
		  logger=reports.createTest("passTest");
		  logger.log(Status.INFO,"pass test started");
		  
		  driver.findElement(By.xpath("//*[@id=\"userName\"]")).clear();
		  driver.findElement(By.xpath("//*[@id=\"password\"]")).clear();
	    driver.findElement(By.xpath("//*[@id=\"userName\"]")).sendKeys("Lalitha");
	    driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Password123");
	    driver.findElement(By.name("Login")).click();
	  }
	  
	  
	  @Test(priority=3)
	  public void testCart() 
	  {
		  
		  logger=reports.createTest("passTest");
		  logger.log(Status.INFO,"pass test started");
		  driver.findElement(By.xpath("//*[@id=\"myInput\"]")).sendKeys("Hand bag"); //txt
		  driver.findElement(By.xpath("/html/body/div[1]/form/input")).click(); //findbutn
		  driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[1]/div/div/div[2]/center/a")).click(); //addtocart
		  driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")).click();//cartbtn
		  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		  driver.findElement(By.xpath("//*[@id=\"cart\"]/tfoot/tr[2]/td[5]/a")).click(); // checkoutbtn
	  }
	  @Test(priority=4)
	  public void testPayment() 
	  {
		  
		  logger=reports.createTest("passTest");
		  logger.log(Status.INFO,"pass test started");
	    //driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")).click();//cart1
	    //driver.findElement(By.xpath("//*[@id=\"cart\"]/tfoot/tr[2]/td[5]/a")).click();//checkout
	    driver.findElement(By.xpath("/html/body/b/div/div/div[1]/div/div[2]/div[3]/div/form[2]/input")).click();//proceedtopay
	    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//*[@id=\"btn\"]")).click();
	    driver.findElement(By.xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/input[1]")).sendKeys("Team4@gmail.com");
	    driver.findElement(By.xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/input[2]")).sendKeys("Password123");
	    driver.findElement(By.xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/input[2]")).click();
	    driver.close();
	  }
	 
	  
	  @AfterMethod
	  public void getResultAfterMethod(ITestResult result)
	  {
		
				if(result.getStatus()==ITestResult.FAILURE)
				{
					logger.log(Status.FAIL,"THE TEST IS FAILED");
					
					TakesScreenshot ts=(TakesScreenshot) driver;
					File srcFile=ts.getScreenshotAs(OutputType.FILE);
					String imagepath=System.getProperty("user.dir")+"/extent-reports/images/"+
									result.getMethod().getMethodName()+".png";
					
					try {
						FileUtils.copyFile(srcFile, new File(imagepath));
						logger.log(Status.INFO,result.getThrowable());
						logger.addScreenCaptureFromPath(imagepath,"fail test image");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(result.getStatus()==ITestResult.SUCCESS)
				{
					logger.log(Status.PASS,"THE TEST IS PASSED");
					logger.log(Status.INFO,MarkupHelper.createLabel("THE TEST IS PASSED",ExtentColor.GREEN));
				}
				else if(result.getStatus()==ITestResult.SKIP)
				{
					logger.log(Status.SKIP,"THE TEST IS SKIPPED");
				}
	
	  }
	 
	  @AfterTest
	  public void endReportafterTest()
	  {
		  reports.flush();
		  
		  
	  }
	  
}
