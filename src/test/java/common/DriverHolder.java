package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DriverHolder {
    protected WebDriver driver;

    public DriverHolder(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement element(String xpath){
        return driver.findElement(By.xpath(xpath));
    }
}
