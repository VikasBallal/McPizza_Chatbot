package stepdefinitions;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import base.WebDriverUtil;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.McPizzaOrderPizzaPage;

public class PizzaOrderingSteps {

	private WebDriver _driver;
	
	McPizzaOrderPizzaPage mcPizzaOrderPizzaPage; 
	
	public PizzaOrderingSteps(WebDriverUtil webdriverUtil) 
	{
		this._driver = webdriverUtil.getDriver();
		mcPizzaOrderPizzaPage = new McPizzaOrderPizzaPage(_driver);
	}
	
	@Given("I ask a question <{string}> to the chat bot")
	public void i_ask_a_question_to_the_chat_bot(String question) throws InterruptedException {
	    
		mcPizzaOrderPizzaPage.EnterQuestion(question);
		mcPizzaOrderPizzaPage.Click_I_want_to_order_pizza_link();
		mcPizzaOrderPizzaPage.Click_Send_Btn();
	}
	
	@Given("I enter a message and click on send")
	public void i_enter_a_message_and_click_on_send(DataTable dataTable) throws InterruptedException {
		List<String> data = dataTable.asList();
	    String message = data.get(1);
		mcPizzaOrderPizzaPage.EnterQuestion(message);
		mcPizzaOrderPizzaPage.Click_Send_Btn();
	}

	@When("I choose pizza type")
	public void i_choose_pizza_type(DataTable dataTable) {
	    List<String> data = dataTable.asList();
	    String pizzaType = data.get(1);
	    mcPizzaOrderPizzaPage.SelectQueckReply(pizzaType);
	}

	@Then("I should see selections for veg and non-veg pizza")
	public void i_should_see_selections_for_veg_and_non_veg_pizza() 
	{
		Assert.assertTrue(mcPizzaOrderPizzaPage.Validate_Veg_Non_Veg_Quickreply_Links_Present());
		 
	}
	@When("I choose pizza toppings as")
	public void i_choose_pizza_toppings(DataTable dataTable) {

		List<String> data = dataTable.asList();
		String toppings = data.get(1);
	    mcPizzaOrderPizzaPage.SelectToppings(toppings);
	}
	
	@When("I click on submit")
	public void i_click_on_submit() {
	    mcPizzaOrderPizzaPage.Click_Submit_Btn();
	}
	
	@When("I choose pizza base as")
	public void i_choose_pizza_base_as(DataTable dataTable) {

		List<String> data = dataTable.asList();
		String base = data.get(1);
	    mcPizzaOrderPizzaPage.SelectPizzaBase(base);
	}

	@When("I choose pizza size as")
	public void i_choose_pizza_size_as(DataTable dataTable) {

		List<String> data = dataTable.asList();
		String size = data.get(1);
	    mcPizzaOrderPizzaPage.SelectPizzaSize(size);
	}
	
	@Then("I should see the order details are matching with selections")
	public void i_should_see_the_order_details_are_matching_with_selections(DataTable dataTable) {

		List<String> data = dataTable.asList();
		String type = data.get(1);
		String toppings = data.get(2);
		String crust = data.get(3);
		String size = data.get(4);
	    Assert.assertTrue(mcPizzaOrderPizzaPage.ValidateOrderDetails(type, toppings, crust, size));
	}
	
	@When("I confirm the order details as <{string}>")
	public void i_confirm_the_order_details_as(String YesOrNo) {
		mcPizzaOrderPizzaPage.SelectQuickReply_Yes_No(YesOrNo);
	}

	@Then("I should see the order getting created successfully <{string}>")
	public void i_should_see_the_order_getting_created_successfully(String orderCreatedMsg) {
		Assert.assertTrue(mcPizzaOrderPizzaPage.ValidateOrderPlacedMsg(orderCreatedMsg));
	}
	
	@When("I click on thumbs up feedback button")
	public void i_click_on_thumbs_up_feedback_button() {
	    mcPizzaOrderPizzaPage.Click_ThumbsUp_Btn();
	}
	
	@When("I click on thumbs down feedback button")
	public void i_click_on_thumbs_down_feedback() {
	    mcPizzaOrderPizzaPage.Click_ThumbsDown_Btn();
	}
	@When("I select the feedback type")
	public void i_select_the_feedback_type(DataTable dataTable) {

		List<String> data = dataTable.asList();
		String feedBackType = data.get(1);
	    mcPizzaOrderPizzaPage.Select_FeedBackScale(feedBackType);
	}
	
	@When("I enter feedback improvement message <{string}>")
	public void i_enter_feedback_improvement_message(String improveMsg) 
	{
		mcPizzaOrderPizzaPage.EnterFeedbackImproveTxt(improveMsg);
	}
	@Then("I sould see <{string}> feedback message")
	public void i_should_see_feedback_message(String thankyoufeedbackMsg) {
		Assert.assertTrue(mcPizzaOrderPizzaPage.ValidateFeedBackSuccessTxt(thankyoufeedbackMsg));
	}
	
	
}
