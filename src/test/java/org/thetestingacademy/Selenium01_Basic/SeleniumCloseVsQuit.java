package org.thetestingacademy.Selenium01_Basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumCloseVsQuit {

    //interview :n Selenium, the key difference is that the **close()** method closes only the current,
    // focused browser window or tab, while the **quit()** method closes all windows associated with the WebDriver
    // instance and terminates the entire WebDriver session
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://vwo.com/");
        System.out.println("First tab title: " + driver.getTitle());
        String originalWindowHandle = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://opensource.saucelabs.com/");

        System.out.println("Second tab title: " + driver.getTitle());
        //driver.get("https://facebook.com/");
        //driver.get("https://google.com/");

        Thread.sleep(5000);

        driver.close();  //it  will only close this latest open tab and  not  close the browser
        //Note : if you have open any tab manual then it will not consider that(means it won't to close)
        // as it  will close only tab which is opened by  selenium


    }
}
