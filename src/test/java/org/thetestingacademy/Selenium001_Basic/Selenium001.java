package org.thetestingacademy.Selenium001_Basic;

import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium001 {

    public static void main(String[] args) {

        // Source here ->  (nagivate to the google.com)
        //  Converted -> JSON Wireprotocol | HTTP Request | api request)
        //  Browser Driver | Server ( application running on a particulr port)
        // Browser Driver -> Real Driver(


        ChromeDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com/");

    }
}
