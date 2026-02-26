package org.thetestingacademy.Selenium01_Basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumNO_http {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        //Interview : it won't open the url as it always open secure which i sonly https
        driver.get("www.vwo.com/");
        driver.quit();
    }
}
