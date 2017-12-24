import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.LoadingPage;
import pageobjects.SearchPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoadingTest {
    private ChromeDriver driver;
    private LoadingPage dynamicLoadPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        dynamicLoadPage = new LoadingPage(driver);
    }
     @Test
     public void dynamicLoad(){
        dynamicLoadPage.clickStart();

        assertTrue(dynamicLoadPage.isFinishDisplayed());
        assertEquals(dynamicLoadPage.getFinish().getText(), "Hello World!");

     }

     @AfterMethod
     public void tearDown() {
         driver.close();
         driver.quit();
     }

    }
