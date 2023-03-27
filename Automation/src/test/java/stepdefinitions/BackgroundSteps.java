package stepdefinitions;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import base.WebDriverUtil;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.McPizzaChatbotMainPage;

public class BackgroundSteps {

	private WebDriver _driver;
	
	private WebDriverUtil _webdriverUtil;
	
	McPizzaChatbotMainPage mcPizzaChatbotMainPage; 
	
	public BackgroundSteps(WebDriverUtil webdriverUtil) 
	{
		this._webdriverUtil = webdriverUtil;
	}
	
	@Given("Navigating to Avaamo chatbot website for a given browser")
	public void navigating_to_avaamo_chatbot_website_for_a_given_browser(DataTable dataTable) {
		List<String> data = dataTable.asList();
		_webdriverUtil.setDriver(data.get(1));
		_driver = _webdriverUtil.getDriver();
		_driver.navigate().to("https://c6.avaamo.com/web_channels/c767654d-6709-43f6-bb0c-ce1d2c559f6a/demo.html?banner=true&demo=true&banner_text=%20&banner_title=This%20is%20how%20the%20chat%20agent%20shows%20up");	
	}
	
	@Given("Navigating to Avaamo chatbot website")
	public void navigating_to_avaamo_chatbot_website_for_a_given_browser() {
		_driver = _webdriverUtil.getDriver();
		_driver.navigate().to("https://c6.avaamo.com/web_channels/c767654d-6709-43f6-bb0c-ce1d2c559f6a/demo.html?banner=true&demo=true&banner_text=%20&banner_title=This%20is%20how%20the%20chat%20agent%20shows%20up");	
	}
}
