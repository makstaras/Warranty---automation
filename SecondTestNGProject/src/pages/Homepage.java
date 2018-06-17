package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage {
    WebDriver driver;
    By homePageUserName = By.id("milestones");
    public Homepage(WebDriver driver){
        this.driver = driver;
    }
//Get the User name from Home Page
    public String getHomePageDashboardUserName(){
         return    driver.findElement(homePageUserName).getText();
    }
}
