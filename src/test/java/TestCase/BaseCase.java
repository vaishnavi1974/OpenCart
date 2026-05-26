package TestCase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseCase {
	WebDriver driver;
	Properties p;
	@BeforeClass
	@Parameters({"browser","os"})
	public void setup_driver(String br,String os) throws FileNotFoundException, IOException
	{
		p = new Properties();
		FileReader f = new FileReader(".//src/test/resources/source.txt");
		p.load(f);
		if(p.getProperty("env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities cp=new DesiredCapabilities();
			if(os.equalsIgnoreCase("windows"))
			{
				cp.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("linux"))
			{
				cp.setPlatform(Platform.LINUX);
			}
			else
			{
				System.out.println("invalid os");
				return;
			}
			switch(br.toLowerCase())
			{
			case "chrome":cp.setBrowserName("chrome");break;
			case "edge":cp.setBrowserName("MicrosoftEdge");break;
			case "firefox":cp.setBrowserName("firefox");break;
			default : System.out.println("no matching broswer");return;
			}
			
			try {
				driver=new RemoteWebDriver(new URL("http://192.168.29.4:4444/wd/hub"),cp);
			} catch (Exception e) {
				System.out.println("Failed to connect to Selenium Grid: " + e.getMessage());
				e.printStackTrace();
			}
		}
		if(p.getProperty("env").equalsIgnoreCase("local"))
		{
			switch(br)
			{
			case "chrome":driver=new ChromeDriver();break;
			case "edge":driver=new EdgeDriver();break;
			case "firefox":driver=new FirefoxDriver();break;
			case "default":System.out.println("invalid broswer");return;
			}
		}
		
		if(driver != null) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(p.getProperty("appurl"));
			driver.manage().window().maximize();
		} else {
			throw new RuntimeException("WebDriver initialization failed!");
		}
	}
	@AfterClass
	public void driver_teardown()
	{
		driver.quit();
	}
	
	public String randomstring()
	{
		@SuppressWarnings("deprecation")
		String generateString=RandomStringUtils.randomAlphabetic(10);
		return generateString;
	}
	public String randomnumber()
	{
		@SuppressWarnings("deprecation")
		String generateNumber=RandomStringUtils.randomNumeric(10);
		return generateNumber;
	}
	
	public String alphanumericstring()
	{
		String generateAlphanumeric=randomstring()+randomnumber();
		return generateAlphanumeric;
	}

}
