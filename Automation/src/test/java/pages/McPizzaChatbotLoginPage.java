package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

public class McPizzaChatbotLoginPage 
{
	WebDriver driver;
	
	@FindBy(id = "first_name")
	WebElement Username_Txtbox;
	
	@FindBy(id = "email")
	WebElement Emailaddress_Txtbox;
	
	@FindBy(xpath = "//button[text()='Next']")
	WebElement Next_Btn;
	
	@FindBy(xpath = "//*[@id='errors' and @class='profile-completion__errors']")
	WebElement InvalidEmailMsg;
	
	@FindBy(xpath = "//div[header[h1[text()='McPizza']]]//p")
	WebElement WelcomeMsg;
	
	public McPizzaChatbotLoginPage(WebDriver webdriver) 
	{
		this.driver = webdriver;
		PageFactory.initElements(driver, this);
	}
	
	public void SwitchToChatBotFrame() 
	{
		driver.switchTo().frame("avaamoIframe");
	}
	
	public void Enter_Username(String userName) 
	{
		Username_Txtbox.clear();
		Username_Txtbox.sendKeys(userName);
		
	}
	
	public void Enter_Emailaddress(String eMail) 
	{
		Emailaddress_Txtbox.clear();
		Emailaddress_Txtbox.sendKeys(eMail);
		
	}
	
	public void Click_Next_Btn() 
	{
		Next_Btn.click();
	}
	
	public boolean validateWelcomeMsg(String welcomeMsg) 
	{
		String welcomeMsgTxt = WelcomeMsg.getText().toString();
		ExtentCucumberAdapter.addTestStepLog(welcomeMsgTxt);
		return  welcomeMsgTxt.equalsIgnoreCase(welcomeMsg);
	}
	
	public boolean validateInvalidEmailMsg(String invalidEmailMsg) 
	{
		String invalidEmailTxt = InvalidEmailMsg.getText().toString();
		ExtentCucumberAdapter.addTestStepLog(invalidEmailTxt);
		return  invalidEmailTxt.equalsIgnoreCase(invalidEmailMsg);
		
	}
}