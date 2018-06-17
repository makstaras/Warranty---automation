package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    WebDriver driver;
    
    By namePortal = By.name("loginPage:j_id1:loginComponent:loginForm:username");
    By passwordPortal = By.name("loginPage:j_id1:loginComponent:loginForm:password");
    By titleText = By.className("login-copy");
    By login = By.name("loginPage:j_id1:loginComponent:loginForm:loginButton");

    public Login(WebDriver driver){
        this.driver = driver;
    }
    //Set user name in textbox
    public void setUserName(String strUserName){
        driver.findElement(namePortal).sendKeys(strUserName);
    }
    //Set password in password textbox
    public void setPassword(String strPassword){
         driver.findElement(passwordPortal).sendKeys(strPassword);
    }
    //Click on login button
    public void clickLogin(){
         driver.findElement(login).click();
    }
    //Get the title of Login Page
    public String getLoginTitle(){
    	 return driver.findElement(titleText).getText();
    }
    /**
     * This POM method will be exposed in test case to login in the application
     * @param strUserName
     * @param strPasword
     * @return
     */
    public void loginToPortal(String strUserName,String strPasword){
        //Fill user name
        this.setUserName(strUserName);
        //Fill password
        this.setPassword(strPasword);
        //Click on Login button
        this.clickLogin();          
    }
}