package Tests;

import Base.BaseTest;
import Pages.AddRemoveElementsPage;
import Pages.HomePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class AddRemoveElementsTest extends BaseTest {

    @BeforeMethod
    public void PageSetUp(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        jse = (JavascriptExecutor) driver;
        r = new Random();

        homePage =  new HomePage();
        addRemoveElementsPage = new AddRemoveElementsPage();

    }

    @Test(priority = 10)
    public void addRandomNumberOfElements(){
        //jse.executeScript("arguments[0].scrollIntoView()", homePage.getLink("Add/Remove Elements"));
        scrollIntoView(homePage.getLink("Add/Remove Elements"));
        homePage.clickOnLink("Add/Remove Elements");
        Assert.assertTrue(addRemoveElementsPage.getAddElementButton().isDisplayed());
        int n = r.nextInt(15)+1;
        addRemoveElementsPage.addNumberOfElements(n);
        Assert.assertTrue(addRemoveElementsPage.getNthDeleteButton(0).isDisplayed());
        Assert.assertEquals(addRemoveElementsPage.getDeleteButtons().size(), n);
    }

    @Test(priority = 20)
    public void removeAllElements(){
        addRandomNumberOfElements();
        Assert.assertTrue(addRemoveElementsPage.getNthDeleteButton(0).isDisplayed());
        addRemoveElementsPage.removeAllDeleteButtons();
        Assert.assertEquals(addRemoveElementsPage.getDeleteButtons().size(), 0);
    }

    @AfterMethod
    public void tearDown(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
