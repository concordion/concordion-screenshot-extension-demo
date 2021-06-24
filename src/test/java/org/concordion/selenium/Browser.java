package org.concordion.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * Manages the browser session.
 */
public class Browser {
    static {
        WebDriverManager.chromedriver().setup();
    }

    private WebDriver driver;

    public Browser() {
        ChromeOptions options = new ChromeOptions();
        if (("true").equals(System.getenv("HEADLESS_CHROME"))) {
            options.addArguments("--headless");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
        }
        driver = new ChromeDriver(options);

        EventFiringWebDriver efwd = new EventFiringWebDriver(driver);
        efwd.register(new SeleniumEventLogger());
        driver = efwd;
    }

    public void close() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
