package page;

import common.DriverHolder;
import common.User;
import elements.LoginElements;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;

public class LoginPage extends DriverHolder {
    public LoginElements elements = new LoginElements();

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void checkLogin(User user){
        WebElement field = element(elements.emailInput);
        field.clear();
        field.sendKeys(user.getEmail()+Keys.ENTER);
    }
    public void checkPassword(User user){
        Wait<WebDriver> wait = new WebDriverWait(driver, 2, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(element(elements.passInput)));
        WebElement field = element(elements.passInput);
        field.clear();
        field.sendKeys(user.getPassword()+Keys.ENTER);

    }
}
