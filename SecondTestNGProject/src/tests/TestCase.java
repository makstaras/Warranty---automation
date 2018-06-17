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
public class TestCase {
    WebDriver driver;
    Login objLogin;
    Homepage objHomePage;
    
    @BeforeTest
    public void setup(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://uat-meritagehomes.cs30.force.com/homebuyersportal/MyMeritage");
    }
   
    @Test(priority=0)
    	public void test_Home_Page_Appear_Correct(){
        //Create Login Page object
    	objLogin = new Login(driver);
    	//Verify login page title
    	String loginPageTitle = objLogin.getLoginTitle();
    	Assert.assertTrue(loginPageTitle.toLowerCase().contains("welcome to mymeritage"));
    	//login to application
    	objLogin.loginToPortal("coddy.coddyson@mbuyer.com", "Meritage173");
    	// go the next page
    	objHomePage = new Homepage(driver);
    	//Verify home page
    	Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("your new home construction is made up of nine distinct stages"));
    }
    
    @AfterTest
    public void terminateBrowser(){
        driver.quit();
    }
}