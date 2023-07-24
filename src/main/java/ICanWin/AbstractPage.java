package ICanWin;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
    private WebDriver driver;

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
