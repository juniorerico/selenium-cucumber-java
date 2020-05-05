package selenium_easy.step_definitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import factory.BrowserProvider;
import selenium_easy.pages.SeleniumEasyHomePage;
import selenium_easy.pages.SimpleFormDemoPage;

public class SeleniumEasySteps {
	private WebDriver driver = BrowserProvider.getDriver();
	private SeleniumEasyHomePage seleniumEasyHomePage;
	private SimpleFormDemoPage simpleFormDemoPage;

	@When("^I access the Selenium Easy page$")
	public void i_access_the_Selenium_Easy_page() throws Throwable {
		driver.navigate().to("https://www.seleniumeasy.com/test/");
		seleniumEasyHomePage = new SeleniumEasyHomePage(driver);
	}

	@When("^I move to the Simple Form Demo page$")
	public void i_move_to_the_Simple_Form_Demo_page() throws Throwable {
		simpleFormDemoPage = seleniumEasyHomePage.header().goToSimpleFormDemoPage();
	}

	@When("^I submit the message \"([^\"]*)\" in the form$")
	public void i_submit_the_message_in_the_form(String message) throws Throwable {
		simpleFormDemoPage.enterUserMessage(message);
	}

	@Then("^The message \"([^\"]*)\" should be displayed correctly$")
	public void the_message_should_be_displayed_correctly(String message) throws Throwable {
		Assert.assertTrue("Validade user message", simpleFormDemoPage.getUserMessage().equals(message));
	}
}
