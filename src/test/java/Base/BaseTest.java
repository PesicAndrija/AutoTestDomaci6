package Base;

import Pages.AddRemoveElementsPage;
import Pages.CheckboxesPage;
import Pages.HomePage;
import Pages.MultipleWindowsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.Random;


public class BaseTest {

    public static WebDriver driver;
    public JavascriptExecutor jse;
    public HomePage homePage;
    public AddRemoveElementsPage addRemoveElementsPage;
    public Random r;
    public CheckboxesPage checkboxesPage;
    public MultipleWindowsPage multipleWindowsPage;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
    }

    @AfterClass
    public void tearDown(){
        //driver.manage().deleteAllCookies();
        //driver.quit();
    }

    public void scrollIntoView(WebElement webElement){
        jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()", webElement);
    }
}
