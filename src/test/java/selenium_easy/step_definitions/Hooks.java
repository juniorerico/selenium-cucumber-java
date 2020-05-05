package selenium_easy.step_definitions;

import cucumber.api.java.After;
import factory.BrowserProvider;

public class Hooks {
	@After
	public void closeBrowsers() {
		BrowserProvider.getDriver().quit();
	}
}
