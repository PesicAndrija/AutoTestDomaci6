package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckboxesPage extends BaseTest {
    public CheckboxesPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[type=\"checkbox\"]")
    public List<WebElement> checkboxes;

    //-----------------------------------------------------

    public List<WebElement> getCheckboxes(){
        return checkboxes;
    }

    public void checkAllCheckboxes(){
        for(WebElement pivot:checkboxes){
            if(pivot.isSelected())
                continue;
            pivot.click();
        }
    }

    public void uncheckAllCheckboxes(){
        for(WebElement pivot:checkboxes){
            if(!pivot.isSelected())
                continue;
            pivot.click();
        }
    }
}
