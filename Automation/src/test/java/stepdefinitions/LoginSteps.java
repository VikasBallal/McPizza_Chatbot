package stepdefinitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import base.WebDriverUtil;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.McPizzaChatbotLoginPage;
import pages.McPizzaChatbotMainPage;

public class LoginSteps {

	private WebDriver _driver;
	
	McPizzaChatbotMainPage mcPizzaChatbotMainPage; 
	McPizzaChatbotLoginPage mcPizzaChatbotLoginPage;
	
	public LoginSteps(WebDriverUtil webdriverUtil) 
	{
		this._driver = webdriverUtil.getDriver();
		mcPizzaChatbotMainPage = new McPizzaChatbotMainPage(_driver);
		mcPizzaChatbotLoginPage = new McPizzaChatbotLoginPage(_driver);
	}
	
	@Given("I click on McPizza agent chatbot and start the chat")
	public void i_click_on_mc_pizza_agent_chatbot_and_start_the_chat() {
	    // Write code here that turns the phrase above into concrete actions
		mcPizzaChatbotMainPage.Click_McPizzaChat_Btn();
		mcPizzaChatbotMainPage.Click_GetStarted_Btn();
	}

	@When("I login to McPizza agent with <{string}> and <{string}>")
	public void i_login_to_mc_pizza_agent_with_and(String userName, String emailAddress) {
	    // Write code here that turns the phrase above into concrete actions
		mcPizzaChatbotLoginPage.SwitchToChatBotFrame();
		mcPizzaChatbotLoginPage.Enter_Username(userName);
		mcPizzaChatbotLoginPage.Enter_Emailaddress(emailAddress);
		mcPizzaChatbotLoginPage.Click_Next_Btn();
	}
	
	@When("I enter user name <{string}> and invalid email id<{string}>")
	public void i_enter_user_name_and_invalid_email_id(String userName, String emailAddress) {
	    // Write code here that turns the phrase above into concrete actions
		mcPizzaChatbotLoginPage.SwitchToChatBotFrame();
		mcPizzaChatbotLoginPage.Enter_Username(userName);
		mcPizzaChatbotLoginPage.Enter_Emailaddress(emailAddress);
		mcPizzaChatbotLoginPage.Click_Next_Btn();
	}
	
	@Then("I sould see an email validation alert for invalid email entered <{string}>")
	public void I_sould_see_an_email_validation_alert_for_invalid_email_entered(String invalidEmailMsg)
	{
		Assert.assertTrue(mcPizzaChatbotLoginPage.validateInvalidEmailMsg(invalidEmailMsg));
	}

	@Then("I sould land on welcome page with welcome message <{string}>")
	public void i_sould_land_on_welcome_page_with_welcome_message(String welcomeMsg) {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(mcPizzaChatbotLoginPage.validateWelcomeMsg(welcomeMsg));
	}
}
