package tests;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
@Test
public class TestCaseLoginLinks {
    public String baseUrl = "https://uat-meritagehomes.cs30.force.com/homebuyersportal/MyMeritage";
    String driverPath = "C:\\geckodriver.exe";
    public WebDriver driver; 
    public String expected = null;
    public String actual = null;
       
      @BeforeTest
      public void launchBrowser() {
          System.out.println("launching firefox browser"); 
          System.setProperty("webdriver.firefox", driverPath);
          driver= new FirefoxDriver();
          driver.get(baseUrl);
      }
      
      @BeforeMethod
      public void verifyHomepageTitle() {
          String expectedTitle = "Site Login ~ Home Buyers Portal";
          String actualTitle = driver.getTitle();
          Assert.assertEquals(actualTitle, expectedTitle);
      }
      
      @Test(priority = 0)
      public void register(){
          driver.findElement(By.linkText("Forgot Your Password?")).click() ;
          Assert.assertTrue(driver.findElement(By.id("forgotPassword:theForm")).isDisplayed());
      }
      
      @Test(priority = 1)
      public void support() {
            driver.findElement(By.linkText("New User?")).click() ;
            Assert.assertTrue(driver.findElement(By.id("j_id0:j_id8:j_id9:autoCompleteForm")).isDisplayed()); 
      }
      
      @AfterMethod
      public void goBackToHomepage ( ) {
            driver.navigate().back();
      }
       
      @AfterTest
      public void terminateBrowser(){
          driver.quit();
      }
}