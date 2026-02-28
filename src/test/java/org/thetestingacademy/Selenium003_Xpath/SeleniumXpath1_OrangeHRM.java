package org.thetestingacademy.Selenium003_Xpath;

import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SeleniumXpath1_OrangeHRM {

    @Owner("MrBhardwaj")
    @Test
    public  void  test_ORHM_Login(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement input_UserName =  driver.findElement(By.xpath("//input[@name=\"username\"]"));
        WebElement input_Password =  driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement button_Login = driver.findElement(By.xpath("//button[normalize-space()= \"Login\"]"));
       //WebElement button_Login = driver.findElement(By.xpath("//button[(text()= ' Login ')]"));

        input_UserName.sendKeys("admin");
        input_Password.sendKeys("Hacker@4321");
        button_Login.click();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

       // WebElement h6 = driver.findElement(By.xpath("//h6[@class=\"oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module\"]"));
        WebElement h6 = driver.findElement(By.xpath("//span[@class=\"oxd-topbar-header-breadcrumb\"]/h6"));
        Assert.assertEquals(h6.getText(),"PIM");
        driver.quit();




    }




}
