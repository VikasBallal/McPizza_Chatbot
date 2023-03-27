package base;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverUtil 
{
	private WebDriver driver;
	
	public ChromeOptions choptions;
	public FirefoxOptions ffoptions;
	
	public WebDriver getDriver() 
	{
		return driver;
	}
	
	public void setDriver(String browserName) 
	{
		String path="";
		switch(browserName.toLowerCase())
		{
			case "chrome" : 
				choptions = new ChromeOptions();
				choptions.addArguments("start-maximized");
				choptions.addArguments("--no-sandbox"); 
				choptions.addArguments("--remote-allow-origins=*");
				path = System.getProperty("user.dir");
				System.setProperty("webdriver.firefox.driver", path+"/drivers/chromedriver.exe");
				driver = new ChromeDriver(choptions);
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
				break;
				
			case "firefox":
				ffoptions = new FirefoxOptions();
				ffoptions.addArguments("start-maximized"); 
				ffoptions.addArguments("--no-sandbox"); 
				ffoptions.addArguments("--remote-allow-origins=*");
				path = System.getProperty("user.dir");
				System.setProperty("webdriver.firefox.driver", path+"/drivers/geckodriver.exe");
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
				break;
				
			default:
				choptions = new ChromeOptions();
				choptions.addArguments("start-maximized"); 
				choptions.addArguments("enable-automation"); 
				choptions.addArguments("--no-sandbox"); 
				choptions.addArguments("--remote-allow-origins=*");
				path = System.getProperty("user.dir");
				System.setProperty("webdriver.firefox.driver", path+"/drivers/chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
				break;
		}
	}

}
