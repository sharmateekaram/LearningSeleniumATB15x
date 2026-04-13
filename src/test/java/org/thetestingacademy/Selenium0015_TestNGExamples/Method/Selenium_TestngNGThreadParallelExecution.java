package org.thetestingacademy.Selenium0015_TestNGExamples.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Selenium_TestngNGThreadParallelExecution {
    public WebDriver driver;

    @Test
    public void FirefoxTest() {
        System.out.println("The thread ID for Firefox is "+ Thread.currentThread().getId());
        //Initializing the firefox driver (Gecko)
        driver = new FirefoxDriver();
        driver.get("https://www.google.com");
        //driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div/div[1]")).click();
        driver.quit();
    }

    @Test
    public void ChromeTest()
    {
        System.out.println("The thread ID for Chrome is "+ Thread.currentThread().getId());
        //Initialize the chrome driver
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        //driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div/div[1]")).click();
        driver.quit();
    }
}
