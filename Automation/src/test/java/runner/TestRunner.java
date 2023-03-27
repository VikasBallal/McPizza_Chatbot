package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features", 
glue={"stepdefinitions"},
tags = "@Login or @OrderVegPizza_QuickReplies or @OrderNonVegPizza_NoQuickReplies or @OrderVegPizza_ThumbsUpFeedback or @OrderNonVegPizza_ThumbsDownFeedback",
plugin={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class TestRunner {

}
