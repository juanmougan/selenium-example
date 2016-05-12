package com.github.juanmougan;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by jmougan on 12/05/2016.
 */
public class SignInTestIT {

    @Test
    public void checkSeleniumHQinFirefox(){
        // Given
        WebDriver driver = new FirefoxDriver();
        driver.get("http://localhost:8080/merchantmanagement/public/security/login");
        // wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement username = driver.findElement(By.id("username"));
        username.clear();
        username.sendKeys("admin@admeris.com");
        WebElement password = driver.findElement(By.id("password"));
        password.clear();
        password.sendKeys("password");
        WebElement submitBtn = driver.findElement(By.id("submit"));
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        // When
        submitBtn.click();
        // Then
        wait.until(ExpectedConditions.urlToBe("http://localhost:8080/merchantmanagement/"));
        Assert.assertEquals("Merchant Management Console", driver.getTitle());
        driver.quit();
    }

}