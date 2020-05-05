package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import enums.Browser;

/**
 * Class responsible to handle the WebDrivers.
 * 
 * @Todo Implement the logic to handle more than one driver.
 * 
 * @author ejunior
 *
 */
public class BrowserProvider {
	private static WebDriver driver = null;

	/**
	 * Create a driver with the given capabilities.
	 * 
	 * @param browser
	 * @param capabilities
	 * @return
	 */
	public static WebDriver createDriver(Browser browser, DesiredCapabilities capabilities) {
		capabilities.setBrowserName(browser.toString().toLowerCase());
		driver = browser.initialize(capabilities);
		return driver;
	}

	/**
	 * Create a driver with default capabilities.
	 * 
	 * @param browser
	 * @return
	 */
	public static WebDriver createDriver(Browser browser) {
		return createDriver(browser, new DesiredCapabilities());
	}

	/**
	 * Get the current driver
	 * 
	 * @return
	 */
	public static WebDriver getDriver() {
		return driver;
	}
}
