package org.thetestingacademy.Selenium001_Basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumBrowser {

    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();
        driver.get("https://vwo.com/");

        driver.manage().window().maximize();
        driver.manage().window().minimize();
        driver.manage().window().fullscreen();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
       // System.out.println(driver.getPageSource());
        System.out.println(driver.getWindowHandles());
        System.out.println(driver.getWindowHandle());
        driver.quit();

        WebDriver driver1 = new ChromeDriver();
        driver1.manage().window().maximize();
        driver1.navigate().to("https://google.com/");
        driver1.navigate().back();
        driver1.navigate().back();
        driver1.navigate().forward();
        driver1.quit();
    }


}
