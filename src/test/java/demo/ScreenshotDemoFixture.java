package demo;

import org.concordion.api.extension.ConcordionExtension;
import org.concordion.api.extension.Extension;
import org.concordion.ext.ScreenshotExtension;
import org.concordion.integration.junit4.ConcordionRunner;
import org.concordion.selenium.SeleniumScreenshotTaker;
import org.junit.runner.RunWith;

import demo.driver.google.web.GoogleResultsPage;
import demo.driver.google.web.GoogleSearchPage;

/**
 * A fixture class for the ScreenshotDemo.html specification.
 * <p>
 * This adds the Screenshot Extension to Concordion to include screenshots on error in the Concordion output.
 * <p>
 * By default this extension uses java.awt.Robot as a ScreenshotTaker. This takes a screenshot of the current desktop.
 * To include just the browser screen in the results, we set a custom {@link SeleniumScreenshotTaker} that take screenshots 
 * using WebDriver's TakesScreenshot interface.
 * <p>
 * Run this class as a JUnit test to produce the Concordion results.  The test is expected to fail, since Google Calculator 
 * doesn't special case the answer to life, the universe and everything.
 */
@RunWith(ConcordionRunner.class)
public class ScreenshotDemoFixture extends GoogleFixture {
	
    private SeleniumScreenshotTaker screenshotTaker = new SeleniumScreenshotTaker(browser);
    
    @Extension
    public ConcordionExtension extension; // = new ScreenshotExtension().setScreenshotTaker(screenshotTaker);
    
 	private GoogleResultsPage resultsPage;

 	public ScreenshotDemoFixture() {
 	    extension = new ScreenshotExtension().setScreenshotTaker(screenshotTaker);
    }

	/**
	 * Searches for the specified topic, and waits for the results page to load.
	 */
    public void searchFor(String topic) {
        searchPage = new GoogleSearchPage(browser); 
		resultsPage = searchPage.searchFor(topic);
	}
	
    /**
     * Returns the result from Google calculation.
     */
    public String getCalculatorResult() {
        return resultsPage.getCalculatorResult();
    }
}
