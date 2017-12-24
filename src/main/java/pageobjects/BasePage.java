package pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {

    private WebDriver driver;

    public BasePage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public void visit(String url) {
        driver.get(url);
    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public WebElement find(String cssSelector) {
        return find(By.cssSelector(cssSelector));
    }

    public List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }

    public void click(By locator) {
        click(find(locator));
    }

    public void click(WebElement element) {
        element.click();
    }

    public void click(String cssSelector) {
        click(find(cssSelector));
    }


    public void type(By locator, String text) {
        type(find(locator), text);
    }

    public void type(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void type(String cssSelector, String text) {
        type(find(cssSelector), text);
    }

//    public boolean isDisplayed(WebElement element) {
//        return find(WebElement).isDisplayed();

    public boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }

    }

    public boolean isDisplayed(WebElement element, Integer timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    public boolean isNotDisplayed(WebElement element, Integer timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    public boolean isDisplayed(By locator) {
        return isDisplayed(find(locator));

    }

    public boolean isDisplayed(String cssSelector) {
        return isDisplayed(find(cssSelector));

    }
}