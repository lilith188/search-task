package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver webDriver) {
        super(webDriver);
        visit("https://www.google.com");
    }

    private By inputLocator = By.cssSelector("input#lst-ib");
    private By searchBtnLocator = By.cssSelector("input[type='submit']");
    private By searchResult = By.cssSelector("div[class='_NId']:first-child");  //(//*[@class='r'])[1]



    public void clickSearchButton(){
        click(searchBtnLocator);
    }

    public void typeSearchInput(String input){
        type(inputLocator, input);
    }


  public void searchWith (String input) {
      typeSearchInput(input);
      clickSearchButton();
  }

public WebElement getFirstResult(){
        List<WebElement> elements = findElements(By.cssSelector(".rc .r"));
        return elements.get(0);
}

}


