package utils;

import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Utility class containing many static methods to help testing.
 * 
 * @author ejunior
 *
 */
public class SeleniumUtils {
	private static final int DEFAULT_WAIT_TIME = 20;

	/**
	 * Try to find an element in the page by given locator. If the element is not
	 * found, null is returned.
	 * 
	 * @param driver
	 * @param locator
	 * @return
	 */
	public static WebElement findElement(WebDriver driver, By locator) {
		try {
			return driver.findElement(locator);
		} catch (Exception e) {
//			System.out.println(e);
			return null;
		}
	}

	/**
	 * Try to find elements in the page by given locator. If the elements are not
	 * found, null is returned.
	 * 
	 * @param driver
	 * @param locator
	 * @return
	 */
	public static List<WebElement> findElements(WebDriver driver, By locator) {
		try {
			return driver.findElements(locator);
		} catch (Exception e) {
//			System.out.println(e);
			return null;
		}
	}

	/**
	 * Wait for an element to be visible on the screen, given a maximum time to wait
	 * 
	 * @param driver
	 * @param locator
	 * @param timeOutInSeconds
	 * @return
	 */
	public static WebElement waitForElementToBeVisible(WebDriver driver, By locator, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);

		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
//			System.out.println(e);
			return null;
		}
	}

	/**
	 * Wait for an element to be visible on the screen, using the DEFAULT_WAIT_TIME
	 * 
	 * @param driver
	 * @param locator
	 * @return
	 */
	public static WebElement waitForElementToBeVisible(WebDriver driver, By locator) {
		return waitForElementToBeVisible(driver, locator, DEFAULT_WAIT_TIME);
	}

	/**
	 * Wait for an element to be visible on the screen, given a maximum time to wait
	 * 
	 * @param driver
	 * @param locator
	 * @param timeOutInSeconds
	 * @return
	 */
	public static boolean waitForElementToBeInvisible(WebDriver driver, By locator, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);

		try {
			return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		} catch (Exception e) {
//			System.out.println(e);
			return false;
		}
	}

	/**
	 * Wait for an element to be visible on the screen, using the DEFAULT_WAIT_TIME
	 * 
	 * @param driver
	 * @param locator
	 * @return
	 */
	public static boolean waitForElementToBeInvisible(WebDriver driver, By locator) {
		return waitForElementToBeInvisible(driver, locator, DEFAULT_WAIT_TIME);
	}

	/**
	 * Wait for an element to be present in the DOM, given a maximum time to wait
	 * 
	 * @param driver
	 * @param locator
	 * @param timeOutInSeconds
	 * @return
	 */
	public static WebElement waitForElement(WebDriver driver, By locator, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		try {
			return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (Exception e) {
//			System.out.println(e);
			return null;
		}
	}

	/**
	 * Wait for an element to be present in the DOM, using the DEFAULT_WAIT_TIME
	 * 
	 * @param driver
	 * @param locator
	 * @return
	 */
	public static WebElement waitForElement(WebDriver driver, By locator) {
		return waitForElement(driver, locator, DEFAULT_WAIT_TIME);
	}

	/**
	 * Wait for at least one element to be present in the DOM, given a maximum time
	 * to wait
	 * 
	 * @param driver
	 * @param locator
	 * @param timeOutInSeconds
	 * @return
	 */
	public static List<WebElement> waitForElements(WebDriver driver, By locator, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		try {
			return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		} catch (Exception e) {
//			System.out.println(e);
			return null;
		}
	}

	/**
	 * Wait for at least one element to be present in the DOM, using the
	 * DEFAULT_WAIT_TIME
	 * 
	 * @param driver
	 * @param locator
	 * @return
	 */
	public static List<WebElement> waitForElements(WebDriver driver, By locator) {
		return waitForElements(driver, locator, DEFAULT_WAIT_TIME);
	}

	/**
	 * Wait for an element to be clickable, given a maximum time to wait
	 * 
	 * @param driver
	 * @param locator
	 * @param timeOutInSeconds
	 * @return
	 */
	public static WebElement waitForElementToBeClickable(WebDriver driver, By locator, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		try {
			return wait.until(ExpectedConditions.elementToBeClickable(locator));
		} catch (Exception e) {
//			System.out.println(e);
			return null;
		}
	}

	/**
	 * Wait for an element to be clickable, using the DEFAULT_WAIT_TIME
	 * 
	 * @param driver
	 * @param locator
	 * @return
	 */
	public static WebElement waitForElementToBeClickable(WebDriver driver, By locator) {
		return waitForElementToBeClickable(driver, locator, DEFAULT_WAIT_TIME);
	}

	/**
	 * Move the mouse to the middle of the element.
	 * 
	 * @param element
	 */
	public static void mouseOver(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
	}

	/**
	 * Scroll the element into the center of screen.
	 * 
	 * This method uses javascript to perform the scrolling.
	 * 
	 * @param driver
	 * @param element
	 */
	public static void scrollToElement(WebDriver driver, WebElement element) {
		String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
				+ "var elementTop = arguments[0].getBoundingClientRect().top;"
				+ "window.scrollBy(0, elementTop-(viewPortHeight/2));";

		((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);
	}

	/**
	 * Wait for the page to load for up to DEFAULT_WAIT_TIME
	 * 
	 * @param driver
	 */
	public void waitPageLoad(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_TIME);
		wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
				.executeScript("return document.readyState").equals("complete"));
	}

	/**
	 * Wait for a certain condition to occur for up to DEFAULT_WAIT_TIME
	 * 
	 * Usage: waitUntil(driver,
	 * ExpectedConditions.elementToBeClickable(By.xpath("/input[@id='q']")))
	 * 
	 * @param condition
	 * @return
	 */
	public static <T> T waitUntil(WebDriver driver, Function<? super WebDriver, T> condition) {
		return waitUntil(driver, condition, DEFAULT_WAIT_TIME);
	}

	/**
	 * Wait for a certain condition to occur for up to a given time in seconds
	 * 
	 * @param condition
	 * @param timeOutInSeconds
	 * @return
	 */
	public static <T> T waitUntil(WebDriver driver, Function<? super WebDriver, T> condition, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		return wait.until(condition);
	}
}
