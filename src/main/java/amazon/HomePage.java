package amazon;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;
    private By acceptCookieSelector = By.cssSelector("[data-cel-widget=sp-cc-accept]");
    private By searchWithButtonSelector = By.cssSelector("[aria-label=Rechercher]");
    private By searchButtonSelector = By.cssSelector("[type=submit]");


    private final int TIMEOUT_COOKIE = 6;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void acceptCookie() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_COOKIE));
        WebElement buttonCookie = wait.until(ExpectedConditions.visibilityOfElementLocated(acceptCookieSelector));
        buttonCookie.click();
    }

    public void searchWithButton(String keyboard){
        WebElement searchBar = driver.findElement(searchWithButtonSelector);
        searchBar.sendKeys(keyboard);
        WebElement searchButton = driver.findElement(searchButtonSelector);
        searchButton.click();

    }
}
