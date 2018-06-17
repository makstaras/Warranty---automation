package tests;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Homepage;
import pages.Login;

public class TestCaseNotValidAutorization {
    WebDriver driver;
    Login objLogin;
    //Homepage objHomePage;
    
    @BeforeTest
    public void setup(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://uat-meritagehomes.cs30.force.com/homebuyersportal/MyMeritage");
    }
    
    @Test(priority=0)
    public void test_Home_Page_Appear_Correct(){
    	objLogin = new Login(driver);
    	//Verify login page title
    	String loginPageTitle = objLogin.getLoginTitle();
    	Assert.assertTrue(loginPageTitle.toLowerCase().contains("welcome to mymeritage"));
    	//login to application
    	objLogin.loginToPortal("", "");
    	//Verify login page
    	Assert.assertTrue(driver.findElement(By.id("loginPage:j_id1:loginComponent:loginForm:error:j_id3:j_id4:0:j_id5:j_id6:j_id8")).isDisplayed());
    }
    
    @AfterTest
    public void terminateBrowser(){
        driver.quit();
    }
}