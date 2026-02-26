package org.thetestingacademy.Selenium002_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumLocator3_TagName {

    @Test
    public void Login(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://vwo.com/free-trial/");

        Assert.assertTrue(driver.getCurrentUrl().contains("free-trial"));

        driver.findElement(By.id("page-v1-step1-email")).sendKeys("abc");
        driver.findElement(By.name("gdpr_consent_checkbox")).click();
        driver.findElement(By.tagName("button")).click();

        driver.quit();
    }
}
