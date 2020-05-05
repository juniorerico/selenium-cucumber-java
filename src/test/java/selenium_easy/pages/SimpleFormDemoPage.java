package selenium_easy.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniumUtils;

/**
 * Simple Form Demo Page of Selenium Easy web site.
 * 
 * @author ejunior
 *
 */
public class SimpleFormDemoPage extends BasePage {
	private WebDriver driver;

	private By inputUserMessage = By.id("user-message");
	private By btnShowMessage = By.xpath("//*[@id='get-input']/button");
	private By spanUserMessage = By.id("display");

	/**
	 * Constructor of the page.
	 * 
	 * @param driver
	 */
	public SimpleFormDemoPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		
		Assert.assertTrue(SeleniumUtils.findElement(driver, inputUserMessage) != null);
	}

	/**
	 * Enter a message in the form field and click in the show message button.
	 * 
	 * @param message
	 */
	public void enterUserMessage(String message) {
		SeleniumUtils.waitForElement(driver, inputUserMessage).sendKeys(message);
		SeleniumUtils.waitForElement(driver, btnShowMessage).click();
	}
	
	/**
	 * Get the message displayed in the span element
	 * 
	 * @return
	 */
	public String getUserMessage() {
		return SeleniumUtils.findElement(driver, spanUserMessage).getText();
	}
}
