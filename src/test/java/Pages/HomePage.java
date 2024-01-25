package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BaseTest {

    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "li > a")
    public List<WebElement> links;

    //-------------------------------------------------------

    public List<WebElement> getLinks(){
        return links;
    }

    public WebElement getLink(String linkText){
        for(WebElement pivot:links)
            if(pivot.getText().equals(linkText))
                return pivot;
        return null;
    }

    public void clickOnLink(String linkText){
        getLink(linkText).click();
    }
}
