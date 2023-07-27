package ICanWin;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PasteMainPageWin extends AbstractPage{
    private static final String URL = "https://pastebin.com";

    @FindBy(xpath = "//textarea[@id='postform-text']")
    private WebElement textFiled;

    @FindBy(xpath = "//span[@id='select2-postform-expiration-container']")
    private WebElement dropdownMenu;

    @FindBy(xpath = "//ul[@class='select2-results__options']/li[text()='10 Minutes']")
    private WebElement time;

    @FindBy(xpath = "//input[@id='postform-name']")
    private WebElement nameFiled;

    @FindBy(xpath = "//button[normalize-space()='Create New Paste']")
    private WebElement buttonCreate;

    @FindBy(xpath = "//label[@for='paste-raw-on']")
    private WebElement switchSyntaxHighlighter;

    @FindBy(xpath = "//div[@class='source text']")
    private WebElement sourceText;

    public PasteMainPageWin(WebDriver driver){
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        builder = new Actions(driver);
        PageFactory.initElements(driver,this);
    }

    public PasteMainPageWin openURL(){
        driver.get(URL);
        return this;
    }

    public PasteMainPageWin clickAcceptButton(){
        wait
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By
                                .xpath("//button[@type='button']")))
                                .click();
        return this;
    }

    public PasteMainPageWin clickAcceptAllButton(){
        wait
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By
                                .xpath("//div[@class='qc-cmp2-buttons-desktop']/button[@mode='secondary']")))
                                .click();
        return this;
    }

    public PasteMainPageWin enterText(){
        textFiled.sendKeys("Hello from WebDriver");
        return this;
    }

    public PasteMainPageWin selectExpiration(){
        dropdownMenu.click();
        time.click();
        return this;
    }
    public PasteMainPageWin enterName(){
        nameFiled.sendKeys("helloweb");
        return this;
    }
    public PasteMainPageWin clickOnElementWithJS(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", buttonCreate);
        return this;
    }
    public PasteMainPageWin highlightElementWithJS(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 5px solid yellow;');",sourceText);
        return this;
    }
    public PasteMainPageWin pageDownAction(){
        builder.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).perform();
        return this;
    }
    public PasteMainPageWin switchSyntaxAction() {
        builder.click(switchSyntaxHighlighter);
        return this;
    }
}
