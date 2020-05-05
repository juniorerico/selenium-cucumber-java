package selenium_easy.components;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium_easy.pages.SimpleFormDemoPage;
import utils.SeleniumUtils;

/**
 * This class represents the header of the Selenium Easy web site that is
 * present in all pages
 * 
 * @author ejunior
 *
 */
public class SeleniumEasyHeader {
	private WebDriver driver;

	private By linkInputForms = By.xpath("//div[@id='navbar-brand-centered']//a[contains(text(),'Input Forms')]");
	private By linkSimpleFormDemo = By.xpath("//div[@id='navbar-brand-centered']//a[contains(text(),'Simple Form Demo')]");
	
	/**
	 * Constructor of the page.
	 * 
	 * @param driver
	 */
	public SeleniumEasyHeader(WebDriver driver) {
		this.driver = driver;

		assertTrue(SeleniumUtils.findElement(driver, linkInputForms) != null);
	}

	/**
	 * Click on the "Selenium Form Demo" link in the dropdown menu
	 * 
	 * @return the next page
	 */
	public SimpleFormDemoPage goToSimpleFormDemoPage() {
		SeleniumUtils.findElement(driver, linkInputForms).click();
		SeleniumUtils.waitForElementToBeClickable(driver, linkSimpleFormDemo).click();

		return new SimpleFormDemoPage(driver);
	}
}
