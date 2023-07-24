package ICanWin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PasteMainPage {
    private static final String URL = "https://pastebin.com";
    private WebDriver driver;

    private WebDriverWait wait;

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

    public PasteMainPage(WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    public PasteMainPage openURL(){
        driver.get(URL);
        return this;
    }

    public PasteMainPage clickAcceptButton(){
        wait
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By
                                .xpath("//button[@type='button']")))
                                .click();
        return this;
    }

    public PasteMainPage clickAcceptAllButton(){
        wait
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By
                                .xpath("//div[@class='qc-cmp2-buttons-desktop']/button[@mode='secondary']")))
                                .click();
        return this;
    }

    public PasteMainPage enterText(){
        textFiled.sendKeys("Hello from WebDriver");
        return this;
    }

    public PasteMainPage selectExpiration(){
        dropdownMenu.click();
        time.click();
        return this;
    }

    public PasteMainPage enterName(){
        nameFiled.sendKeys("helloweb");
        buttonCreate.click();
        return this;
    }
}
