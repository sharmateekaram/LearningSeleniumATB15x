package org.thetestingacademy.Selenium002_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumLocator1_IdName {

    @Test
    public void login() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com/");
        WebElement emailInputBox = driver.findElement(By.id("login-username"));
        emailInputBox.sendKeys("admin@admin.com");

        WebElement passwordInputBox = driver.findElement(By.name("password"));
        passwordInputBox.sendKeys("admin@adm11in.com");

        WebElement subitButton = driver.findElement(By.id("js-login-btn"));
        subitButton.click();

        Thread.sleep(5000);

        WebElement errorMessage = driver.findElement(By.className("notification-box-description"));
        System.out.println(errorMessage.getText());

        Assert.assertEquals(errorMessage.getText(),"Your email, password, IP address or location did not match");

        // WebElement errorMessage By.Class

        driver.quit();






    }


}
