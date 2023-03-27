package pages;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

public class McPizzaOrderPizzaPage 
{
	WebDriver driver;
	
	WebDriverWait wait;
		
	@FindBy(id = "queryTextbox")
	WebElement QueryTextArea;
	
	@FindBy(xpath = "//strong[text()='I want to order pizza']")
	WebElement I_want_to_order_pizza_link;
	
	
	@FindBy(xpath = "//*[contains(@id,'message')]//p[contains(text(),'What would you like to Order')]")
	WebElement We_Have_VerityOfPizza_Txt;
	
	@FindBy(xpath = "//button[text()='Send']")
	WebElement Send_Btn;
	
	@FindBy(xpath = "//button[@class='btn default_card_submit']")
	WebElement Submit_Btn;
	
	@FindBy(xpath = "//div[@class='message-wrap']/p[contains(text(),'Your Pizza Will Look like this :')]")
	WebElement PizzaDetails;
	
	@FindBy(xpath = "//p[contains(text(),'CONGRATS')]")
	WebElement OrderPlacedMsg;
	
	@FindBy(xpath = "//input[@class='textbox picklist-textbox avm_pick_list_input']")
	WebElement FeedBackScale;
	
	@FindBy(xpath = "//div[@class='thankyou']")
	WebElement FeedBackSuccessTxt;
	
	@FindBy(xpath = "//input[@aria-label='Feedback to improve']")
	WebElement FeedbackImproveTxt;
	
	@FindBy(xpath = "//button[@class='thumbs-up']")
	WebElement ThumbsUp_Btn;
	
	@FindBy(xpath = "//button[@class='thumbs-down']")
	WebElement ThumbsDown_Btn;
	
	@FindBy(xpath = "//a[@class='quick-reply' and text()='veg' or text()='non-veg']")
	List<WebElement> Veg_Non_Veg_Quickreply_Links;
	
	public McPizzaOrderPizzaPage(WebDriver webdriver) 
	{
		this.driver = webdriver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		PageFactory.initElements(driver, this);
	}
	
	public WebElement Veg_NonVeg_QuickReply(String text)
	{
		WebElement quickReply= driver.findElement(By.xpath("//a[@class='quick-reply' and text()='"+text+"']"));
		return quickReply;
	}
	
	public WebElement Toppings(String toppingType)
	{
		WebElement topping= driver.findElement(By.xpath("//label[span[text()='"+toppingType+"']]/input"));
		return topping;
	}
	
	public WebElement PizzaBase(String base)
	{
		WebElement pizzaBase= driver.findElement(By.xpath("//a[@title='"+base+"']"));
		return pizzaBase;
	}
	
	public WebElement PizzaSize(String size)
	{
		WebElement pizzaSize= driver.findElement(By.xpath("//a[@title='"+size+"']"));
		return pizzaSize;
	}
	
	public WebElement QuickReply_Yes_or_No(String quickReply)
	{
		WebElement quickReply_Yes_No= driver.findElement(By.xpath("//a[@class='quick-reply' and @title='"+quickReply+"']"));
		return quickReply_Yes_No;
	}

	public void Click_I_want_to_order_pizza_link() 
	{
		I_want_to_order_pizza_link.click();
	}
	public void EnterQuestion(String queryText) 
	{
		QueryTextArea.clear();
		QueryTextArea.sendKeys(queryText);
	}
	
	public void Click_Send_Btn() throws InterruptedException 
	{
		Send_Btn.click();
		Thread.sleep(2999);
	}
	
	public boolean Validate_Veg_Non_Veg_Quickreply_Links_Present() 
	{
		int size = 0;
		try 
		{
			wait.until(ExpectedConditions.visibilityOfAllElements(Veg_Non_Veg_Quickreply_Links));
			ExtentCucumberAdapter.addTestStepLog(We_Have_VerityOfPizza_Txt.getText());
			size = Veg_Non_Veg_Quickreply_Links.size();
		}
		catch(Exception e) 
		{
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}
		return size==2;
	}
	
	public void SelectQueckReply(String vegOrNonVeg) 
	{
		Veg_NonVeg_QuickReply(vegOrNonVeg).click();
	}
	
	public void SelectToppings(String topping) 
	{
		Toppings(topping).click();
	}
	
	public void Click_Submit_Btn() 
	{
		Submit_Btn.click();
	}
	
	public void SelectPizzaBase(String baseType) 
	{
		PizzaBase(baseType).click();
	}
	
	public void SelectPizzaSize(String size) 
	{
		PizzaBase(size).click();
	}
	
	public void ValidatePizzaDetails() 
	{
		String pizzaDetails = PizzaDetails.getText();
	}
	
	public boolean ValidateOrderDetails(String pizzaType, String toppings, String crust, String size) 
	{
		String pizzaOrderDetails = PizzaDetails.getText();
		boolean result = pizzaOrderDetails.toLowerCase().contains(pizzaType.toLowerCase())
				      && pizzaOrderDetails.toLowerCase().contains(toppings.toLowerCase())
				      && pizzaOrderDetails.toLowerCase().contains(crust.toLowerCase())
				      && pizzaOrderDetails.toLowerCase().contains(size.toLowerCase());
		return result;
		
	}
	public void SelectQuickReply_Yes_No(String yesOrNo) 
	{
		QuickReply_Yes_or_No(yesOrNo).click();
	}
	
	
	public boolean ValidateOrderPlacedMsg(String orderCreatedMsg) 
	{
		String orderPlacedMsg = OrderPlacedMsg.getText();
		return orderPlacedMsg.toLowerCase().equals(orderCreatedMsg.toLowerCase());
	}
	
	public void Click_ThumbsUp_Btn() 
	{
		ThumbsUp_Btn.click();
	}
	
	public void Click_ThumbsDown_Btn() 
	{
		ThumbsDown_Btn.click();
	}
	
	public void Select_FeedBackScale(String scale) 
	{
		FeedBackScale.sendKeys(scale);
	}
	
	public void EnterFeedbackImproveTxt(String improveText) 
	{
		FeedbackImproveTxt.clear();
		FeedbackImproveTxt.sendKeys(improveText);
	}
	
	public boolean ValidateFeedBackSuccessTxt(String feedbacTxt) 
	{
		String feedBackSuccessMsg = FeedBackSuccessTxt.getText();
		return feedBackSuccessMsg.toLowerCase().equals(feedbacTxt.toLowerCase());
	}
	
	
}