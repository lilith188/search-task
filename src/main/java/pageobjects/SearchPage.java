package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver webDriver) {
        super(webDriver);
        visit("https://www.google.com");
    }

    private By inputLocator = By.cssSelector("input#lst-ib");                         //*[@id='lst-ib']
    private By searchBtnLocator = By.cssSelector("input[name='btnK']");               //*[@value='Google Search'])[1]
    private By searchResult = By.cssSelector("div[class='_NId']:first-child");            //*[@class='lsb'])[1]



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


