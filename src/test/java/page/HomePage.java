package page;

import common.DriverHolder;
import elements.HomeElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends DriverHolder {
    String homeURL = "https://www.google.com/intl/ru/gmail/about/";
    public HomeElements elements= new HomeElements();

    public HomePage(WebDriver driver){
        super(driver);
    }

    public String getHomeURL(){
        return this.homeURL;
    }

    public void setHomeURL(String newURL){
        this.homeURL = newURL;
    }

    public LoginPage toLogin() {
        WebElement login = element(elements.signIn);
        login.click();
        return new LoginPage(driver);
    }
}
