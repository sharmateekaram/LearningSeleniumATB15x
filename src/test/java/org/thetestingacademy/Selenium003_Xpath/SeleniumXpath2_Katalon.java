package org.thetestingacademy.Selenium003_Xpath;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumXpath2_Katalon {



    @Owner("MrBhardwaj")
    @Description("Using  XPATH Click on the Make appointment button, enter the username, password given")
    @Test
    public void KatalonPage() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        driver.findElement(By.xpath("//a[@href=\"./profile.php#login\"]")).click();
        //a[@id="btn-make-appointment"]

        Thread.sleep(5000);
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));

        driver.findElement(By.xpath("//input[@id='txt-username']")).sendKeys("John Doe");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
        Thread.sleep(2000);

        Assert.assertTrue(driver.getCurrentUrl().contains("appointment"));
        WebElement labelText = driver.findElement(By.xpath("//div[@class='col-sm-12 text-center']/h2"));
        System.out.println(labelText.getText());


        Assert.assertEquals(labelText.getText(),"Make Appointment");



        driver.quit();



    }



}
