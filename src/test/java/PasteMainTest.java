import BringItOn.PasteMainPageBring;
import ICanWin.PasteMainPageWin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
         new PasteMainPageWin(driver)
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

    @Test
    private void checkCreationPage(){
        String expectedPageTitle = "how to gain dominance among developers - Pastebin.com";
        String actualPageTitle = new PasteMainPageBring(driver)
                .openURL()
                .clickAcceptButton()
                .clickAcceptAllButton()
                .enterText()
                .selectSyntax()
                .selectExpiration()
                .enterName()
                .getPageTitle();

        String syntaxActual = new PasteMainPageBring(driver).getClassValue();

        String expectedText = new PasteMainPageBring(driver).getText();
        String actualText = new PasteMainPageBring(driver).getSourceText();

        Assert.assertEquals(actualPageTitle,expectedPageTitle,"Title is incorrect");
        Assert.assertEquals(syntaxActual,"bash","This is not a bash");
        Assert.assertEquals(actualText,expectedText,"Text is not equals");
    }

    @AfterMethod
    private void closeDriver(){
        driver.quit();
    }
}
