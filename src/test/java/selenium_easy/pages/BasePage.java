package selenium_easy.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium_easy.components.SeleniumEasyHeader;

/**
 * Class to be extended by all Page Objects classes.
 * 
 * Contains common methods to be used by every page.
 * 
 * @author ejunior
 *
 */
public class BasePage {
	private WebDriver driver;
	private SeleniumEasyHeader header;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.header = new SeleniumEasyHeader(driver);
	}

	/**
	 * Get the page header
	 * 
	 * @return
	 */
	public SeleniumEasyHeader header() {
		return header;
	}

	/**
	 * Get the page title
	 * 
	 * @return
	 */
	public String getTitle() {
		return driver.getTitle();
	}

	/**
	 * Get the current page url
	 * 
	 * @return
	 */
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	/**
	 * 
	 * @param driver
	 */
	public void waitPageLoad() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
				.executeScript("return document.readyState").equals("complete"));
	}
}
