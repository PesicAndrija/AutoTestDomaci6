package Tests;

import Base.BaseTest;
import Pages.CheckboxesPage;
import Pages.HomePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class CheckboxesTest extends BaseTest {

    @BeforeMethod
    public void PageSetUp(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        jse = (JavascriptExecutor) driver;

        homePage =  new HomePage();
        checkboxesPage =  new CheckboxesPage();

    }

    @Test(priority = 10)
    public void CheckAllCheckboxes(){

        scrollIntoView(homePage.getLink("Checkboxes"));
        homePage.clickOnLink("Checkboxes");
        Assert.assertFalse(checkboxesPage.getCheckboxes().isEmpty());
        checkboxesPage.checkAllCheckboxes();
        for(WebElement pivot: checkboxesPage.getCheckboxes())
            Assert.assertTrue(pivot.isSelected());

    }

    @Test(priority = 20)
    public void UncheckAllCheckboxes(){
        scrollIntoView(homePage.getLink("Checkboxes"));
        homePage.clickOnLink("Checkboxes");
        checkboxesPage.uncheckAllCheckboxes();
        for(WebElement pivot: checkboxesPage.getCheckboxes())
            Assert.assertFalse(pivot.isSelected());
    }

    @AfterMethod
    public void tearDown(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
