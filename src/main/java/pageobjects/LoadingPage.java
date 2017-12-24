package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoadingPage extends BasePage {
    public LoadingPage(WebDriver webDriver) {
        super(webDriver);
        visit("http://the-internet.herokuapp.com/dynamic_loading/1");
    }

    private By startBtn = By.cssSelector("div[id='start'] button");
    private By finishText = By.id("finish");

    private By loadingText = By.id("loading");


    public void clickStart() {
        click(startBtn);
    }

    public boolean isFinishDisplayed() {
        return isDisplayed(find(finishText), 10);
    }

    public WebElement getFinish() {
        return find(finishText);
    }
}