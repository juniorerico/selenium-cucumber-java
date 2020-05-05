package selenium_easy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniumUtils;

/**
 * Home Page of Selenium Easy web site.
 * 
 * @author ejunior
 *
 */
public class SeleniumEasyHomePage extends BasePage {
	private WebDriver driver;
	private By btnStartPractising = By.id("btn_basic_example");
	
	/**
	 * Constructor of the page.
	 * 
	 * @param driver
	 */
	public SeleniumEasyHomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	/**
	 * Click on the Start Practising button 
	 * 
	 */
	public void clickStartPractising() {
		SeleniumUtils.waitForElement(driver, btnStartPractising).click();
	}
}
