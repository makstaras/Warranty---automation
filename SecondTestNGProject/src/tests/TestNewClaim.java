package tests;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Homepage;
import pages.Login;
public class TestNewClaim {
    WebDriver driver;
    Login objLogin;
    Homepage objHomePage;
    
    @BeforeTest
    public void setup(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://uat-meritagehomes.cs30.force.com/homebuyersportal/MyMeritage");
        objLogin = new Login(driver);
        //verify login page title
        String loginPageTitle = objLogin.getLoginTitle();
        Assert.assertTrue(loginPageTitle.toLowerCase().contains("welcome to mymeritage"));
        //login to the Buyer Portal
        objLogin.loginToPortal("coddy.coddyson@mbuyer.com", "Meritage173");
        objHomePage = new Homepage(driver);
        //verify home page
        Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("your new home construction is made up of nine distinct stages"));
    }  
   
    @Test(priority = 0)
    public void support() {
          driver.findElement(By.linkText("My Warranty")).click();//*[@id=\"j_id0:j_id1:j_id320\"]/div/button/i
          driver.findElement(By.xpath("//*[@id=\"j_id0:j_id1:j_id297\"]/div/button/i")).click();
          driver.findElement(By.id("j_id0:j_id1:issueform:newWorkOrders:0:issueTextarea")).sendKeys("Test111");
          driver.findElement(By.xpath("//*[@id=\"j_id0:j_id1:issueform:dayPanel\"]/div[3]/label/input")).click();
          driver.findElement(By.id("j_id0:j_id1:issueform:addIssue")).click();
          driver.findElement(By.id("j_id0:j_id1:issueform:newWorkOrders:1:issueTextarea")).sendKeys("Test222");
          driver.findElement(By.id("submitClaim")).click();       
    }
    

}