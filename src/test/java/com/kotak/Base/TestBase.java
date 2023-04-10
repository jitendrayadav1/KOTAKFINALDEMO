package com.kotak.Base;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.kotak.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 *  @author Reshma Chachar
 * @Usage: This class is used to initiate the WebDriver Driver,properties file.
 *         All static variables are declared here and inherited by other
 *         classes.
 *
 */
public class TestBase {

	ReadConfig config=new ReadConfig();
	public String baseUrl=config.getApplicationUrl();
	public static WebDriver driver;
	public WebDriverWait wait;
	public Actions act;


	@Parameters("browser") 
	@BeforeClass
	public void setUp(@Optional("chrome") String browsr)
	{
		switch(browsr)
		{
		case "chrome": 
			  ChromeOptions option = new ChromeOptions();
	            option.addArguments("--remote-allow-origins=*");
	            WebDriverManager.chromedriver().setup();
	            driver = new ChromeDriver(option);
			
//			WebDriverManager.chromedriver().setup();
//			ChromeOptions options=new ChromeOptions();
//			driver=new ChromeDriver(options);

			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions fOptions = new FirefoxOptions();
			driver=new FirefoxDriver(fOptions);

			break;
		case "edge":
			EdgeOptions eoption = new EdgeOptions();
            eoption.addArguments("--remote-allow-origins=*");
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver(eoption);
		
//			WebDriverManager.edgedriver().setup();
//		    EdgeOptions eOptions=new EdgeOptions();
//			driver=new EdgeDriver(eOptions);
			break;
		default :
			System.err.println("Invalid Browser Name : ");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver,Duration.ofMillis(3000));
		act=new Actions(driver);

	}
	//to find broken links 
	public WebDriver Brokenlinks() throws InterruptedException, IOException
	{				 
		try 
		{
			List<WebElement>links=driver.findElements(By.tagName("a"));
			System.out.println(links.size());

			for(WebElement link:links)
			{
				String url = link.getAttribute("href");
				URL Link=new URL(url);
				HttpURLConnection httpcon=(HttpURLConnection) Link.openConnection();
				httpcon.connect();
				int response = httpcon.getResponseCode();
				if(response>=400)
				{
					System.out.println(url+" "+"link is broken");
				}
			}
			System.out.println("All links are valid link");

		} catch (Exception e) 
		{
			System.out.println("The URL is not valid.");
			System.out.println(e.getMessage());
		}
		return driver;
	}
	
//  //@AfterClass
//		public void tearDown()
//	{
//		driver.quit();
//	}
//	 
}
