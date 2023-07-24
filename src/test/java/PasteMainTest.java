import ICanWin.PasteMainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PasteMainTest {
    private WebDriver driver;

    @BeforeMethod
    private void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    private void launchTheScript(){
         new PasteMainPage(driver)
                 .openURL()
                 .clickAcceptButton()
                 .clickAcceptAllButton()
                 .enterText()
                 .selectExpiration()
                 .enterName();
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    private void closeDriver(){
        driver.quit();
    }
}
