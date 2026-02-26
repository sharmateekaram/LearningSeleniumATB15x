package org.thetestingacademy.Selenium001_Basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumChangeBrowser {
    //interview : can open multiple browser using same driver object? Yes
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://vwo.com/");
        driver.quit();

        driver = new FirefoxDriver();
        driver.get("https://vwo.com/");
       // driver.quit();

        driver = new EdgeDriver();
        driver.navigate().to("https://vwo.com/");
        driver.navigate().back();
        driver.navigate().refresh();
        driver.quit();


    }
}
