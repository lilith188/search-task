package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver webDriver) {
        super(webDriver);
        visit("https://www.google.com");
    }

    private By inputLocator = By.cssSelector("input#lst-ib");
    private By searchBtnLocator = By.cssSelector("input[name='btnK']");
    private By searchResult = By.cssSelector("div[class='_NId']:first-child");



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

    public boolean rightResult(){
      return find(searchResult).toString().contains("Armenia - Wikipedia");
   }
}


