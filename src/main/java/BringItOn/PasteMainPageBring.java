package BringItOn;

import ICanWin.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PasteMainPageBring extends AbstractPage {
    private static final String URL = "https://pastebin.com";
    private WebDriver driver;
    private WebDriverWait wait;

    private String text = "\"git config --global user.name  \\\"New Sheriff in Town\\\"\\n\" +\n" +
            "\"git reset $(git commit-tree HEAD^{tree} -m \\\"Legacy code\\\")\\n\" +\n" +
            "\"git push origin master --force\"";

    @FindBy(xpath = "//textarea[@id='postform-text']")
    private WebElement textFiled;
    
    @FindBy(xpath = "//span[@id='select2-postform-format-container']")
    private WebElement formatContainer;

    @FindBy(xpath = "/html[1]/body[1]/span[2]/span[1]/span[2]/ul[1]/li[2]/ul[1]/li[1]")
    private WebElement syntaxFormat;

    @FindBy(xpath = "//span[@id='select2-postform-expiration-container']")
    private WebElement expirationContainer;

    @FindBy(xpath = "//ul[@class='select2-results__options']/li[text()='10 Minutes']")
    private WebElement timeDuration;

    @FindBy(xpath = "//input[@id='postform-name']")
    private WebElement nameFiled;

    @FindBy(xpath = "//button[normalize-space()='Create New Paste']")
    private WebElement buttonCreate;

    @FindBy(xpath = "//div[@class='source bash']/ol[@class='bash']")
    private WebElement sourceFormat;

    @FindBy(xpath = "//div[@class='source bash']")
    private WebElement sourceText;

    public PasteMainPageBring(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    public PasteMainPageBring openURL(){
        driver.get(URL);
        return this;
    }

    public PasteMainPageBring clickAcceptButton(){
        wait
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By
                                .xpath("//button[@type='button']")))
                .click();
        return this;
    }

    public PasteMainPageBring clickAcceptAllButton(){
        wait
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By
                                .xpath("//div[@class='qc-cmp2-buttons-desktop']/button[@mode='secondary']")))
                .click();
        return this;
    }

    public PasteMainPageBring enterText(){
        textFiled.sendKeys(text);
        return this;
    }

    public PasteMainPageBring selectSyntax(){
        formatContainer.click();
        syntaxFormat.click();
        return this;
    }

    public PasteMainPageBring selectExpiration(){
        expirationContainer.click();
        timeDuration.click();
        return this;
    }

    public PasteMainPageBring enterName(){
        nameFiled.sendKeys("how to gain dominance among developers");
        buttonCreate.click();
        return this;
    }

    public String getPageTitle(){
        wait.until(ExpectedConditions.titleIs("how to gain dominance among developers - Pastebin.com"));
        return driver.getTitle();
    }

    public String getClassValue(){
        return sourceFormat.getAttribute("class");
    }

    public String getSourceText(){
        return sourceText.getText();
    }

    public String getText() {
        return text;
    }
}
