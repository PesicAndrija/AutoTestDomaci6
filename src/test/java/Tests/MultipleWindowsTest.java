package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.MultipleWindowsPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class MultipleWindowsTest extends BaseTest {

    @BeforeMethod
    public void PageSetUp(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        jse = (JavascriptExecutor) driver;
        r = new Random();

        homePage =  new HomePage();
        multipleWindowsPage = new MultipleWindowsPage();

    }

    @Test(priority = 10)
    public void OpenRandomNumberOfNewWindows(){
        scrollIntoView(homePage.getLink("Multiple Windows"));
        homePage.clickOnLink("Multiple Windows");
        Assert.assertTrue(multipleWindowsPage.getOpenNewWindowButton().isDisplayed());
        int n = r.nextInt(15)+1;
        multipleWindowsPage.clickNTimesOnOpenNewWindowButton(n);
        Assert.assertEquals(driver.getWindowHandles().size(), n+1);
    }

    @AfterMethod
    public void tearDown(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
