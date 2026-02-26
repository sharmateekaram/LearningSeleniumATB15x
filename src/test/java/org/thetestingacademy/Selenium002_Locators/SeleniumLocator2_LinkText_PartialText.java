package org.thetestingacademy.Selenium002_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumLocator2_LinkText_PartialText {

    @Test
    public void Login(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com/");

        WebElement linkText = driver.findElement(By.linkText("Start a free trial"));
        linkText.click();

        //        WebElement partialLinkText = driver.findElement(By.linkText("Start a free trial"));
        //        partialLinkText.click();

        driver.quit();


    }

}
