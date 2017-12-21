import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.SearchPage;

import static org.testng.AssertJUnit.assertTrue;

public class SearchTest {

    private ChromeDriver driver;
    private SearchPage searchPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
//        driver.manage().window().maximize();

        driver = new ChromeDriver();
        searchPage = new SearchPage(driver);
    }
    @Test
    public void searchResult() throws InterruptedException {
        searchPage.searchWith("Armenia");
        Thread.sleep(3000);
        assertTrue("Search result not found",
                   searchPage.getFirstResult().getText().equals("Armenia - Wikipedia"));
    }
    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}
