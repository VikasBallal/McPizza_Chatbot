package stepdefinitions;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import base.WebDriverUtil;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	private WebDriver _driver;
	
	private WebDriverUtil _webdriverUtil;
	
	public Hooks(WebDriverUtil webdriverUtil) 
	{
		this._webdriverUtil = webdriverUtil;
	}
	
	@Before("@OrderNonVegPizza")
	public void BeforeScenarion(Scenario scenario) 
	{
		_webdriverUtil.setDriver("chrome");	
	}
	
	@AfterStep
	public void AfterEveryStep(Scenario scenario) 
	{
		_driver = _webdriverUtil.getDriver();
		if(scenario.isFailed()) 
		{
			byte[] screenshot = ((TakesScreenshot)_driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "");
		}
	}
	
	@After
	public void AfterScenarion() 
	{
		_webdriverUtil.getDriver().close();
	}
}
