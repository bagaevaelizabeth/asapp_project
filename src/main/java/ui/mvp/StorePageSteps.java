package ui.mvp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class StorePageSteps {

    private static StorePageSteps storePageInstance;
    private WebDriver driver;

    private StorePageSteps(WebDriver driver) {
        this.driver = driver;
        initElements(driver, this);
    }

    public static StorePageSteps getInstance(WebDriver driver) {
        if (storePageInstance == null) {
            storePageInstance = new StorePageSteps(driver);
        }
        return storePageInstance;
    }

    @FindBy(xpath = "//*[contains(@class,'MuiTabs-flexContainer')]")
    WebElement header;

    public StorePageSteps checkHeaderIsDisplayed() {
        header.isDisplayed();
        return this;
    }

}
