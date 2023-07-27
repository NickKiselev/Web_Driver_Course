package ICanWin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions builder;
    protected static final String URL = "https://pastebin.com";

    public AbstractPage(WebDriver driver){
        this.driver=driver;
    }

    public AbstractPage openURL(){
        return this;
    };

    public AbstractPage enterText(){
        return this;
    };

    public AbstractPage clickAcceptButton(){
        return this;
    };

    public AbstractPage clickAcceptAllButton(){
        return this;
    }

    public AbstractPage enterName(){
        return this;
    }
}
