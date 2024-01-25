package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddRemoveElementsPage extends BaseTest {

    public AddRemoveElementsPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(text(), 'Add Element')]")
    public WebElement addElementButton;

    @FindBy(className = "added-manually")
    public List<WebElement> deleteButtons;

    //---------------------------------------------------------------

    public WebElement getAddElementButton(){
        return addElementButton;
    }

    public void clickOnAddElementButton(){
        getAddElementButton().click();
    }

    public void addNumberOfElements(int n){
        for(int i=0; i<n; i++)
            clickOnAddElementButton();
    }

    public List<WebElement> getDeleteButtons(){
        return deleteButtons;
    }

    public WebElement getNthDeleteButton(int n){
        return getDeleteButtons().get(n);
    }

    public void removeAllDeleteButtons(){
        for(WebElement pivot:getDeleteButtons())
            pivot.click();
    }

    public void removeNthDeleteButton(int n){
        getNthDeleteButton(n).click();
    }

    public void removeNumberOfDeleteButtons(int n){
        for(int i=0; i<n; i++)
            getNthDeleteButton(0).click();
    }
}
