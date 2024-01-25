package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class MultipleWindowsPage extends BaseTest {

    public MultipleWindowsPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Click Here")
    public WebElement openNewWindowButton;

    //--------------------------------------------------

    public WebElement getOpenNewWindowButton(){
        return openNewWindowButton;
    }

    public void clickOnOpenNewWindowButton(){
        getOpenNewWindowButton().click();
    }

    public void clickNTimesOnOpenNewWindowButton(int n){
        for(int i=0; i<n; i++)
            clickOnOpenNewWindowButton();
    }
}
