package org.thetestingacademy.Selenium_Task;

import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SeleniumTask2_27Feb_TTA_Bank {

    @Owner("MrBhardwaj")
    @Test
    public  void bank_TTA() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.navigate().to("https://tta-bank-digital-973242068062.us-west1.run.app/");
        driver.get("https://tta-bank-digital-973242068062.us-west1.run.app/");

        WebElement label_TTA_Bank = driver.findElement(By.xpath("//div[contains(@class,'text-center')]/h1"));
        ////h1[contains(@class,'text-3xl font-bold text-slate-900')]
        Assert.assertEquals(label_TTA_Bank.getText(),"TTA Bank");
        TimeUnit.SECONDS.sleep(2);


        System.out.println("Click on Sign-Up and enter credentials");
        WebElement button_SignUp = driver.findElement(By.xpath("//button[text()='Sign Up']"));
        Assert.assertEquals(button_SignUp.getText(),"Sign Up");
        button_SignUp.click();
        TimeUnit.SECONDS.sleep(5);
        WebElement input_name = driver.findElement(By.xpath("//input[@type='text']"));
        input_name.sendKeys("John Do");
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("you@example11.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("12345");
        driver.findElement(By.xpath("//button[text()='Create Account']")).click();
        TimeUnit.SECONDS.sleep(2);
        Assert.assertEquals(driver.findElement(By.xpath("//h1[@class=\"text-2xl font-bold text-slate-800 capitalize\"]")).getText(),"Dashboard");

        System.out.println("Get Total Balance : Before Transfer");
        WebElement label_TotalBalance = driver.findElement(By.xpath("//h3[@class='mt-2 text-3xl font-bold']"));
        System.out.println(label_TotalBalance.getText());

        System.out.println("Click on Setting Section");
        driver.findElement(By.xpath("//button[text()='Settings']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//h3[@class='text-lg font-semibold text-slate-800']")).getText(),"Personal Details");
        Assert.assertEquals(driver.findElement(By.xpath("//input[@name='name']")).getAttribute("value"),"John Do");
        Assert.assertEquals(driver.findElement(By.xpath("//input[@name='email']")).getAttribute("value"),"you@example11.com");


        System.out.println("Click on Transfer Funds Section");
        driver.findElement(By.xpath("//button[text()='Transfer Funds']")).click();
        driver.findElement(By.xpath("//input[@type='number']")).sendKeys("10");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Just For Testing");
        driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();

        System.out.println("Verify transfer details and confirm tranfer");
        Assert.assertEquals(driver.findElement(By.xpath("//h3[@class='mb-1 text-xl font-bold text-slate-900']")).getText(),"Review Transfer");
        System.out.println(driver.findElement(By.xpath("(//span[@class='text-xl font-bold text-slate-800'])[2]")).getText());
        Assert.assertTrue(driver.findElement(By.xpath("(//span[@class='text-xl font-bold text-slate-800'])[2]")).getText().contains("10.00"));
        driver.findElement(By.xpath("//button[text()='Confirm Transfer']")).click();

        System.out.println("Click on Dashboard Section");
        driver.findElement(By.xpath("//button[text()='Dashboard']")).click();
        Thread.sleep(1000);
        System.out.println("Get Total Balance : After Transfer");
        WebElement label_TotalBalanceAfter = driver.findElement(By.xpath("//h3[@class='mt-2 text-3xl font-bold']"));
        System.out.println(label_TotalBalanceAfter.getText());
        Assert.assertTrue(label_TotalBalanceAfter.getText().contains("49,990.00"));
























    }

}
