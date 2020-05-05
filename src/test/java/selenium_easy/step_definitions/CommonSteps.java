package selenium_easy.step_definitions;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import enums.Browser;
import factory.BrowserProvider;

public class CommonSteps {
	private WebDriver driver;

	@Given("^I open the \"([^\"]*)\" browser$")
	public void i_open_the_browser(String browser) throws Throwable {
		driver = BrowserProvider.createDriver(Browser.valueOf(browser.toUpperCase()));
		driver.manage().window().maximize();
	}
}
