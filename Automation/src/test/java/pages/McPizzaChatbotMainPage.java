package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class McPizzaChatbotMainPage 
{
	WebDriver driver;
	
	@FindBy(xpath = "//div[@aria-label='McPizza']")
	WebElement McPizzaChat_Btn;
	
	@FindBy(xpath = "//a[text()='Get Started']")
	WebElement GetStarted_Btn;
	
	public McPizzaChatbotMainPage(WebDriver webdriver) 
	{
		this.driver = webdriver;
		PageFactory.initElements(driver, this);
	}
	
	public void Click_McPizzaChat_Btn() 
	{
		McPizzaChat_Btn.click();
	}
	
	public void Click_GetStarted_Btn() 
	{
		GetStarted_Btn.click();
	}
	
}