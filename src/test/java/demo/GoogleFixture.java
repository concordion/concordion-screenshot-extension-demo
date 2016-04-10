package demo;

import org.concordion.integration.junit4.ConcordionRunner;
import org.concordion.selenium.Browser;
import org.junit.After;
import org.junit.runner.RunWith;

import demo.driver.google.web.GoogleSearchPage;

/** 
 * A base class for Google search tests that opens up the Google site
 * at the Google search page, and closes the browser once the test is complete.
 */
@RunWith(ConcordionRunner.class)
public abstract class GoogleFixture {

	protected Browser browser;
	protected GoogleSearchPage searchPage;

    GoogleFixture() {
		browser = new Browser();
	}
	
	@After
	public void close() {
		browser.close();
	}
}
