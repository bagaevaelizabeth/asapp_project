package ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.ConfProperties;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver webDriver;

    @BeforeAll
    public static void prepareWebDriver() {
        WebDriverManager
                .chromedriver()
                .avoidResolutionCache()
                .setup();
    }

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--window-size=1920,1200");

        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterEach
    public void afterEachTest() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
