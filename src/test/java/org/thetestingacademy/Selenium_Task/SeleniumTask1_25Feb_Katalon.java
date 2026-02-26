package org.thetestingacademy.Selenium_Task;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class SeleniumTask1_25Feb_Katalon {



    @Owner("MrBhardwaj")
    @Description("Click on the Make appointment button, enter the username, password given")
    @Test
    public void KatalonPage() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        driver.findElement(By.linkText("Make Appointment")).click();
        Thread.sleep(5000);
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));

        driver.findElement(By.id("txt-username")).sendKeys("John Doe");
        driver.findElement(By.name("password")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.id("btn-login")).click();
        Thread.sleep(2000);

        Assert.assertTrue(driver.getCurrentUrl().contains("appointment"));
        WebElement labelText = driver.findElement(By.tagName("h2"));
        System.out.println(labelText.getText());


        Assert.assertEquals(labelText.getText(),"Make Appointment");



        driver.quit();



    }



}
