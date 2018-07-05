package tests;

import common.User;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.HomePage;
import page.LoginPage;

import java.util.concurrent.TimeUnit;

public class TestLogin extends TestMethods{
    WebDriver driver = new ChromeDriver();




    @Test
    public void positiveLogin(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String email= "testyvalnik@gmail.com";
        String password = "test123test";

        HomePage homePage = new HomePage(driver);
        driver.get(homePage.getHomeURL());
        Assert.assertTrue(homePage.element(homePage.elements.logo).isDisplayed());

        LoginPage loginPage = homePage.toLogin();
        Assert.assertTrue(loginPage.element(loginPage.elements.emailInput).isDisplayed());

        User validUser = new User(email, password);
        loginPage.checkLogin(validUser);
        loginPage.checkPassword(validUser);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(driver.getCurrentUrl().equals("https://mail.google.com/mail/#inbox"));

        driver.quit();
    }

    @Test
    public void negativeEmail(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String wrongEmail= "wrong.testyvalnik@gmail.com";
        String password = "test123test";

        HomePage homePage = new HomePage(driver);
        driver.get(homePage.getHomeURL());
        Assert.assertTrue(homePage.element(homePage.elements.logo).isDisplayed());

        LoginPage loginPage = homePage.toLogin();
        Assert.assertTrue(loginPage.element(loginPage.elements.emailInput).isDisplayed());

        User invalidUser = new User(wrongEmail, password);
        loginPage.checkLogin(invalidUser);
        Assert.assertTrue(loginPage.element(loginPage.elements.assertArea).getText().length()!=0);
        driver.quit();
    }

    @Test
    public void negativePassword(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String email= "testyvalnik@gmail.com";
        String wrongPassword = "wrong password";

        HomePage homePage = new HomePage(driver);
        driver.get(homePage.getHomeURL());
        Assert.assertTrue(homePage.element(homePage.elements.logo).isDisplayed());

        LoginPage loginPage = homePage.toLogin();
        Assert.assertTrue(loginPage.element(loginPage.elements.emailInput).isDisplayed());

        User invalidUser = new User(email, wrongPassword);
        loginPage.checkLogin(invalidUser);
        loginPage.checkPassword(invalidUser);
        Assert.assertTrue(loginPage.element(loginPage.elements.assertArea).getText().length()!=0);
        driver.quit();
    }
}
